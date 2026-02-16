package be.artex.lootLoop.item.iron;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IronNugget extends Item {
    public static final ItemStack STACK = ItemBuilder.create(Material.IRON_NUGGET, ItemRarity.COMMON)
            .name("ɪʀᴏɴ ɴᴜɢɢᴇᴛ")
            .build();

    @Override
    public String getItemId() {
        return "iron_nugget";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 30000;
    }
}
