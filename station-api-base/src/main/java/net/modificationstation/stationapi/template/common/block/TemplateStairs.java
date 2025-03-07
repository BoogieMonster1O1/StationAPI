package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateStairs extends net.minecraft.block.Stairs implements IBlockTemplate<TemplateStairs> {
    
    public TemplateStairs(Identifier identifier, BlockBase arg) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), arg);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateStairs(int i, BlockBase arg) {
        super(i, arg);
    }

    @Override
    public TemplateStairs disableNotifyOnMetaDataChange() {
        return (TemplateStairs) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateStairs setSounds(BlockSounds sounds) {
        return (TemplateStairs) super.setSounds(sounds);
    }

    @Override
    public TemplateStairs setLightOpacity(int i) {
        return (TemplateStairs) super.setLightOpacity(i);
    }

    @Override
    public TemplateStairs setLightEmittance(float f) {
        return (TemplateStairs) super.setLightEmittance(f);
    }

    @Override
    public TemplateStairs setBlastResistance(float resistance) {
        return (TemplateStairs) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateStairs setHardness(float hardness) {
        return (TemplateStairs) super.setHardness(hardness);
    }

    @Override
    public TemplateStairs setUnbreakable() {
        return (TemplateStairs) super.setUnbreakable();
    }

    @Override
    public TemplateStairs setTicksRandomly(boolean ticksRandomly) {
        return (TemplateStairs) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateStairs setTranslationKey(String string) {
        return (TemplateStairs) super.setTranslationKey(string);
    }

    @Override
    public TemplateStairs disableStat() {
        return (TemplateStairs) super.disableStat();
    }
}
