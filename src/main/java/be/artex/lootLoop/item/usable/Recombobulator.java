package be.artex.lootLoop.item.usable;

import be.artex.lootLoop.Stacks;
import be.artex.lootLoop.api.items.Item;
import org.bukkit.inventory.ItemStack;

public class Recombobulator extends Item {
    @Override
    public String getItemId() {
        return "recombobulator";
    }

    @Override
    public ItemStack getStack() {
        return Stacks.RECOMBOBULATOR;
    }

    @Override
    public int getSellMoney() {
        return 7000000;
    }
}
