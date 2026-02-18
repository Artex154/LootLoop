package be.artex.lootLoop.registry;

import be.artex.lootLoop.Stacks;
import be.artex.lootLoop.api.items.Item;
import org.bukkit.inventory.ItemStack;

public class Items {
    public static final Item STONE_CUBE = registerSimpleItem("stone_cube", Stacks.STONE_CUBE, Item.Properties.create().sellValue(20)).register();
    public static final Item HARD_ROCK = registerSimpleItem("hard_rock", Stacks.HARD_ROCK, Item.Properties.create().sellValue(100)).register();
    public static final Item FOSSIL = registerSimpleItem("fossil", Stacks.FOSSIL, Item.Properties.create().sellValue(1000)).register();
    public static final Item RECOMBOBULATOR = registerSimpleItem("recombobulator", Stacks.RECOMBOBULATOR, Item.Properties.create().sellValue(25000));
    public static final Item AMETHYST_GEODE = registerSimpleItem("amethyst_geode", Stacks.AMETHYST_GEODE, Item.Properties.create().sellValue(1100));
    public static final Item AMETHYST_SHARD = registerSimpleItem("amethyst_shard", Stacks.AMETHYST_SHARD, Item.Properties.create().sellValue(105));
    public static final Item GOLD_NUGGET = registerSimpleItem("gold_nugget", Stacks.GOLD_NUGGET, Item.Properties.create().sellValue(7500));
    public static final Item IRON_NUGGET = registerSimpleItem("iron_nugget", Stacks.IRON_NUGGET, Item.Properties.create().sellValue(6000));
    public static final Item DIAMOND_SHARD = registerSimpleItem("diamond_shard", Stacks.DIAMOND_SHARD, Item.Properties.create().sellValue(11500));
    
    private static Item registerSimpleItem(String ID, ItemStack stack, Item.Properties properties) {
        Item item = new Item(ID, stack, properties);
        item.register();
        return item;
    }

    private static Item registerSimpleItem(String ID, ItemStack stack) {
        Item item = new Item(ID, stack);
        item.register();
        return item;
    }

    public static void register() {
    }
}
