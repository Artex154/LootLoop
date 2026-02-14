package be.artex.lootLoop.item.materials.stone;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HardRock extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.STONE, ItemRarity.UNCOMMON)
            .name("ʜᴀʀᴅ ʀᴏᴄᴋ")
            .description(Component.text("ᴀ ᴠᴇʀʏ ʜᴀʀᴅ, ʙᴜᴛ ᴀʟsᴏ ʜᴇᴀᴠʏ ʀᴏᴄᴋ.", NamedTextColor.GRAY))
            .build();

    @Override
    public String getItemId() {
        return "hard_rock";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 30000;
    }
}
