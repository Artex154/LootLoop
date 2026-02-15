package be.artex.lootLoop.drop.amethyst;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.api.items.Item;
import org.jetbrains.annotations.NotNull;

public class AmethystShardDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.AMETHYST_SHARD;
    }

    @Override
    public float getDropChance() {
        return 0.9f;
    }
}
