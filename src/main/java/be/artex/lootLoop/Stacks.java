package be.artex.lootLoop;

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
            .name(Component.text("ᴄᴏᴍʙɪɴᴇ ᴛʜᴇ ɪᴛᴇᴍs", NamedTextColor.YELLOW))
            .lore(Component.text("ᴄʟɪᴄᴋ ᴛᴏ ᴄᴏᴍʙɪɴᴇ ᴛʜᴇ ɪᴛᴇᴍs", NamedTextColor.GRAY))
            .build();

    public static final ItemStack NO_RESULT = ItemStackBuilder.create(Material.BARRIER)
            .name(Component.text("ɪᴛᴇᴍs ɴᴏᴛ ᴄᴏᴍʙɪɴᴀʙʟᴇs", NamedTextColor.RED))
            .lore(Component.text("ᴛʜᴇsᴇs ɪᴛᴇᴍs ᴄᴀɴ ɴᴏᴛ ʙᴇ ᴄᴏᴍʙɪɴᴇᴅ", NamedTextColor.GRAY))
            .build();
}
