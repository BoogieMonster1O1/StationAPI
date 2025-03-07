package net.modificationstation.stationapi.impl.common.item;

import lombok.Data;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@Data
public class JsonItemKey {

    private String item;
    private int count = 1;
    private int damage = 0;

    public ItemInstance getItemInstance() {
        return ItemRegistry.INSTANCE.getByIdentifier(Identifier.of(item)).map(itemBase -> new ItemInstance(itemBase, count, damage)).orElse(null);
    }
}