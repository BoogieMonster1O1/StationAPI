package net.modificationstation.stationapi.template.common.item;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateMapBase extends net.minecraft.item.MapBase implements IItemTemplate<TemplateMapBase> {

    public TemplateMapBase(Identifier identifier) {
        this(ItemRegistry.INSTANCE.getNextSerializedID());
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateMapBase(int i) {
        super(i);
    }

    @Override
    public TemplateMapBase setTexturePosition(int texturePosition) {
        return (TemplateMapBase) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateMapBase setMaxStackSize(int newMaxStackSize) {
        return (TemplateMapBase) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateMapBase setTexturePosition(int x, int y) {
        return (TemplateMapBase) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateMapBase setHasSubItems(boolean hasSubItems) {
        return (TemplateMapBase) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateMapBase setDurability(int durability) {
        return (TemplateMapBase) super.setDurability(durability);
    }

    @Override
    public TemplateMapBase setRendered3d() {
        return (TemplateMapBase) super.setRendered3d();
    }

    @Override
    public TemplateMapBase setTranslationKey(String newName) {
        return (TemplateMapBase) super.setTranslationKey(newName);
    }

    @Override
    public TemplateMapBase setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateMapBase) super.setContainerItem(itemType);
    }
}
