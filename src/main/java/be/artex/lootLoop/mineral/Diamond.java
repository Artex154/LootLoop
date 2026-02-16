package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.drop.diamond.DiamondShardDrop;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Diamond extends Mineral {
    @Override
    public @NotNull Material getMaterial() {
        return Material.DIAMOND_ORE;
    }

    @Override
    public void onBreak(Player player, Block block) {
        replaceTemporarily(block, Material.BEDROCK, 400, Material.STONE);

        super.onBreak(player, block);
    }

    @Override
    public @NotNull List<Event> getEvents() {
        return List.of(new DiamondShardDrop());
    }
}
