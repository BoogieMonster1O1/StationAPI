package net.modificationstation.stationapi.impl.common.entity.player;

import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.ListenerPriority;
import net.modificationstation.stationapi.api.common.event.entity.player.PlayerEvent;
import net.modificationstation.stationapi.api.common.item.ICustomReach;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.mod.entrypoint.EventBusPolicy;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
public class PlayerReachImpl {

    @EventListener(priority = ListenerPriority.HIGH)
    private static void getReach(PlayerEvent.Reach event) {
        ItemInstance itemInstance = event.player.getHeldItem();
        if (itemInstance != null) {
            ItemBase item = itemInstance.getType();
            if (item instanceof ICustomReach)
                event.currentReach = ((ICustomReach) item).getReach(itemInstance, event.player, event.type, event.currentReach);
        }
    }
}
