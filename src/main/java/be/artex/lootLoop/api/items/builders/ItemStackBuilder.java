package be.artex.lootLoop.api.items.builders;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    private final ItemStack stack;
    private Component name = Component.text("");
    private List<Component> lore = new ArrayList<>();

    private ItemStackBuilder(ItemStack stack) {
        this.stack = stack;
    }

    public static ItemStackBuilder create(ItemStack stack) {
        return new ItemStackBuilder(stack);
    }

    public static ItemStackBuilder create(Material material) {
        return create(new ItemStack(material));
    }

    public ItemStackBuilder name(Component name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder name(String name) {
        this.name = Component.text(name);
        return this;
    }

    public ItemStackBuilder lore(Component... lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore = l;

        return this;
    }

    public ItemStackBuilder lore(List<Component> lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore = l;
        return this;
    }

    public ItemStack build() {
        ItemMeta meta = this.stack.getItemMeta();

        if (!this.name.equals(Component.empty()))
            meta.displayName(this.name.decoration(TextDecoration.ITALIC, false));

        if (!this.lore.isEmpty())
            meta.lore(lore);

        this.stack.setItemMeta(meta);

        return this.stack;
    }

}
