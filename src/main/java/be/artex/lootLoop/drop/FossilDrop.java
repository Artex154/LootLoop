package be.artex.lootLoop.drop;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.item.materials.Fossil;
import org.jetbrains.annotations.NotNull;

public class FossilDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return new Fossil();
    }

    @Override
    public float getDropChance() {
        return 0.7f;
    }
}
