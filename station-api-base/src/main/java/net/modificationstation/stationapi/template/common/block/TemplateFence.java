package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateFence extends net.minecraft.block.Fence implements IBlockTemplate<TemplateFence> {

    public TemplateFence(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateFence(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateFence disableNotifyOnMetaDataChange() {
        return (TemplateFence) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateFence setSounds(BlockSounds sounds) {
        return (TemplateFence) super.setSounds(sounds);
    }

    @Override
    public TemplateFence setLightOpacity(int i) {
        return (TemplateFence) super.setLightOpacity(i);
    }

    @Override
    public TemplateFence setLightEmittance(float f) {
        return (TemplateFence) super.setLightEmittance(f);
    }

    @Override
    public TemplateFence setBlastResistance(float resistance) {
        return (TemplateFence) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateFence setHardness(float hardness) {
        return (TemplateFence) super.setHardness(hardness);
    }

    @Override
    public TemplateFence setUnbreakable() {
        return (TemplateFence) super.setUnbreakable();
    }

    @Override
    public TemplateFence setTicksRandomly(boolean ticksRandomly) {
        return (TemplateFence) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateFence setTranslationKey(String string) {
        return (TemplateFence) super.setTranslationKey(string);
    }

    @Override
    public TemplateFence disableStat() {
        return (TemplateFence) super.disableStat();
    }
}
