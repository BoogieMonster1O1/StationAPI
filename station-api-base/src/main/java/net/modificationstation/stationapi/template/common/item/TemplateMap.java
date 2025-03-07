package net.modificationstation.stationapi.template.common.item;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateMap extends net.minecraft.item.Map implements IItemTemplate<TemplateMap> {

    public TemplateMap(Identifier identifier) {
        this(ItemRegistry.INSTANCE.getNextSerializedID());
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateMap(int i) {
        super(i);
    }

    @Override
    public TemplateMap setTexturePosition(int texturePosition) {
        return (TemplateMap) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateMap setMaxStackSize(int newMaxStackSize) {
        return (TemplateMap) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateMap setTexturePosition(int x, int y) {
        return (TemplateMap) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateMap setHasSubItems(boolean hasSubItems) {
        return (TemplateMap) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateMap setDurability(int durability) {
        return (TemplateMap) super.setDurability(durability);
    }

    @Override
    public TemplateMap setRendered3d() {
        return (TemplateMap) super.setRendered3d();
    }

    @Override
    public TemplateMap setTranslationKey(String newName) {
        return (TemplateMap) super.setTranslationKey(newName);
    }

    @Override
    public TemplateMap setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateMap) super.setContainerItem(itemType);
    }
}
