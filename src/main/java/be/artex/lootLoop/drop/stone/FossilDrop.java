package be.artex.lootLoop.drop.stone;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import org.jetbrains.annotations.NotNull;

public class FossilDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.FOSSIL;
    }

    @Override
    public float getDropChance() {
        return 0.1f;
    }
}
