package net.modificationstation.stationapi.template.common.item.tool;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.IItemTemplate;

public class TemplateSword extends net.minecraft.item.tool.Sword implements IItemTemplate<TemplateSword> {
    
    public TemplateSword(Identifier identifier, ToolMaterial arg) {
        this(ItemRegistry.INSTANCE.getNextSerializedID(), arg);
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateSword(int i, ToolMaterial arg) {
        super(i, arg);
    }

    @Override
    public TemplateSword setTexturePosition(int texturePosition) {
        return (TemplateSword) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateSword setMaxStackSize(int newMaxStackSize) {
        return (TemplateSword) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateSword setTexturePosition(int x, int y) {
        return (TemplateSword) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateSword setHasSubItems(boolean hasSubItems) {
        return (TemplateSword) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateSword setDurability(int durability) {
        return (TemplateSword) super.setDurability(durability);
    }

    @Override
    public TemplateSword setRendered3d() {
        return (TemplateSword) super.setRendered3d();
    }

    @Override
    public TemplateSword setTranslationKey(String newName) {
        return (TemplateSword) super.setTranslationKey(newName);
    }

    @Override
    public TemplateSword setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateSword) super.setContainerItem(itemType);
    }
}
