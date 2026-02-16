package be.artex.lootLoop.drop.iron;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.api.items.Item;
import org.jetbrains.annotations.NotNull;

public class IronNuggetDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.IRON_NUGGET;
    }

    @Override
    public float getDropChance() {
        return 5;
    }
}
