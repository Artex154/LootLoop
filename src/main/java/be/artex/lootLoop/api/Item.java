package be.artex.lootLoop.api;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Item {
    public static final List<Item> REGISTERED_ITEMS = new ArrayList<>();

    public abstract ItemStack getStack();
    public abstract int getSellMoney();

    public void onHit(Player damager, Player target) {
    }

    public void onClick(Player player, ItemStack stack) {
    }

    public void onClickAtEntity(Player player, ItemStack stack, Entity entity) {
    }

    public static void registerItem(Item item) {
        REGISTERED_ITEMS.add(item);
    }

    public static List<Item> getRegisteredItems() {
        return Collections.unmodifiableList(REGISTERED_ITEMS);
    }

    public static Item getItemFromStack(ItemStack stack) {
        if (stack == null || stack.getType().equals(Material.AIR))
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (!Objects.equals(item.getStack().getItemMeta(), stack.getItemMeta()))
                continue;

            return item;
        }

        return null;
    }

}
