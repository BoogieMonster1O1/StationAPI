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

import net.modificationstation.stationapi.api.common.registry.Identifier;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.maths.Vec3i;

import net.fabricmc.fabric.impl.lookup.block.BlockApiLookupImpl;

/**
 * An object that allows retrieving APIs from blocks in a world.
 * Instances of this interface can be obtained through {@link #get}.
 *
 * <p>When trying to {@link BlockApiLookup#find} an API, the block or block entity at that position will be queried if it exists.
 * If it doesn't exist, or if it returns {@code null}, the fallback providers will be queried in order.
 *
 * <p>Note: If you are going to query APIs a lot, consider using {@link BlockApiCache}, it may drastically improve performance.
 *
 * <p><h3>Usage Example</h3>
 * Let us pretend we have the following interface that we would like to attach to some blocks depending on the direction.
 *
 * <pre>{@code
 * public interface FluidContainer {
 *     boolean containsFluids(); // return true if not empty
 * }}</pre>
 * Let us first create a static {@code BlockApiLookup} instance that will manage the registration and the query.
 *
 * <pre>{@code
 * public final class MyApi {
 *     public static final BlockApiLookup<FluidContainer, Direction> FLUID_CONTAINER = BlockApiLookup.get(new Identifier("mymod:fluid_container"), FluidContainer.class, Direction.class);
 * }}</pre>
 * Using that, we can query instances of {@code FluidContainer}:
 *
 * <pre>{@code
 * FluidContainer container = MyApi.FLUID_CONTAINER.find(world, pos, direction);
 * if (container != null) {
 *     // Do something with the container
 *     if (container.containsFluids()) {
 *         System.out.println("It contains fluids!");
 *     }
 * }}</pre>
 * For the query to return a useful result, functions that provide an API for a block or a block entity must be registered.
 *
 * <pre>{@code
 * // If the block entity directly implements the interface, registerSelf can be used.
 * public class ContainerBlockEntity implements FluidContainer {
 *     // ...
 * }
 * BlockEntityType<ContainerBlockEntity> CONTAINER_BLOCK_ENTITY_TYPE;
 * MyApi.FLUID_CONTAINER.registerSelf(CONTAINER_BLOCK_ENTITY_TYPE);
 *
 * // For more complicated block entity logic, registerForBlockEntities can be used.
 * // For example, let's provide a stored field, and only when the direction is UP:
 * public class MyBlockEntity {
 *     public final FluidContainer upContainer;
 *     // ...
 * }
 * MyApi.FLUID_CONTAINER.registerForBlockEntities((blockEntity, direction) -> {
 *     if (direction == Direction.UP) { // only expose from the top
 *         // return a field
 *         return ((MyBlockEntity) blockEntity).upContainer;
 *     } else {
 *         return null;
 *     }
 * }, BLOCK_ENTITY_TYPE_1, BLOCK_ENTITY_TYPE_2);
 *
 * // Without a block entity, registerForBlocks can be used.
 * MyApi.FLUID_CONTAINER.registerForBlocks((world, pos, state, blockEntity, direction) -> {
 *     // return a FluidContainer for your block, or null if there is none
 * }, BLOCK_INSTANCE, ANOTHER_BLOCK_INSTANCE); // register as many blocks as you want
 *
 * // Block entity fallback, for example to interface with another mod's FluidInventory.
 * MyApi.FLUID_CONTAINER.registerFallback((world, pos, state, blockEntity, direction) -> {
 *     if (blockEntity instanceof FluidInventory) {
 *         // return wrapper
 *     }
 *     return null;
 * });
 *
 * // General fallback, to interface with anything, for example another BlockApiLookup.
 * MyApi.FLUID_CONTAINER.registerFallback((world, pos, state, blockEntity, direction) -> {
 *     // return something if available, or null
 * });}</pre>
 *
 * <p><h3>Improving performance</h3>
 * When performing queries every tick, it is recommended to use {@link BlockApiCache BlockApiCache&lt;A, C&gt;}
 * instead of directly querying the {@code BlockApiLookup}.
 *
 * <pre>{@code
 * // 1) create and store an instance
 * BlockApiCache<FluidContainer, Direction> cache = BlockApiCache.create(MyApi.FLUID_CONTAINER, serverWorld, pos);
 *
 * // 2) use it later, the block entity instance will be cached among other things
 * FluidContainer container = cache.find(direction);
 * if (container != null) {
 *     // ...
 * }
 *
 * // 2bis) if the caller is able to cache the block state as well, for example by listening to neighbor updates,
 * //       that will further improve performance.
 * FluidContainer container = cache.find(direction, cachedBlockState);
 * if (container != null) {
 *     // ...
 * }
 *
 * // no need to destroy the cache, the garbage collector will take care of it}</pre>
 *
 * <p><h3>Generic context types</h3>
 * Note that {@code FluidContainer} and {@code Direction} were completely arbitrary in this example.
 * We can define any {@code BlockApiLookup&lt;A, C&gt;}, where {@code A} is the type of the queried API, and {@code C} is the type of the additional context
 * (the direction parameter in the previous example).
 * If no context is necessary, {@code Void} should be used, and {@code null} instances should be passed.
 *
 * @param <A> The type of the API.
 * @param <C> The type of the additional context object.
 */
