package net.modificationstation.stationapi.api.client.event.option;

import lombok.RequiredArgsConstructor;
import net.minecraft.client.options.KeyBinding;
import net.modificationstation.stationapi.api.common.event.Event;

import java.util.*;

/**
 * Used to add keybindings to the keybinding screen.
 * Implement this in the class you plan to use to add your keybindings, and then override registerKeyBindings(List{@literal <KeyBinding>} keyBindings).
 * You then want to add your instantiated keybindings into the list using keyBindings.add(myKeybind).
 * All events need to be registered in your mod's preInit method using KeyBindingRegister.EVENT.register(yourInstantiatedClass).
 * <p>
 * You also likely want to use the KeyPressed event to handle your keybindings.
 *
 * @author mine_diver
 * @see KeyBinding
 * @see List#add(Object)
 */
@RequiredArgsConstructor
public class KeyBindingRegisterEvent extends Event {

    public final List<KeyBinding> keyBindings;

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
