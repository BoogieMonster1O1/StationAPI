/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.impl.lookup.block;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import net.modificationstation.stationapi.api.common.registry.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.item.Block;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.maths.Vec3i;

import net.fabricmc.fabric.api.lookup.v1.custom.ApiLookupMap;
import net.fabricmc.fabric.api.lookup.v1.custom.ApiProviderMap;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;

public final class BlockApiLookupImpl<A, C> implements BlockApiLookup<A, C> {
	private static final Logger LOGGER = LogManager.getLogger("fabric-api-lookup-api-v1/block");
	private static final ApiLookupMap<BlockApiLookup<?, ?>> LOOKUPS = ApiLookupMap.create(BlockApiLookupImpl::new);

	@SuppressWarnings("unchecked")
	public static <A, C> BlockApiLookup<A, C> get(Identifier lookupId, Class<A> apiClass, Class<C> contextClass) {
		return (BlockApiLookup<A, C>) LOOKUPS.getLookup(lookupId, apiClass, contextClass);
	}

	private final Class<A> apiClass;
	private final ApiProviderMap<BlockBase, BlockApiProvider<A, C>> providerMap = ApiProviderMap.create();
	private final List<BlockApiProvider<A, C>> fallbackProviders = new CopyOnWriteArrayList<>();

	@SuppressWarnings("unchecked")
	private BlockApiLookupImpl(Class<?> apiClass, Class<?> contextClass) {
		this.apiClass = (Class<A>) apiClass;
	}

	@Nullable
	@Override
	public A find(Level level, Vec3i pos, @Nullable BlockBase block, int meta, @Nullable TileEntityBase blockEntity, C context) {
		Objects.requireNonNull(level, "World may not be null.");
		Objects.requireNonNull(pos, "BlockPos may not be null.");
		// Providers have the final say whether a null context is allowed.

		// Get the block and the block entity
		if (blockEntity == null) {
			if (block == null) {
				block = BlockBase.BY_ID[level.getTileId(pos.x, pos.y, pos.z)];
			}

			if (block instanceof BlockWithEntity) {
				blockEntity = level.getTileEntity(pos.x, pos.y, pos.z);
			}
		} else {
			if (block == null) {
				block = blockEntity.getTile();
			}
		}

		@Nullable
		BlockApiProvider<A, C> provider = getProvider(block);
		A instance = null;

		if (provider != null) {
			instance = provider.find(level, pos, block, blockEntity, context);
		}

		if (instance != null) {
			return instance;
		}

		// Query the fallback providers
		for (BlockApiProvider<A, C> fallbackProvider : fallbackProviders) {
			instance = fallbackProvider.find(level, pos, block, blockEntity, context);

			if (instance != null) {
				return instance;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerSelf(BlockEntityType<?>... blockEntityTypes) {
		for (BlockEntityType<?> blockEntityType : blockEntityTypes) {
			BlockEntity blockEntity = blockEntityType.instantiate();
			Objects.requireNonNull(blockEntity, "Instantiated block entity may not be null.");

			if (!apiClass.isAssignableFrom(blockEntity.getClass())) {
				String errorMessage = String.format(
						"Failed to register self-implementing block entities. API class %s is not assignable from block entity class %s.",
						apiClass.getCanonicalName(),
						blockEntity.getClass().getCanonicalName()
				);
				throw new IllegalArgumentException(errorMessage);
			}
		}

		registerForBlockEntities((blockEntity, context) -> (A) blockEntity, blockEntityTypes);
	}

	@Override
	public void registerForBlocks(BlockApiProvider<A, C> provider, BlockBase... blocks) {
		Objects.requireNonNull(provider, "BlockApiProvider may not be null.");

		if (blocks.length == 0) {
			throw new IllegalArgumentException("Must register at least one Block instance with a BlockApiProvider.");
		}

		for (Block block : blocks) {
			Objects.requireNonNull(block, "Encountered null block while registering a block API provider mapping.");

			if (providerMap.putIfAbsent(block, provider) != null) {
				LOGGER.warn("Encountered duplicate API provider registration for block: " + Registry.BLOCK.getId(block));
			}
		}
	}

	@Override
	public void registerForBlockEntities(BlockEntityApiProvider<A, C> provider, BlockEntityType<?>... blockEntityTypes) {
		Objects.requireNonNull(provider, "BlockEntityApiProvider may not be null.");

		if (blockEntityTypes.length == 0) {
			throw new IllegalArgumentException("Must register at least one BlockEntityType instance with a BlockEntityApiProvider.");
		}

		BlockApiProvider<A, C> nullCheckedProvider = (world, pos, block, meta, blockEntity, context) -> {
			if (blockEntity == null) {
				return null;
			} else {
				return provider.find(blockEntity, context);
			}
		};

		for (BlockEntityType<?> blockEntityType : blockEntityTypes) {
			Objects.requireNonNull(blockEntityType, "Encountered null block entity type while registering a block entity API provider mapping.");

			Block[] blocks = ((BlockEntityTypeAccessor) blockEntityType).getBlocks().toArray(new Block[0]);
			registerForBlocks(nullCheckedProvider, blocks);
		}
	}

	@Override
	public void registerFallback(BlockApiProvider<A, C> fallbackProvider) {
		Objects.requireNonNull(fallbackProvider, "BlockApiProvider may not be null.");

		fallbackProviders.add(fallbackProvider);
	}

	@Nullable
	public BlockApiProvider<A, C> getProvider(BlockBase block) {
		return providerMap.get(block);
	}

	public List<BlockApiProvider<A, C>> getFallbackProviders() {
		return fallbackProviders;
	}
}
