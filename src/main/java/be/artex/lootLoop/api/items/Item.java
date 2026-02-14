package be.artex.lootLoop.api.items;

import be.artex.lootLoop.GUI.combining.CombinePossibilty;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Item {
    private static final List<Item> REGISTERED_ITEMS = new ArrayList<>();

    public abstract String getItemId();
    public abstract ItemStack getStack();
    public abstract int getSellMoney();

    public List<CombinePossibilty> getCombinePossibilities() {
        return List.of();
    }

    public void onHit(Player damager, Player target) {
    }

    public void onClick(Player player, ItemStack stack) {
    }

    public void onClickAtEntity(Player player, ItemStack stack, Entity entity) {
    }

    public static Item registerItem(Item item) {
        REGISTERED_ITEMS.add(item);
        return item;
    }

    public static List<Item> getRegisteredItems() {
        return Collections.unmodifiableList(REGISTERED_ITEMS);
    }

    public static @Nullable Item getItemFromStack(@Nullable ItemStack stack) {
        if (stack == null || stack.getType() == Material.AIR)
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (Objects.equals(item.getStack().getItemMeta(), stack.getItemMeta()))
                return item;
        }

        return null;
    }

    public static @Nullable Item getItemFromId(@Nullable String id) {
        if (id == null || id.isBlank())
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (!item.getItemId().equalsIgnoreCase(id))
                continue;

            return item;
        }

        return null;
    }
}
