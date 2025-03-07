package net.modificationstation.stationapi.template.common.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class TemplateCake extends net.minecraft.block.Cake implements IBlockTemplate<TemplateCake> {

    public TemplateCake(Identifier identifier, int texture) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), texture);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public TemplateCake(int id, int texture) {
        super(id, texture);
    }

    @Override
    public TemplateCake disableNotifyOnMetaDataChange() {
        return (TemplateCake) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public TemplateCake setSounds(BlockSounds sounds) {
        return (TemplateCake) super.setSounds(sounds);
    }

    @Override
    public TemplateCake setLightOpacity(int i) {
        return (TemplateCake) super.setLightOpacity(i);
    }

    @Override
    public TemplateCake setLightEmittance(float f) {
        return (TemplateCake) super.setLightEmittance(f);
    }

    @Override
    public TemplateCake setBlastResistance(float resistance) {
        return (TemplateCake) super.setBlastResistance(resistance);
    }

    @Override
    public TemplateCake setHardness(float hardness) {
        return (TemplateCake) super.setHardness(hardness);
    }

    @Override
    public TemplateCake setUnbreakable() {
        return (TemplateCake) super.setUnbreakable();
    }

    @Override
    public TemplateCake setTicksRandomly(boolean ticksRandomly) {
        return (TemplateCake) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public TemplateCake setTranslationKey(String string) {
        return (TemplateCake) super.setTranslationKey(string);
    }

    @Override
    public TemplateCake disableStat() {
        return (TemplateCake) super.disableStat();
    }
}
