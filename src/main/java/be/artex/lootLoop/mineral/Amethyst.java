package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.drop.amethyst.AmethystGeodeDrop;
import be.artex.lootLoop.drop.amethyst.AmethystShardDrop;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Amethyst extends Mineral {
    @Override
    public @NotNull Material getMaterial() {
        return Material.AMETHYST_BLOCK;
    }

    @Override
    public @NotNull List<Event> getEvents() {
        return List.of(new AmethystGeodeDrop(), new AmethystShardDrop());
    }
}
