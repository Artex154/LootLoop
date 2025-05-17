package be.artex.lootLoop.drop.stone;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.item.materials.stone.StoneCube;
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
