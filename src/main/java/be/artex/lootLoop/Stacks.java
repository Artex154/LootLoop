package be.artex.lootLoop;

import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import be.artex.lootLoop.api.items.builders.ItemStackBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    public static final ItemStack BORDER = ItemStackBuilder.create(Material.BLACK_STAINED_GLASS_PANE)
            .name(" ")
            .build();

    public static final ItemStack COMBINE_ITEM = ItemStackBuilder.create(Material.ANVIL)
            .name(Component.text("ᴄᴏᴍʙɪɴᴇʀ ʟᴇs ᴏʙᴊᴇᴛs", NamedTextColor.YELLOW))
            .lore(Component.text("ᴄʟɪǫᴜᴇᴢ ᴘᴏᴜʀ ᴄᴏᴍʙɪɴᴇʀ ʟᴇs ᴏʙᴊᴇᴛs", NamedTextColor.GRAY))
            .build();

    public static final ItemStack NO_RESULT = ItemStackBuilder.create(Material.BARRIER)
            .name(Component.text("ᴏʙᴊᴇᴛs ɴᴏɴ ᴄᴏᴍʙɪɴᴀʙʟᴇs", NamedTextColor.RED))
            .lore(Component.text("ᴄᴇs ᴏʙᴊᴇᴛs ɴᴇ ᴘᴇᴜᴠᴇɴᴛ ᴘᴀs ᴇᴛʀᴇ ᴄᴏᴍʙɪɴᴇs", NamedTextColor.GRAY))
            .build();


    public static final ItemStack RECOMBOBULATOR = ItemBuilder.create(Material.EMERALD, ItemRarity.LEGENDARY)
            .name("ʀᴇᴄᴏᴍʙᴏʙᴜʟᴀᴛᴏʀ")
            .description(Component.text("ᴄᴏᴍʙɪɴᴇʀ ᴀᴠᴇᴄ ᴜɴ ᴏʙᴊᴇᴛ ᴘᴏᴜʀ ᴀᴍᴇʟɪᴏʀᴇʀ sᴀ ʀᴀʀɪᴛᴇ", NamedTextColor.GRAY))
            .build();
}
