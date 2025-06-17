package be.artex.lootLoop.api.items.builders;

import be.artex.lootLoop.api.items.ItemRarity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemBuilder {
    private final ItemStack stack;
    private final ItemRarity rarity;
    private Component name = Component.empty();
    private List<Component> description = new ArrayList<>();

    public ItemBuilder(ItemStack stack, ItemRarity rarity) {
        this.stack = stack.clone();
        this.rarity = rarity;
    }

    public static ItemBuilder create(ItemStack stack, ItemRarity rarity) {
        return new ItemBuilder(stack, rarity);
    }

    public static ItemBuilder create(Material material, ItemRarity rarity) {
        return new ItemBuilder(new ItemStack(material), rarity);
    }

    public static ItemBuilder create(ItemStack stack) {
        return new ItemBuilder(stack, ItemRarity.COMMON);
    }

    public static ItemBuilder create(Material material) {
        return new ItemBuilder(new ItemStack(material), ItemRarity.COMMON);
    }

    public ItemBuilder name(String name) {
        this.name = Component.text(name, this.rarity.getColor());
        return this;
    }

    public ItemBuilder description(Component... description) {
        List<Component> l = new ArrayList<>();
        Collections.addAll(l, description);

        l.add(Component.empty());
        l.add(rarity.getDisplayText().decoration(TextDecoration.ITALIC, false));

        this.description = l;

        return this;
    }

    public ItemStack build() {
        ItemStackBuilder builder = ItemStackBuilder.create(stack);

        if (!Component.empty().equals(this.name))
            builder.name(this.name);

        builder.lore(this.description);

        return builder.build();
    }

}
