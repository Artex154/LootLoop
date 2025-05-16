package be.artex.lootLoop.minerals.stone.drops.fossil;

import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Fossil extends Item {
    @Override
    public ItemStack getStack() {
        ItemStack stack = new ItemStack(Material.BONE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(Component.text("Fossile", NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false));
        meta.lore(List.of(
                Component.text("ᴏɴ ᴅɪᴛ ǫᴜ'ɪʟ ᴠɪᴇɴᴛ ᴅ'ᴜɴᴇ ᴛʀès ᴀɴᴄɪᴇɴɴᴇ ᴄɪᴠɪʟɪsᴀᴛɪᴏɴ.", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                Component.text("ɪʟ ᴀ ᴜɴᴇ ᴛʀès ɢʀᴀɴᴅᴇ ᴠᴀʟᴇᴜʀ.", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                Component.text(" "),
                Component.text("ᴏʙᴊᴇᴛ ʀᴀʀᴇ", NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false)
        ));

        stack.setItemMeta(meta);

        return stack;
    }

    @Override
    public int getSellMoney() {
        return 1000000;
    }
}
