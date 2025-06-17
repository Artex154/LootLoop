package be.artex.lootLoop.item.materials.fossil;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import be.artex.lootLoop.api.items.itemType.Recombobulable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Fossil extends Recombobulable {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.BONE, ItemRarity.EPIC)
                .name("ғᴏssɪʟᴇ")
                .description(Component.text("ᴏɴ ᴅɪᴛ ǫᴜ'ɪʟ ᴠɪᴇɴᴛ ᴅ'ᴜɴᴇ ᴛʀès ᴀɴᴄɪᴇɴɴᴇ ᴄɪᴠɪʟɪsᴀᴛɪᴏɴ.   ", NamedTextColor.GRAY), Component.text("ɪʟ ᴀ ᴜɴᴇ ᴛʀès ɢʀᴀɴᴅᴇ ᴠᴀʟᴇᴜʀ.", NamedTextColor.GRAY))
                .build();

    @Override
    public String getItemId() {
        return "fossil";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 1000000;
    }

    @Override
    public Item getRecombobulatedItem() {
        return new LegFossil();
    }
}
