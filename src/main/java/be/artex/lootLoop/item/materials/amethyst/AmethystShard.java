package be.artex.lootLoop.item.materials.amethyst;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AmethystShard extends Item {
    private static final ItemStack STACK = ItemBuilder.
            create(Material.AMETHYST_SHARD, ItemRarity.COMMON)
            .name("ᴀᴍᴇᴛʜʏsᴛ sʜᴀʀᴅ")
            .build();

    @Override
    public String getItemId() {
        return "amethyst_shard";
    }

    @Override
    public ItemStack getStack() {
        return STACK;
    }

    @Override
    public int getSellMoney() {
        return 5000;
    }
}
