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

package net.fabricmc.fabric.impl.lookup.item;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import net.modificationstation.stationapi.api.common.registry.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;

import net.fabricmc.fabric.api.lookup.v1.custom.ApiLookupMap;
import net.fabricmc.fabric.api.lookup.v1.custom.ApiProviderMap;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;

public class ItemApiLookupImpl<A, C> implements ItemApiLookup<A, C> {
	private static final Logger LOGGER = LogManager.getLogger("fabric-api-lookup-api-v1/item");
	private static final ApiLookupMap<ItemApiLookup<?, ?>> LOOKUPS = ApiLookupMap.create(ItemApiLookupImpl::new);

	@SuppressWarnings("unchecked")
	public static <A, C> ItemApiLookup<A, C> get(Identifier lookupId, Class<A> apiClass, Class<C> contextClass) {
		return (ItemApiLookup<A, C>) LOOKUPS.getLookup(lookupId, apiClass, contextClass);
	}

	private final Class<A> apiClass;
	private final ApiProviderMap<ItemBase, ItemApiProvider<A, C>> providerMap = ApiProviderMap.create();
	private final List<ItemApiProvider<A, C>> fallbackProviders = new CopyOnWriteArrayList<>();

	@SuppressWarnings("unchecked")
	private ItemApiLookupImpl(Class<?> apiClass, Class<?> contextClass) {
		this.apiClass = (Class<A>) apiClass;
	}

	@Override
	public @Nullable A find(ItemInstance itemInstance, C context) {
		Objects.requireNonNull(itemInstance, "ItemInstance may not be null.");

		@Nullable
		ItemApiProvider<A, C> provider = providerMap.get(itemInstance.getType());

		if (provider != null) {
			A instance = provider.find(itemInstance, context);

			if (instance != null) {
				return instance;
			}
		}

		for (ItemApiProvider<A, C> fallbackProvider : fallbackProviders) {
			A instance = fallbackProvider.find(itemInstance, context);

			if (instance != null) {
				return instance;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerSelf(ItemBase... items) {
		for (ItemBase item : items) {
			if (!apiClass.isAssignableFrom(item.getClass())) {
				String errorMessage = String.format(
						"Failed to register self-implementing items. API class %s is not assignable from item class %s.",
						apiClass.getCanonicalName(),
						item.getClass().getCanonicalName()
				);
				throw new IllegalArgumentException(errorMessage);
			}
		}

		registerForItems((itemInstance, context) -> (A) itemInstance.getType(), items);
	}

	@Override
	public void registerForItems(net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup.ItemApiProvider<A, C> provider, ItemBase... items) {
		Objects.requireNonNull(provider, "ItemApiProvider may not be null.");

		if (items.length == 0) {
			throw new IllegalArgumentException("Must register at least one ItemConvertible instance with an ItemApiProvider.");
		}

		for (ItemBase item : items) {
			Objects.requireNonNull(item, "Item convertible in item form may not be null.");

			if (providerMap.putIfAbsent(item, provider) != null) {
				LOGGER.warn("Encountered duplicate API provider registration for item: " + item.getTranslatedName());
			}
		}
	}

	@Override
	public void registerFallback(net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup.ItemApiProvider<A, C> fallbackProvider) {
		Objects.requireNonNull(fallbackProvider, "ItemApiProvider may not be null.");

		fallbackProviders.add(fallbackProvider);
	}
}
