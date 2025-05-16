package be.artex.lootLoop.minerals.stone.drops.stoneCube;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import org.jetbrains.annotations.NotNull;

public class StoneCubeDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return new StoneCube();
    }

    @Override
    public float getDropChance() {
        return 5;
    }
}
