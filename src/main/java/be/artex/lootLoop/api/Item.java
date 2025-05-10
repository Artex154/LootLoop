package be.artex.lootLoop.api;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Item {
    public static final List<Item> REGISTERED_ITEMS = new ArrayList<>();

    public abstract ItemStack getStack();

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

}
