package be.artex.lootLoop.api.items;

import be.artex.lootLoop.GUI.combining.CombinePossibilty;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Item {
    private static final List<Item> REGISTERED_ITEMS = new ArrayList<>();

    private final String itemID;
    private final ItemStack stack;
    private final long sellMoney;
    private final List<CombinePossibilty> combinePossibilties;

    public Item(String id, ItemStack stack, long sellMoney) {
        this.itemID = id;
        this.stack = stack;
        this.sellMoney = sellMoney;
        this.combinePossibilties = List.of();
    }

    public Item(String id, ItemStack stack, long sellMoney, List<CombinePossibilty> combinePossibilties) {
        this.itemID = id;
        this.stack = stack;
        this.sellMoney = sellMoney;
        this.combinePossibilties = combinePossibilties;
    }

    public String getItemID() {
        return itemID;
    }

    public ItemStack getItemStack() {
        return stack.clone();
    }

    public long getSellMoney() {
        return sellMoney;
    }

    public List<CombinePossibilty> getCombinePossibilties() {
        return combinePossibilties;
    }

    public Item register() {
        REGISTERED_ITEMS.add(this);
        return this;
    }

    public static List<Item> getRegisteredItems() {
        return Collections.unmodifiableList(REGISTERED_ITEMS);
    }

    public static @Nullable Item getItemFromStack(@Nullable ItemStack stack) {
        if (stack == null || stack.getType() == Material.AIR)
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (Objects.equals(item.getItemStack().getItemMeta(), stack.getItemMeta()))
                return item;
        }

        return null;
    }

    public static @Nullable Item getItemFromId(@Nullable String id) {
        if (id == null || id.isBlank())
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (!item.getItemID().equalsIgnoreCase(id))
                continue;

            return item;
        }

        return null;
    }
}
