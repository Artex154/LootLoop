package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.Drop;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.registry.Items;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Stone extends Mineral {
    private static final Map<Material, Float> STONE_REPLACEMENT_PERCENTAGES = new HashMap<>();

    static {
        STONE_REPLACEMENT_PERCENTAGES.put(Material.COAL_ORE, 2f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.IRON_AXE, 1.5f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.GOLD_ORE, 1.35f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.LAPIS_ORE, 1.25f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.REDSTONE_ORE, 1.1f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.DIAMOND_ORE, 0.9f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.EMERALD_ORE, 0.7f);
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.STONE;
    }

    @Override
    public @NotNull List<Drop> getDrops() {
        return List.of(new Drop(Items.STONE_CUBE, 5f), new Drop(Items.HARD_ROCK, 1f), new Drop(Items.FOSSIL, 0.1f));
    }

    @Override
    public void onBreak(Player player, Block block) {
        Material replacement = generateBlock(new Random().nextFloat(100));

        if (replacement == null)
            replaceTemporarily(block, Material.BEDROCK, 400, Material.STONE);
        else
            block.setType(replacement);

        super.onBreak(player, block);
    }

    public static @Nullable Material generateBlock(float lootnum) {
        AtomicReference<Material> replacement = new AtomicReference<>();

        STONE_REPLACEMENT_PERCENTAGES.forEach((material, aFloat) -> {
            if (lootnum <= aFloat)
                replacement.set(material);
        });

        return replacement.get();
    }
}
