package be.artex.lootLoop.item.materials.stone.fossil;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class LegendaryFossil extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.BONE, ItemRarity.LEGENDARY)
            .name("ғᴏssɪʟ")
            .description(Component.text(" ɪᴛ sᴀɪᴅ ᴛʜᴀᴛ ɪᴛ ᴄᴏᴍᴇs ғʀᴏᴍ ᴀ ᴠᴇʀʏ ᴏʟᴅ ᴄɪᴠɪsɪʟᴀᴛɪᴏɴ.   ", NamedTextColor.GRAY), Component.text("ɪᴛ ʜᴀs ᴀ ᴠᴇʀʏ ɢʀᴇᴀᴛ ᴠᴀʟᴜᴇ.", NamedTextColor.GRAY))
            .build();

    @Override
    public String getItemId() {
        return "leg_fossil";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 13000000;
    }
}
