package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateTranslucentBlock extends net.minecraft.block.TranslucentBlock implements IBlockTemplate<TemplateTranslucentBlock> {
    
    public TemplateTranslucentBlock(Identifier identifier, int j, Material arg, boolean flag) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j, arg, flag);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateTranslucentBlock(int i, int j, Material arg, boolean flag) {
        super(i, j, arg, flag);
    }

    @Override
    public TemplateTranslucentBlock disableNotifyOnMetaDataChange() {
        return (TemplateTranslucentBlock) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateTranslucentBlock setSounds(BlockSounds sounds) {
        return (TemplateTranslucentBlock) super.setSounds(sounds);
    }

    @Override
    public TemplateTranslucentBlock setLightOpacity(int i) {
        return (TemplateTranslucentBlock) super.setLightOpacity(i);
    }

    @Override
    public TemplateTranslucentBlock setLightEmittance(float f) {
        return (TemplateTranslucentBlock) super.setLightEmittance(f);
    }

    @Override
    public TemplateTranslucentBlock setBlastResistance(float resistance) {
        return (TemplateTranslucentBlock) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateTranslucentBlock setHardness(float hardness) {
        return (TemplateTranslucentBlock) super.setHardness(hardness);
    }

    @Override
    public TemplateTranslucentBlock setUnbreakable() {
        return (TemplateTranslucentBlock) super.setUnbreakable();
    }

    @Override
    public TemplateTranslucentBlock setTicksRandomly(boolean ticksRandomly) {
        return (TemplateTranslucentBlock) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateTranslucentBlock setTranslationKey(String string) {
        return (TemplateTranslucentBlock) super.setTranslationKey(string);
    }

    @Override
    public TemplateTranslucentBlock disableStat() {
        return (TemplateTranslucentBlock) super.disableStat();
    }
}
