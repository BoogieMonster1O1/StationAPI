package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateJukebox extends net.minecraft.block.Jukebox implements IBlockTemplate<TemplateJukebox> {
    
    public TemplateJukebox(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public TemplateJukebox(int i, int j) {
        super(i, j);
    }

    @Override
    public TemplateJukebox disableNotifyOnMetaDataChange() {
        return (TemplateJukebox) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateJukebox setSounds(BlockSounds sounds) {
        return (TemplateJukebox) super.setSounds(sounds);
    }

    @Override
    public TemplateJukebox setLightOpacity(int i) {
        return (TemplateJukebox) super.setLightOpacity(i);
    }

    @Override
    public TemplateJukebox setLightEmittance(float f) {
        return (TemplateJukebox) super.setLightEmittance(f);
    }

    @Override
    public TemplateJukebox setBlastResistance(float resistance) {
        return (TemplateJukebox) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateJukebox setHardness(float hardness) {
        return (TemplateJukebox) super.setHardness(hardness);
    }

    @Override
    public TemplateJukebox setUnbreakable() {
        return (TemplateJukebox) super.setUnbreakable();
    }

    @Override
    public TemplateJukebox setTicksRandomly(boolean ticksRandomly) {
        return (TemplateJukebox) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateJukebox setTranslationKey(String string) {
        return (TemplateJukebox) super.setTranslationKey(string);
    }

    @Override
    public TemplateJukebox disableStat() {
        return (TemplateJukebox) super.disableStat();
    }
}
