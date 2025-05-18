package be.artex.lootLoop.GUI;

import be.artex.lootLoop.Stacks;
import be.artex.lootLoop.api.items.Item;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CombineGUI {
    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, 45);

        int[] borderSlots = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 12, 13, 14, 16, 17,
                18, 19, 20, 21, 23, 24, 25, 26,
                27, 28, 29, 30, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
        };

        for (int i : borderSlots)
            inv.setItem(i, Stacks.BORDER);

        inv.setItem(31, Stacks.COMBINE_ITEM);

        return inv;
    }

    public static ItemStack combine(ItemStack firstStack, ItemStack secondStack) {
        ItemStack recombulator = Stacks.RECOMBOBULATOR;

        if (!firstStack.equals(recombulator) && !secondStack.equals(recombulator))
            return Stacks.NO_RESULT;

        if (!firstStack.equals(recombulator)) {
            Item item = Item.getItemFromStack(firstStack);

            if (item == null)
                return Stacks.NO_RESULT;

            Item recomb = item.getRecombobulatedItem();

            if (recomb == null)
                return Stacks.NO_RESULT;

            return recomb.getStack();
        }

        Item item = Item.getItemFromStack(secondStack);

        if (item == null)
            return Stacks.NO_RESULT;

        Item recomb = item.getRecombobulatedItem();

        if (recomb == null)
            return Stacks.NO_RESULT;

        return recomb.getStack();
    }

}
