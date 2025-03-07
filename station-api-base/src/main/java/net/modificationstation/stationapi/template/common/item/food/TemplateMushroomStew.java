package net.modificationstation.stationapi.template.common.item.food;

import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.IItemTemplate;

public class TemplateMushroomStew extends net.minecraft.item.food.MushroomStew implements IItemTemplate<TemplateMushroomStew> {
    
    public TemplateMushroomStew(Identifier identifier, int healAmount) {
        this(ItemRegistry.INSTANCE.getNextSerializedID(), healAmount);
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateMushroomStew(int id, int healAmount) {
        super(id, healAmount);
    }

    @Override
    public TemplateMushroomStew setTexturePosition(int texturePosition) {
        return (TemplateMushroomStew) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateMushroomStew setMaxStackSize(int newMaxStackSize) {
        return (TemplateMushroomStew) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateMushroomStew setTexturePosition(int x, int y) {
        return (TemplateMushroomStew) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateMushroomStew setHasSubItems(boolean hasSubItems) {
        return (TemplateMushroomStew) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateMushroomStew setDurability(int durability) {
        return (TemplateMushroomStew) super.setDurability(durability);
    }

    @Override
    public TemplateMushroomStew setRendered3d() {
        return (TemplateMushroomStew) super.setRendered3d();
    }

    @Override
    public TemplateMushroomStew setTranslationKey(String newName) {
        return (TemplateMushroomStew) super.setTranslationKey(newName);
    }

    @Override
    public TemplateMushroomStew setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateMushroomStew) super.setContainerItem(itemType);
    }
}
