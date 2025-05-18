package be.artex.lootLoop.listener;

import be.artex.lootLoop.GUI.CombineGUI;
import be.artex.lootLoop.Stacks;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack stack = event.getCurrentItem();

        if (stack == null)
            return;

        if (stack.equals(Stacks.BORDER) || stack.equals(Stacks.NO_RESULT)) {
            event.setCancelled(true);
            return;
        }

        if (!stack.equals(Stacks.COMBINE_ITEM))
            return;

        event.setCancelled(true);

        Inventory inventory = event.getClickedInventory();

        ItemStack firstItem = inventory.getItem(11);
        ItemStack secondItem = inventory.getItem(15);
        ItemStack result = Stacks.NO_RESULT;

        if (firstItem != null && secondItem != null)
            result = CombineGUI.combine(firstItem, secondItem);

        inventory.setItem(22, result);

        if (!result.equals(Stacks.NO_RESULT)) {
            inventory.setItem(11, new ItemStack(Material.AIR));
            inventory.setItem(15, new ItemStack(Material.AIR));
        }
    }
}
