package be.artex.lootLoop.api;

import be.artex.lootLoop.api.events.Event;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class Mineral {
    public static final List<Mineral> REGISTERED_MINERALS = new ArrayList<>();

    public abstract @NotNull Material getMaterial();
    public abstract @NotNull List<Event> getEvents();

    public static @NotNull Mineral registerMineral(@NotNull Mineral mineral) {
        REGISTERED_MINERALS.add(mineral);
        return mineral;
    }

    public static @NotNull List<Mineral> getRegisteredMinerals() {
        return Collections.unmodifiableList(REGISTERED_MINERALS);
    }

    public static @Nullable Mineral getMineralFromMaterial(@NotNull Material material) {
        for (Mineral mineral : REGISTERED_MINERALS) {
            if (mineral.getMaterial() == material)
                return mineral;
        }

        return null;
    }

    public static @Nullable Event generateEvent(@NotNull Mineral mineral) {
       return generateEvent(mineral, new Random().nextFloat(100));
    }

    public static @Nullable Event generateEvent(@NotNull Mineral mineral, float lootnum) {
        Event event = null;

        for (Event e : mineral.getEvents()) {
            if (!(lootnum <= e.getProbability()))
                continue;

            if (event == null || e.getProbability() < event.getProbability())
                event = e;
        }

        return event;
    }
}
