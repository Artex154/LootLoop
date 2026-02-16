package be.artex.lootLoop.drop.diamond;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.api.items.Item;
import org.jetbrains.annotations.NotNull;

public class DiamondShardDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.DIAMOND_SHARD;
    }

    @Override
    public float getDropChance() {
        return 3.5f;
    }
}
