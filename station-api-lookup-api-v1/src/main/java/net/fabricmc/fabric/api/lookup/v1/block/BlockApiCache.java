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

package net.fabricmc.fabric.api.lookup.v1.block;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Vec3i;

import net.fabricmc.fabric.impl.lookup.block.BlockApiCacheImpl;
import net.fabricmc.fabric.impl.lookup.block.BlockApiLookupImpl;

/**
 * A {@link BlockApiLookup} bound to a {@link Level} and a position, providing much faster API access.
 * Refer to {@link BlockApiLookup} for example code.
 *
 * <p>This object caches the block entity at the target position, and the last used API provider, removing those queries.
 * If a block entity is available or if the block state is passed as a parameter, the block state doesn't have to be looked up either.
 *
 * @param <A> The type of the API.
 * @param <C> The type of the additional context object.
 * @see BlockApiLookup
 */
public interface BlockApiCache<A, C> {
	/**
	 * Attempt to retrieve an API from a block in the world, using the world and the position passed at creation time.
	 *
	 * <p>Note: If the block state is known, it is more efficient to use {@link BlockApiCache#find(BlockBase, int, Object)}.
	 *
	 * @param context Additional context for the query, defined by type parameter C.
	 * @return The retrieved API, or {@code null} if no API was found.
	 */
	@Nullable
	default A find(C context) {
		return find(null, 0, context);
	}

	/**
	 * Attempt to retrieve an API from a block in the world, using the world and the position passed at creation time.
	 *
	 * @param block The block at the target position, or null if unknown.
	 * @param context Additional context for the query, defined by type parameter C.
	 * @return The retrieved API, or {@code null} if no API was found.
	 */
	@Nullable
	A find(@Nullable BlockBase block, int meta, C context);

	/**
	 * Create a new instance bound to the passed {@link Level} and position, and querying the same API as the passed lookup.
	 */
	static <A, C> BlockApiCache<A, C> create(BlockApiLookup<A, C> lookup, Level level, Vec3i pos) {
		Objects.requireNonNull(pos, "BlockPos may not be null.");
		Objects.requireNonNull(level, "Level may not be null.");

		if (!(lookup instanceof BlockApiLookupImpl)) {
			throw new IllegalArgumentException("Cannot cache foreign implementation of BlockApiLookup. Use `BlockApiLookup#get(Identifier, Class<A>, Class<C>);` to get instances.");
		}

		return new BlockApiCacheImpl<>((BlockApiLookupImpl<A, C>) lookup, level, pos);
	}
}
