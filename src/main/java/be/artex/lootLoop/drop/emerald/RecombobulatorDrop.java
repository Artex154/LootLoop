package be.artex.lootLoop.drop.emerald;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.api.items.Item;
import org.jetbrains.annotations.NotNull;

public class RecombobulatorDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.RECOMBOBULATOR;
    }

    @Override
    public float getDropChance() {
        return 1f;
    }
}