public interface BlockApiLookup<A, C> {
	/**
	 * Retrieve the {@link BlockApiLookup} associated with an identifier, or create it if it didn't exist yet.
	 *
	 * @param lookupId The unique identifier of the lookup.
	 * @param apiClass The class of the API.
	 * @param contextClass The class of the additional context.
	 * @return The unique lookup with the passed lookupId.
	 * @throws IllegalArgumentException If another {@code apiClass} or another {@code contextClass} was already registered with the same identifier.
	 */
	static <A, C> BlockApiLookup<A, C> get(Identifier lookupId, Class<A> apiClass, Class<C> contextClass) {
		return BlockApiLookupImpl.get(lookupId, apiClass, contextClass);
	}

	/**
	 * Attempt to retrieve an API from a block in the level.
	 * Consider using {@link BlockApiCache} if you are doing frequent queries at the same position.
	 *
	 * <p>Note: If the block state or the block entity is known, it is more efficient to use {@link BlockApiLookup#find(Level, Vec3i, BlockBase, int, TileEntityBase, Object)}.
	 *
	 * @param level The level.
	 * @param pos The position of the block.
	 * @param context Additional context for the query, defined by type parameter C.
	 * @return The retrieved API, or {@code null} if no API was found.
	 */
	@Nullable
	default A find(Level level, Vec3i pos, C context) {
		return find(level, pos, null, 0, null, context);
	}

	/**
	 * Attempt to retrieve an API from a block in the level.
	 * Consider using {@link BlockApiCache} if you are doing frequent queries at the same position.
	 *
	 * @param level The level.
	 * @param pos The position of the block.
	 * @param context Additional context for the query, defined by type parameter C.
	 * @param block The block at the target position, or null if unknown.
	 * @param tileEntity The tile entity at the target position if it is known, or null if it is unknown or does not exist.
	 * @return The retrieved API, or {@code null} if no API was found.
	 */
	@Nullable
	A find(Level level, Vec3i pos, @Nullable BlockBase block, int meta, @Nullable TileEntityBase tileEntity, C context);

	/**
	 * Expose the API for the passed block entities directly implementing it.
	 *
	 * <p>Implementation note: this is checked at registration time by creating block entity instances using the passed types.
	 *
	 * @param tileEntities Tile entity classes for which to expose the API.
	 * @throws IllegalArgumentException If the API class is not assignable from instances of the passed block entity types.
	 */
	void registerSelf(Class<? extends TileEntityBase>... tileEntities);

	/**
	 * Expose the API for the passed blocks.
	 * The mapping from the parameters of the query to the API is handled by the passed {@link BlockApiProvider}.
	 *
	 * @param provider The provider.
	 * @param blocks The blocks.
	 */
	void registerForBlocks(BlockApiProvider<A, C> provider, BlockBase... blocks);

	/**
	 * Expose the API for instances of the passed block entity types.
	 * The mapping from the parameters of the query to the API is handled by the passed {@link BlockEntityApiProvider}.
	 *
	 * @param provider The provider.
	 * @param tileEntities The tile entity classes.
	 */
	void registerForBlockEntities(BlockEntityApiProvider<A, C> provider, Class<? extends TileEntityBase>... tileEntities);

	/**
	 * Expose the API for all queries: the provider will be invoked if no object was found using the block or block entity providers.
	 * This may have a big performance impact on all queries, use cautiously.
	 *
	 * @param fallbackProvider The fallback provider.
	 */
	void registerFallback(BlockApiProvider<A, C> fallbackProvider);

	@FunctionalInterface
	interface BlockApiProvider<A, C> {
		/**
		 * Return an API of type {@code A} if available in the level at the given pos with the given context, or {@code null} otherwise.
		 *
		 * @param level The level.
		 * @param pos The position in the level.
		 * @param state The block state.
		 * @param tileEntity The tile entity, if it exists in the level.
		 * @param context Additional context passed to the query.
		 * @return An API of type {@code A}, or {@code null} if no API is available.
		 */
		@Nullable
		A find(Level level, Vec3i pos, BlockBase state, int meta, @Nullable TileEntityBase tileEntity, C context);
	}

	@FunctionalInterface
	interface BlockEntityApiProvider<A, C> {
		/**
		 * Return an API of type {@code A} if available in the given block entity with the given context, or {@code null} otherwise.
		 *
		 * @param tileEntity The tile entity. It is guaranteed that it is never null.
		 * @param context Additional context passed to the query.
		 * @return An API of type {@code A}, or {@code null} if no API is available.
		 */
		@Nullable
		A find(TileEntityBase tileEntity, C context);
	}
}
