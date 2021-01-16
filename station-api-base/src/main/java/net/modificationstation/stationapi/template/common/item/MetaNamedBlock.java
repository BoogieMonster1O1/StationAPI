package net.modificationstation.stationapi.template.common.item;

import net.minecraft.item.ItemInstance;

public class MetaNamedBlock extends MetaBlock {

    public MetaNamedBlock(int i) {
        super(i);
    }

    @Override
    public String getTranslationKey(ItemInstance item) {
        return getTranslationKey() + item.getDamage();
    }
}
