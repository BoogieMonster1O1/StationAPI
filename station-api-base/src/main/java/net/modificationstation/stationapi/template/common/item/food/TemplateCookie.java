package net.modificationstation.stationapi.template.common.item.food;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.IItemTemplate;

public class TemplateCookie extends net.minecraft.item.food.Cookie implements IItemTemplate<TemplateCookie> {
    
    public TemplateCookie(Identifier identifier, int healAmount, boolean isWolfFood, int maxStackSize) {
        this(ItemRegistry.INSTANCE.getNextSerializedID(), healAmount, isWolfFood, maxStackSize);
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateCookie(int id, int healAmount, boolean isWolfFood, int maxStackSize) {
        super(id, healAmount, isWolfFood, maxStackSize);
    }

    @Override
    public TemplateCookie setTexturePosition(int texturePosition) {
        return (TemplateCookie) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateCookie setMaxStackSize(int newMaxStackSize) {
        return (TemplateCookie) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateCookie setTexturePosition(int x, int y) {
        return (TemplateCookie) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateCookie setHasSubItems(boolean hasSubItems) {
        return (TemplateCookie) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateCookie setDurability(int durability) {
        return (TemplateCookie) super.setDurability(durability);
    }

    @Override
    public TemplateCookie setRendered3d() {
        return (TemplateCookie) super.setRendered3d();
    }

    @Override
    public TemplateCookie setTranslationKey(String newName) {
        return (TemplateCookie) super.setTranslationKey(newName);
    }

    @Override
    public TemplateCookie setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateCookie) super.setContainerItem(itemType);
    }
}
