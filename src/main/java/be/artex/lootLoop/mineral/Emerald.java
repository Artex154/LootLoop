package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Mineral;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Emerald extends Mineral {
    @Override
    public @NotNull Material getMaterial() {
        return Material.EMERALD_ORE;
    }

    @Override
    public void onBreak(Player player, Block block) {
        replaceTemporarily(block, Material.BEDROCK, 400, Material.STONE);

        super.onBreak(player, block);
    }
}
