package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateDoor extends net.minecraft.block.Door implements IBlockTemplate<TemplateDoor> {

    public TemplateDoor(Identifier identifier, Material material) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), material);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateDoor(int i, Material arg) {
        super(i, arg);
    }
    
    @Override
    public TemplateDoor disableNotifyOnMetaDataChange() {
        return (TemplateDoor) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateDoor setSounds(BlockSounds sounds) {
        return (TemplateDoor) super.setSounds(sounds);
    }

    @Override
    public TemplateDoor setLightOpacity(int i) {
        return (TemplateDoor) super.setLightOpacity(i);
    }

    @Override
    public TemplateDoor setLightEmittance(float f) {
        return (TemplateDoor) super.setLightEmittance(f);
    }

    @Override
    public TemplateDoor setBlastResistance(float resistance) {
        return (TemplateDoor) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateDoor setHardness(float hardness) {
        return (TemplateDoor) super.setHardness(hardness);
    }

    @Override
    public TemplateDoor setUnbreakable() {
        return (TemplateDoor) super.setUnbreakable();
    }

    @Override
    public TemplateDoor setTicksRandomly(boolean ticksRandomly) {
        return (TemplateDoor) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateDoor setTranslationKey(String string) {
        return (TemplateDoor) super.setTranslationKey(string);
    }

    @Override
    public TemplateDoor disableStat() {
        return (TemplateDoor) super.disableStat();
    }
}
