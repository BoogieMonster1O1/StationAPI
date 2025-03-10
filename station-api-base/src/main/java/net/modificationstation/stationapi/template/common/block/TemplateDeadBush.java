package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateDeadBush extends net.minecraft.block.DeadBush implements IBlockTemplate<TemplateDeadBush> {

    public TemplateDeadBush(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateDeadBush(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateDeadBush disableNotifyOnMetaDataChange() {
        return (TemplateDeadBush) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateDeadBush setSounds(BlockSounds sounds) {
        return (TemplateDeadBush) super.setSounds(sounds);
    }

    @Override
    public TemplateDeadBush setLightOpacity(int i) {
        return (TemplateDeadBush) super.setLightOpacity(i);
    }

    @Override
    public TemplateDeadBush setLightEmittance(float f) {
        return (TemplateDeadBush) super.setLightEmittance(f);
    }

    @Override
    public TemplateDeadBush setBlastResistance(float resistance) {
        return (TemplateDeadBush) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateDeadBush setHardness(float hardness) {
        return (TemplateDeadBush) super.setHardness(hardness);
    }

    @Override
    public TemplateDeadBush setUnbreakable() {
        return (TemplateDeadBush) super.setUnbreakable();
    }

    @Override
    public TemplateDeadBush setTicksRandomly(boolean ticksRandomly) {
        return (TemplateDeadBush) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateDeadBush setTranslationKey(String string) {
        return (TemplateDeadBush) super.setTranslationKey(string);
    }

    @Override
    public TemplateDeadBush disableStat() {
        return (TemplateDeadBush) super.disableStat();
    }
}
