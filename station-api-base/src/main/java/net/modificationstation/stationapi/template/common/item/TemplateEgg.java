package net.modificationstation.stationapi.template.common.item;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateEgg extends net.minecraft.item.Egg implements IItemTemplate<TemplateEgg> {

    public TemplateEgg(Identifier identifier) {
        this(ItemRegistry.INSTANCE.getNextSerializedID());
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateEgg(int i) {
        super(i);
    }

    @Override
    public TemplateEgg setTexturePosition(int texturePosition) {
        return (TemplateEgg) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateEgg setMaxStackSize(int newMaxStackSize) {
        return (TemplateEgg) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateEgg setTexturePosition(int x, int y) {
        return (TemplateEgg) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateEgg setHasSubItems(boolean hasSubItems) {
        return (TemplateEgg) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateEgg setDurability(int durability) {
        return (TemplateEgg) super.setDurability(durability);
    }

    @Override
    public TemplateEgg setRendered3d() {
        return (TemplateEgg) super.setRendered3d();
    }

    @Override
    public TemplateEgg setTranslationKey(String newName) {
        return (TemplateEgg) super.setTranslationKey(newName);
    }

    @Override
    public TemplateEgg setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateEgg) super.setContainerItem(itemType);
    }
}
