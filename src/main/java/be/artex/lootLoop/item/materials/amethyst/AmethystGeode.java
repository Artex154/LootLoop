package be.artex.lootLoop.item.materials.amethyst;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AmethystGeode extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.AMETHYST_BLOCK, ItemRarity.UNCOMMON)
            .name("ᴀᴍᴇᴛʜʏsᴛ ɢᴇᴏᴅᴇ")
            .description(Component.text("ᴀ ɢᴇᴏᴅᴇ ʀᴀʀᴇʟʏ ғᴏᴜɴᴅ ғʀᴏᴍ ᴀᴍᴇᴛʜʏsᴛ.   ", NamedTextColor.GRAY))
            .build();

    @Override
    public String getItemId() {
        return "amethyst_geode";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 50000;
    }
}
