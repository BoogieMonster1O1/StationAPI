package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplatePistonHead extends net.minecraft.block.PistonHead implements IBlockTemplate<TemplatePistonHead> {

    public TemplatePistonHead(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplatePistonHead(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplatePistonHead disableNotifyOnMetaDataChange() {
        return (TemplatePistonHead) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplatePistonHead setSounds(BlockSounds sounds) {
        return (TemplatePistonHead) super.setSounds(sounds);
    }

    @Override
    public TemplatePistonHead setLightOpacity(int i) {
        return (TemplatePistonHead) super.setLightOpacity(i);
    }

    @Override
    public TemplatePistonHead setLightEmittance(float f) {
        return (TemplatePistonHead) super.setLightEmittance(f);
    }

    @Override
    public TemplatePistonHead setBlastResistance(float resistance) {
        return (TemplatePistonHead) super.setBlastResistance(resistance);
    }

    @Override
    public TemplatePistonHead setHardness(float hardness) {
        return (TemplatePistonHead) super.setHardness(hardness);
    }

    @Override
    public TemplatePistonHead setUnbreakable() {
        return (TemplatePistonHead) super.setUnbreakable();
    }

    @Override
    public TemplatePistonHead setTicksRandomly(boolean ticksRandomly) {
        return (TemplatePistonHead) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplatePistonHead setTranslationKey(String string) {
        return (TemplatePistonHead) super.setTranslationKey(string);
    }

    @Override
    public TemplatePistonHead disableStat() {
        return (TemplatePistonHead) super.disableStat();
    }
}
