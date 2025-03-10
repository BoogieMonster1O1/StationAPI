package net.modificationstation.stationapi.mixin.common;

import net.minecraft.tileentity.TileEntityBase;
import net.modificationstation.stationapi.api.common.StationAPI;
import net.modificationstation.stationapi.api.common.event.tileentity.TileEntityRegisterEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityBase.class)
public class MixinTileEntityBase {

    @Shadow
    private static void register(Class<?> arg, String string) {
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "TAIL"))
    private static void registerModdedTileEntities(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(new TileEntityRegisterEvent(MixinTileEntityBase::register));
    }
}
