package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.drop.amethyst.AmethystGeodeDrop;
import be.artex.lootLoop.drop.amethyst.AmethystShardDrop;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
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

    @Override
    public void onBreak(Player player, Block block) {
        replaceTemporarily(block, Material.BEDROCK, 400);

        super.onBreak(player, block);
    }
}
