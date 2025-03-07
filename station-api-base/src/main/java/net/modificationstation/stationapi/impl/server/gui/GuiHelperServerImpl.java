package net.modificationstation.stationapi.impl.server.gui;

import net.minecraft.class_633;
import net.minecraft.container.ContainerBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.modificationstation.stationapi.api.common.packet.Message;
import net.modificationstation.stationapi.impl.common.gui.GuiHelperImpl;
import net.modificationstation.stationapi.mixin.server.accessor.ServerPlayerAccessor;

public class GuiHelperServerImpl extends GuiHelperImpl {

    @Override
    protected void sideDependentPacket(PlayerBase player, InventoryBase inventory, Message message) {
        message.put(new Object[] {null});
        ((ServerPlayerAccessor) player).invokeMethod_314();
        message.put(new int[] {((ServerPlayerAccessor) player).getField_260()});
    }

    @Override
    protected void afterPacketSent(PlayerBase player, ContainerBase container) {
        player.container = container;
        container.currentContainerId = ((ServerPlayerAccessor) player).getField_260();
        container.method_2076((class_633) player);
    }
}
