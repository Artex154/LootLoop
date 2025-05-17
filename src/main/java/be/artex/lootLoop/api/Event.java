package be.artex.lootLoop.api;

import org.bukkit.event.block.BlockBreakEvent;

public abstract class Event {
    public abstract float getProbability();
    public abstract void event(BlockBreakEvent event);
}
