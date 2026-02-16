package be.artex.lootLoop.item.diamond;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DiamondShard extends Item {
    public static final ItemStack STACK = ItemBuilder.create(Material.PRISMARINE_SHARD, ItemRarity.UNCOMMON)
            .name("ᴅɪᴀᴍᴏɴᴅ sʜᴀʀᴅ")
            .build();

    @Override
    public String getItemId() {
        return "diamond_shard";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 50000;
    }
}
