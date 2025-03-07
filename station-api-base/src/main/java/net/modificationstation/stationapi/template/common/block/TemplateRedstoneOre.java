package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateRedstoneOre extends net.minecraft.block.RedstoneOre implements IBlockTemplate<TemplateRedstoneOre> {
    
    public TemplateRedstoneOre(Identifier identifier, int j, boolean isLit) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j, isLit);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateRedstoneOre(int i, int j, boolean isLit) {
        super(i, j, isLit);
    }

    @Override
    public TemplateRedstoneOre disableNotifyOnMetaDataChange() {
        return (TemplateRedstoneOre) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateRedstoneOre setSounds(BlockSounds sounds) {
        return (TemplateRedstoneOre) super.setSounds(sounds);
    }

    @Override
    public TemplateRedstoneOre setLightOpacity(int i) {
        return (TemplateRedstoneOre) super.setLightOpacity(i);
    }

    @Override
    public TemplateRedstoneOre setLightEmittance(float f) {
        return (TemplateRedstoneOre) super.setLightEmittance(f);
    }

    @Override
    public TemplateRedstoneOre setBlastResistance(float resistance) {
        return (TemplateRedstoneOre) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateRedstoneOre setHardness(float hardness) {
        return (TemplateRedstoneOre) super.setHardness(hardness);
    }

    @Override
    public TemplateRedstoneOre setUnbreakable() {
        return (TemplateRedstoneOre) super.setUnbreakable();
    }

    @Override
    public TemplateRedstoneOre setTicksRandomly(boolean ticksRandomly) {
        return (TemplateRedstoneOre) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateRedstoneOre setTranslationKey(String string) {
        return (TemplateRedstoneOre) super.setTranslationKey(string);
    }

    @Override
    public TemplateRedstoneOre disableStat() {
        return (TemplateRedstoneOre) super.disableStat();
    }
}
