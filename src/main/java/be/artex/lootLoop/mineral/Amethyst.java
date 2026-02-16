package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.api.Drop;
import be.artex.lootLoop.registry.Items;
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
    public @NotNull List<Drop> getDrops() {
        return List.of(new Drop(Items.AMETHYST_GEODE, 0.1f), new Drop(Items.AMETHYST_SHARD, 1f));
    }

    @Override
    public void onBreak(Player player, Block block) {
        replaceTemporarily(block, Material.BEDROCK, 400, Material.AMETHYST_BLOCK);

        super.onBreak(player, block);
    }
}
