package be.artex.lootLoop.item.materials.stone;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
