package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateLever extends net.minecraft.block.Lever implements IBlockTemplate<TemplateLever> {

    public TemplateLever(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateLever(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateLever disableNotifyOnMetaDataChange() {
        return (TemplateLever) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateLever setSounds(BlockSounds sounds) {
        return (TemplateLever) super.setSounds(sounds);
    }

    @Override
    public TemplateLever setLightOpacity(int i) {
        return (TemplateLever) super.setLightOpacity(i);
    }

    @Override
    public TemplateLever setLightEmittance(float f) {
        return (TemplateLever) super.setLightEmittance(f);
    }

    @Override
    public TemplateLever setBlastResistance(float resistance) {
        return (TemplateLever) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateLever setHardness(float hardness) {
        return (TemplateLever) super.setHardness(hardness);
    }

    @Override
    public TemplateLever setUnbreakable() {
        return (TemplateLever) super.setUnbreakable();
    }

    @Override
    public TemplateLever setTicksRandomly(boolean ticksRandomly) {
        return (TemplateLever) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateLever setTranslationKey(String string) {
        return (TemplateLever) super.setTranslationKey(string);
    }

    @Override
    public TemplateLever disableStat() {
        return (TemplateLever) super.disableStat();
    }
}
