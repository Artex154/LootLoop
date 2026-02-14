package be.artex.lootLoop.item.usable;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Recombobulator extends Item {
    public static final ItemStack STACK = ItemBuilder.create(Material.EMERALD, ItemRarity.LEGENDARY)
            .name("ʀᴇᴄᴏᴍʙᴏʙᴜʟᴀᴛᴏʀ")
            .description(Component.text("ɪᴛ sᴀɪᴅ ᴛʜᴀᴛ ᴡʜᴇɴ ᴄᴏᴍʙɪɴᴇᴅ ᴡɪᴛʜ ᴀɴᴏᴛʜᴇʀ ɪᴛᴇᴍ, ᴛʜᴀᴛ ɪᴛᴇᴍ's ʀᴀʀɪᴛʏ ᴜᴘɢʀᴀᴅᴇs.     ", NamedTextColor.GRAY))
            .build();

    @Override
    public String getItemId() {
        return "recombobulator";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 7000000;
    }
}
