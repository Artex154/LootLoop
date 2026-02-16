package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Iron extends Mineral {
    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_ORE;
    }

    @Override
    public void onBreak(Player player, Block block) {
        replaceTemporarily(block, Material.BEDROCK, 400, Material.STONE);

        super.onBreak(player, block);
    }
}
