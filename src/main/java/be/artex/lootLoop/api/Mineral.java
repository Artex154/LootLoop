package be.artex.lootLoop.api;

import be.artex.lootLoop.LootLoop;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.api.items.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class Mineral {
    public static final List<Mineral> REGISTERED_MINERALS = new ArrayList<>();

    public abstract @NotNull Material getMaterial();

    public @NotNull List<Event> getEvents() {
        return List.of();
    }

    public @NotNull List<Item> getGuaranteedDrops() {
        return List.of();
    }

    public void onBreak(Player player, Block block) {
        for (Item item : getGuaranteedDrops())
            player.give(item.getStack());

        Event mineralEvent = Mineral.generateEvent(this);

        if (mineralEvent != null)
            mineralEvent.event(player, block);
    }

    protected void replaceTemporarily(Block block, Material replacement, long ticks, Material finalMaterial) {
        block.setType(replacement);

        Bukkit.getScheduler().runTaskLater(LootLoop.getInstance(), () -> {
            if (block.getType() == replacement)
                block.setType(finalMaterial);
        }, ticks);
    }

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
