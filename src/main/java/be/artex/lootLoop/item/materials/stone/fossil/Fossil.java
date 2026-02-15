package be.artex.lootLoop.item.materials.stone.fossil;

import be.artex.lootLoop.GUI.combining.CombinePossibilty;
import be.artex.lootLoop.Items;
import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Fossil extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.BONE, ItemRarity.EPIC)
                .name("ғᴏssɪʟ")
                .description(Component.text(" ɪᴛ sᴀɪᴅ ᴛʜᴀᴛ ɪᴛ ᴄᴏᴍᴇs ғʀᴏᴍ ᴀ ᴠᴇʀʏ ᴏʟᴅ ᴄɪᴠɪsɪʟᴀᴛɪᴏɴ.   ", NamedTextColor.GRAY), Component.text("ɪᴛ ʜᴀs ᴀ ᴠᴇʀʏ ɢʀᴇᴀᴛ ᴠᴀʟᴜᴇ.", NamedTextColor.GRAY))
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
    public List<CombinePossibilty> getCombinePossibilities() {
        return List.of(new CombinePossibilty(this, Items.RECOMBOBULATOR, Items.LEGENDARY_FOSSIL));
    }
}
