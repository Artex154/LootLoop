package be.artex.lootLoop.api.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public abstract class Event {
    public abstract float getProbability();

    public abstract void event(@NotNull Player player, Block block);
}
