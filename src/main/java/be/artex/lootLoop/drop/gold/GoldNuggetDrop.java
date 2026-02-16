package be.artex.lootLoop.drop.gold;

import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.events.Drop;
import be.artex.lootLoop.api.items.Item;
import org.jetbrains.annotations.NotNull;

public class GoldNuggetDrop extends Drop {
    @Override
    public @NotNull Item getItem() {
        return Items.GOLD_NUGGET;
    }

    @Override
    public float getDropChance() {
        return 5;
    }
}
