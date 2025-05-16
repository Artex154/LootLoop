package be.artex.lootLoop.minerals.stone.drops.fossil;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import org.jetbrains.annotations.NotNull;

public class FossilDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return new Fossil();
    }

    @Override
    public float getDropChance() {
        return 0.07f;
    }
}
