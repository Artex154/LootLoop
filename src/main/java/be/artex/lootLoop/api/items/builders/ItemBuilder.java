package be.artex.lootLoop.api.items.builders;

import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.ToolProperties;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemBuilder {
    private final ItemStack stack;
    private final ItemRarity rarity;
    private Component name = Component.empty();
    private final List<Component> description = new ArrayList<>();
    private int miningSpeed = 0;
    private int miningFortune = 0;

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
        Collections.addAll(this.description, description);
        return this;
    }

    public ItemBuilder tool(ToolProperties properties) {
        this.miningSpeed = properties.miningSpeed();
        this.miningFortune = properties.miningFortune();

        this.stack.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        if (this.miningSpeed != 0)
            this.description.add(Component.text("+" + this.miningSpeed, NamedTextColor.GOLD).append(
                    Component.text(" ᴍɪɴɪɴɢ sᴘᴇᴇᴅ.", NamedTextColor.GRAY)));

        if (this.miningFortune != 0)
            this.description.add(Component.text("+" + this.miningFortune, NamedTextColor.GOLD).append(
                    Component.text(" ᴍɪɴɪɴɢ ғᴏʀᴛᴜɴᴇ.", NamedTextColor.GRAY)));

        return this;
    }

    public ItemStack build() {
        AttributeModifier miningSpeedModifier = new AttributeModifier(
                new NamespacedKey("lootloop", "mining_speed"),
                this.miningSpeed,
                AttributeModifier.Operation.ADD_NUMBER);

        stack.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.itemAttributes().addModifier(
                        Attribute.BLOCK_BREAK_SPEED, miningSpeedModifier, EquipmentSlotGroup.MAINHAND));

        ItemStackBuilder builder = ItemStackBuilder.create(stack);

        if (!Component.empty().equals(this.name))
            builder.name(this.name);

        this.description.add(Component.empty());
        this.description.add(rarity.getDisplayText().decoration(TextDecoration.ITALIC, false));

        builder.lore(this.description);

        return builder.build();
    }

}
