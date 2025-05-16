package be.artex.lootLoop.minerals.stone.drops.stoneCube;

import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class StoneCube extends Item {
    @Override
    public ItemStack getStack() {
        ItemStack stack = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(Component.text("Cube de Pierre", NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, false));
        meta.lore(List.of(
                Component.text("ᴜɴ ᴅᴇs ᴏʙᴊᴇᴛs ᴀᴠᴇᴄ ʟᴇ ᴍᴏɪɴs ᴅᴇ ᴠᴀʟᴇᴜʀ ᴅᴇ ᴄᴇ ᴍᴏɴᴅᴇ,", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                Component.text("ᴍᴀɪs ɪʟ ғᴀᴜᴛ ʙɪᴇɴ ᴄᴏᴍᴍᴇɴᴄᴇʀ ǫᴜᴇʟǫᴜᴇ ᴘᴀʀᴛ!", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                Component.text(" "),
                Component.text("ᴏʙᴊᴇᴛ ᴄᴏᴍᴍᴜɴ", NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, false)
        ));

        stack.setItemMeta(meta);

        return stack;
    }

    @Override
    public int getSellMoney() {
        return 10000;
    }
}
