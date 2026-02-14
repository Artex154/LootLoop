package be.artex.lootLoop.drop.stone;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.item.materials.stone.HardRock;
import org.jetbrains.annotations.NotNull;

public class HardRockDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.HARD_ROCK;
    }

    @Override
    public float getDropChance() {
        return 1;
    }
}
