package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateLockedChest extends net.minecraft.block.LockedChest implements IBlockTemplate<TemplateLockedChest> {

    public TemplateLockedChest(Identifier identifier) {
        this(BlockRegistry.INSTANCE.getNextSerializedID());
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateLockedChest(int i) {
        super(i);
    }

    @Override
    public TemplateLockedChest disableNotifyOnMetaDataChange() {
        return (TemplateLockedChest) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateLockedChest setSounds(BlockSounds sounds) {
        return (TemplateLockedChest) super.setSounds(sounds);
    }

    @Override
    public TemplateLockedChest setLightOpacity(int i) {
        return (TemplateLockedChest) super.setLightOpacity(i);
    }

    @Override
    public TemplateLockedChest setLightEmittance(float f) {
        return (TemplateLockedChest) super.setLightEmittance(f);
    }

    @Override
    public TemplateLockedChest setBlastResistance(float resistance) {
        return (TemplateLockedChest) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateLockedChest setHardness(float hardness) {
        return (TemplateLockedChest) super.setHardness(hardness);
    }

    @Override
    public TemplateLockedChest setUnbreakable() {
        return (TemplateLockedChest) super.setUnbreakable();
    }

    @Override
    public TemplateLockedChest setTicksRandomly(boolean ticksRandomly) {
        return (TemplateLockedChest) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateLockedChest setTranslationKey(String string) {
        return (TemplateLockedChest) super.setTranslationKey(string);
    }

    @Override
    public TemplateLockedChest disableStat() {
        return (TemplateLockedChest) super.disableStat();
    }
}
