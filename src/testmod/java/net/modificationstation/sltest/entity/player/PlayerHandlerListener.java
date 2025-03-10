package net.modificationstation.sltest.entity.player;

import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.entity.player.PlayerEvent;

public class PlayerHandlerListener {

    @EventListener
    public void registerPlayerHandlers(PlayerEvent.HandlerRegister event) {
        event.playerHandlers.add(new PlayerHandler(event.player));
    }
}
