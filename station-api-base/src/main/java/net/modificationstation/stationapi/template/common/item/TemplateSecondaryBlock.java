package net.modificationstation.stationapi.template.common.item;

import net.minecraft.block.BlockBase;
import net.modificationstation.stationapi.api.common.item.ItemRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateSecondaryBlock extends net.minecraft.item.SecondaryBlock implements IItemTemplate<TemplateSecondaryBlock> {

    public TemplateSecondaryBlock(Identifier identifier, BlockBase tile) {
        this(ItemRegistry.INSTANCE.getNextSerializedID(), tile);
        ItemRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateSecondaryBlock(int id, BlockBase tile) {
        super(id, tile);
    }

    @Override
    public TemplateSecondaryBlock setTexturePosition(int texturePosition) {
        return (TemplateSecondaryBlock) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateSecondaryBlock setMaxStackSize(int newMaxStackSize) {
        return (TemplateSecondaryBlock) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateSecondaryBlock setTexturePosition(int x, int y) {
        return (TemplateSecondaryBlock) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateSecondaryBlock setHasSubItems(boolean hasSubItems) {
        return (TemplateSecondaryBlock) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateSecondaryBlock setDurability(int durability) {
        return (TemplateSecondaryBlock) super.setDurability(durability);
    }

    @Override
    public TemplateSecondaryBlock setRendered3d() {
        return (TemplateSecondaryBlock) super.setRendered3d();
    }

    @Override
    public TemplateSecondaryBlock setTranslationKey(String newName) {
        return (TemplateSecondaryBlock) super.setTranslationKey(newName);
    }

    @Override
    public TemplateSecondaryBlock setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateSecondaryBlock) super.setContainerItem(itemType);
    }
}
