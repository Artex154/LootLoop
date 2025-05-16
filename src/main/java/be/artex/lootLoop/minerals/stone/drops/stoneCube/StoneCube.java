package be.artex.lootLoop.minerals.stone.drops.stoneCube;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class StoneCube extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.COBBLESTONE)
            .name("Cube de Pierre")
            .description(Component.text("ᴜɴ ᴅᴇs ᴏʙᴊᴇᴛs ᴀᴠᴇᴄ ʟᴇ ᴍᴏɪɴs ᴅᴇ ᴠᴀʟᴇᴜʀ ᴅᴇ ᴄᴇ ᴍᴏɴᴅᴇ,", NamedTextColor.GRAY), Component.text("ᴍᴀɪs ɪʟ ғᴀᴜᴛ ʙɪᴇɴ ᴄᴏᴍᴍᴇɴᴄᴇʀ ǫᴜᴇʟǫᴜᴇ ᴘᴀʀᴛ!", NamedTextColor.GRAY))
            .build();

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 10000;
    }
}
