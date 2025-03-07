package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateGravel extends net.minecraft.block.Gravel implements IBlockTemplate<TemplateGravel> {
    
    public TemplateGravel(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateGravel(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateGravel disableNotifyOnMetaDataChange() {
        return (TemplateGravel) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateGravel setSounds(BlockSounds sounds) {
        return (TemplateGravel) super.setSounds(sounds);
    }

    @Override
    public TemplateGravel setLightOpacity(int i) {
        return (TemplateGravel) super.setLightOpacity(i);
    }

    @Override
    public TemplateGravel setLightEmittance(float f) {
        return (TemplateGravel) super.setLightEmittance(f);
    }

    @Override
    public TemplateGravel setBlastResistance(float resistance) {
        return (TemplateGravel) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateGravel setHardness(float hardness) {
        return (TemplateGravel) super.setHardness(hardness);
    }

    @Override
    public TemplateGravel setUnbreakable() {
        return (TemplateGravel) super.setUnbreakable();
    }

    @Override
    public TemplateGravel setTicksRandomly(boolean ticksRandomly) {
        return (TemplateGravel) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateGravel setTranslationKey(String string) {
        return (TemplateGravel) super.setTranslationKey(string);
    }

    @Override
    public TemplateGravel disableStat() {
        return (TemplateGravel) super.disableStat();
    }
}
