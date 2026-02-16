package be.artex.lootLoop.mineral;

import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.drop.stone.FossilDrop;
import be.artex.lootLoop.drop.stone.HardRockDrop;
import be.artex.lootLoop.drop.stone.StoneCubeDrop;
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
        STONE_REPLACEMENT_PERCENTAGES.put(Material.COAL_ORE, 1f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.IRON_AXE, 0.75f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.GOLD_ORE, 0.7f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.LAPIS_ORE, 0.65f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.REDSTONE_ORE, 0.6f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.DIAMOND_ORE, 0.4f);
        STONE_REPLACEMENT_PERCENTAGES.put(Material.EMERALD_ORE, 0.35f);
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.STONE;
    }

    @Override
    public @NotNull List<Event> getEvents() {
        return List.of(new StoneCubeDrop(), new HardRockDrop(), new FossilDrop());
    }

    @Override
    public void onBreak(Player player, Block block) {
        Material replacement = generateBlock(new Random().nextFloat(100));

        if (replacement == null)
            replaceTemporarily(block, Material.BEDROCK, 400);
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
