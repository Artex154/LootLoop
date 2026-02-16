package be.artex.lootLoop.item.gold;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GoldNugget extends Item {
    public static final ItemStack STACK = ItemBuilder.create(Material.GOLD_NUGGET, ItemRarity.UNCOMMON)
            .name("ɢᴏʟᴅ ɴᴜɢɢᴇᴛ")
            .build();

    @Override
    public String getItemId() {
        return "gold_nugget";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 40000;
    }
}
