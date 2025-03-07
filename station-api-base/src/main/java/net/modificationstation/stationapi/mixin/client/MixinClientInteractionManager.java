package net.modificationstation.stationapi.mixin.client;

import net.minecraft.client.ClientInteractionManager;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.item.UseOnBlockFirst;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientInteractionManager.class)
public class MixinClientInteractionManager {

    @Inject(method = "method_1713(Lnet/minecraft/entity/player/PlayerBase;Lnet/minecraft/level/Level;Lnet/minecraft/item/ItemInstance;IIII)Z", at = @At(value = "HEAD"), cancellable = true)
    private void injectOnPlaceBlock(PlayerBase playerBase, Level level, ItemInstance itemInstance, int i, int j, int k, int i1, CallbackInfoReturnable<Boolean> cir) {
        if (itemInstance != null && itemInstance.getType() instanceof UseOnBlockFirst) {
            if (((UseOnBlockFirst) itemInstance.getType()).onUseOnBlockFirst(itemInstance, playerBase, level, i, j, k, i1)) {
                cir.setReturnValue(true);
            }
        }
    }
}
