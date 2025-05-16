package be.artex.lootLoop.minerals.stone.drops.hardRock;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import org.jetbrains.annotations.NotNull;

public class HardRockDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return new HardRock();
    }

    @Override
    public float getDropChance() {
        return 1;
    }
}
