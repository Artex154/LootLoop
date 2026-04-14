package be.artex.lootLoop.api.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Item {
    private static final List<Item> REGISTERED_ITEMS = new ArrayList<>();

    private final String itemID;
    private final ItemStack stack;

    private long sellValue;
    private ToolProperties toolProperties = null;

    public Item(String id, ItemStack stack, Properties properties) {
        this.itemID = id;
        this.stack = stack;
        this.sellValue = properties.sellValue;
        this.toolProperties = properties.toolProperties;
    }

    public Item(String id, ItemStack stack) {
        Properties properties = new Properties();

        this.itemID = id;
        this.stack = stack;
        this.sellValue = properties.sellValue;
    }

    public String getItemID() {
        return itemID;
    }

    public ItemStack asItemStack() {
        return stack.clone();
    }

    public long getSellValue() {
        return this.sellValue;
    }

    public int getMiningSpeed() {
        return this.toolProperties.miningSpeed();
    }

    public int getMiningFortune() {
        return this.toolProperties.miningFortune();
    }

    public boolean isTool() {
        return this.toolProperties != null;
    }

    public Item register() {
        REGISTERED_ITEMS.add(this);
        return this;
    }

    public static @NotNull List<Item> getRegisteredItems() {
        return Collections.unmodifiableList(REGISTERED_ITEMS);
    }

    public static @Nullable Item getItemFromStack(@Nullable ItemStack stack) {
        if (stack == null || stack.getType() == Material.AIR)
            return null;

        for (Item item : REGISTERED_ITEMS) {
            if (Objects.equals(item.asItemStack().getItemMeta(), stack.getItemMeta()))
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

    public static class Properties {
        private long sellValue = 0;
        private ToolProperties toolProperties = null;

        private Properties() {
        }

        public static Item.Properties create() {
            return new Properties();
        }

        public Item.Properties sellValue(long sellValue) {
            this.sellValue = sellValue;
            return this;
        }

        public Item.Properties tool(ToolProperties properties) {
            this.toolProperties = properties;
            return this;
        }
    }
}
