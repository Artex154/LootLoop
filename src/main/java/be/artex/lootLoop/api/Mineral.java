package be.artex.lootLoop.api;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class Mineral {
    public static final List<Mineral> REGISTERED_MINERALS = new ArrayList<>();

    public abstract @NotNull Material getMaterial();
    public abstract @NotNull List<Event> getEvents();

    public static void registerMineral(Mineral mineral) {
        REGISTERED_MINERALS.add(mineral);
    }

    public static List<Mineral> getRegisteredMinerals() {
        return Collections.unmodifiableList(REGISTERED_MINERALS);
    }

    public static Mineral getMineralFromMaterial(Material material) {
        for (Mineral mineral : REGISTERED_MINERALS) {
            if (!mineral.getMaterial().equals(material))
                continue;

            return mineral;
        }

        return null;
    }

    public static Event generateEvent(Mineral mineral) {
        float lootnum = new Random().nextFloat(100);
        Event event = null;

        for (Event e : mineral.getEvents()) {
            if (!(lootnum <= e.getProbability()))
                continue;

            if (event == null || e.getProbability() < event.getProbability())
                event = e;
        }

        return event;
    }

    public static Event generateEvent(Mineral mineral, float lootnum) {
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
