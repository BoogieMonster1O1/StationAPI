package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateTrapdoor extends net.minecraft.block.Trapdoor implements IBlockTemplate<TemplateTrapdoor> {
    
    public TemplateTrapdoor(Identifier identifier, Material arg) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), arg);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateTrapdoor(int i, Material arg) {
        super(i, arg);
    }

    @Override
    public TemplateTrapdoor disableNotifyOnMetaDataChange() {
        return (TemplateTrapdoor) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateTrapdoor setSounds(BlockSounds sounds) {
        return (TemplateTrapdoor) super.setSounds(sounds);
    }

    @Override
    public TemplateTrapdoor setLightOpacity(int i) {
        return (TemplateTrapdoor) super.setLightOpacity(i);
    }

    @Override
    public TemplateTrapdoor setLightEmittance(float f) {
        return (TemplateTrapdoor) super.setLightEmittance(f);
    }

    @Override
    public TemplateTrapdoor setBlastResistance(float resistance) {
        return (TemplateTrapdoor) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateTrapdoor setHardness(float hardness) {
        return (TemplateTrapdoor) super.setHardness(hardness);
    }

    @Override
    public TemplateTrapdoor setUnbreakable() {
        return (TemplateTrapdoor) super.setUnbreakable();
    }

    @Override
    public TemplateTrapdoor setTicksRandomly(boolean ticksRandomly) {
        return (TemplateTrapdoor) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateTrapdoor setTranslationKey(String string) {
        return (TemplateTrapdoor) super.setTranslationKey(string);
    }

    @Override
    public TemplateTrapdoor disableStat() {
        return (TemplateTrapdoor) super.disableStat();
    }
}
