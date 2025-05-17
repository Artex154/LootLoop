package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.drop.FossilDrop;
import be.artex.lootLoop.drop.stone.HardRockDrop;
import be.artex.lootLoop.drop.stone.StoneCubeDrop;
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
        return List.of(new StoneCubeDrop(), new HardRockDrop(), new FossilDrop());
    }
}
