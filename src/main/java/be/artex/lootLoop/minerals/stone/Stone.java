package be.artex.lootLoop.minerals.stone;

import be.artex.lootLoop.api.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.minerals.stone.drops.stoneCube.StoneCubeDrop;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Stone extends Mineral {
    @Override
    public @NotNull Material getMaterial() {
        return Material.STONE;
    }

    @Override
    public @NotNull List<Event> getEvents() {
        return List.of(new StoneCubeDrop());
    }
}
