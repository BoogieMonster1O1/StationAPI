package net.modificationstation.stationapi.impl.server.packet;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.ServerPlayer;
import net.minecraft.packet.AbstractPacket;
import net.modificationstation.stationapi.impl.common.packet.PacketHelperImpl;

public class PacketHelperServerImpl extends PacketHelperImpl {

    @Override
    public void send(AbstractPacket packet) {
        packet.handle(null);
    }

    @Override
    public void sendTo(PlayerBase playerBase, AbstractPacket packet) {
        ((ServerPlayer) playerBase).packetHandler.send(packet);
    }
}
