package net.modificationstation.stationapi.template.common.item.tool;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.IItemTemplate;

public class TemplateBow extends net.minecraft.item.tool.Bow implements IItemTemplate<TemplateBow> {
    
    public TemplateBow(Identifier identifier) {
        this(ItemRegistry.INSTANCE.getNextSerializedID());
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateBow(int i) {
        super(i);
    }

    @Override
    public TemplateBow setTexturePosition(int texturePosition) {
        return (TemplateBow) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateBow setMaxStackSize(int newMaxStackSize) {
        return (TemplateBow) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateBow setTexturePosition(int x, int y) {
        return (TemplateBow) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateBow setHasSubItems(boolean hasSubItems) {
        return (TemplateBow) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateBow setDurability(int durability) {
        return (TemplateBow) super.setDurability(durability);
    }

    @Override
    public TemplateBow setRendered3d() {
        return (TemplateBow) super.setRendered3d();
    }

    @Override
    public TemplateBow setTranslationKey(String newName) {
        return (TemplateBow) super.setTranslationKey(newName);
    }

    @Override
    public TemplateBow setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateBow) super.setContainerItem(itemType);
    }
}
