package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateMaterialBlock extends net.minecraft.block.MaterialBlock implements IBlockTemplate<TemplateMaterialBlock> {
    
    public TemplateMaterialBlock(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateMaterialBlock(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateMaterialBlock disableNotifyOnMetaDataChange() {
        return (TemplateMaterialBlock) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateMaterialBlock setSounds(BlockSounds sounds) {
        return (TemplateMaterialBlock) super.setSounds(sounds);
    }

    @Override
    public TemplateMaterialBlock setLightOpacity(int i) {
        return (TemplateMaterialBlock) super.setLightOpacity(i);
    }

    @Override
    public TemplateMaterialBlock setLightEmittance(float f) {
        return (TemplateMaterialBlock) super.setLightEmittance(f);
    }

    @Override
    public TemplateMaterialBlock setBlastResistance(float resistance) {
        return (TemplateMaterialBlock) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateMaterialBlock setHardness(float hardness) {
        return (TemplateMaterialBlock) super.setHardness(hardness);
    }

    @Override
    public TemplateMaterialBlock setUnbreakable() {
        return (TemplateMaterialBlock) super.setUnbreakable();
    }

    @Override
    public TemplateMaterialBlock setTicksRandomly(boolean ticksRandomly) {
        return (TemplateMaterialBlock) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateMaterialBlock setTranslationKey(String string) {
        return (TemplateMaterialBlock) super.setTranslationKey(string);
    }

    @Override
    public TemplateMaterialBlock disableStat() {
        return (TemplateMaterialBlock) super.disableStat();
    }
}
