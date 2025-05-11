package be.artex.lootLoop.minerals.stone.drops.hardRock;

import be.artex.lootLoop.api.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class HardRock extends Item {
    @Override
    public ItemStack getStack() {
        ItemStack stack = new ItemStack(Material.STONE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(Component.text("Roche dure", NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false));
        meta.lore(List.of(
                Component.text("ᴜɴᴇ ʀᴏᴄʜᴇ ᴛʀès ᴅᴜʀᴇ, ᴍᴀɪs ᴀᴜssɪ ᴛʀès ʟᴏᴜʀᴅᴇ", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                Component.text(" "),
                Component.text("ᴏʙᴊᴇᴛ ᴘᴇᴜ ᴄᴏᴍᴍᴜɴ", NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false)
        ));

        stack.setItemMeta(meta);

        return stack;
    }

    @Override
    public int getSellMoney() {
        return 30000;
    }
}
