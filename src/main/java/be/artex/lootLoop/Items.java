package be.artex.lootLoop;

import be.artex.lootLoop.GUI.combining.CombinePossibilty;
import be.artex.lootLoop.api.items.Item;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Items {
    public static final Item STONE_CUBE = registerSimpleItem("stone_cube", Stacks.STONE_CUBE, 20).register();
    public static final Item HARD_ROCK = registerSimpleItem("hard_rock", Stacks.HARD_ROCK, 100).register();
    public static final Item FOSSIL = registerSimpleItem("fossil", Stacks.FOSSIL, 1000).register();
    public static final Item RECOMBOBULATOR = registerSimpleItem("recombobulator", Stacks.RECOMBOBULATOR, 25000);
    public static final Item AMETHYST_GEODE = registerSimpleItem("amethyst_geode", Stacks.AMETHYST_GEODE, 1100);
    public static final Item AMETHYST_SHARD = registerSimpleItem("amethyst_shard", Stacks.AMETHYST_SHARD, 105);
    public static final Item GOLD_NUGGET = registerSimpleItem("gold_nugget", Stacks.GOLD_NUGGET, 7500);
    public static final Item IRON_NUGGET = registerSimpleItem("iron_nugget", Stacks.IRON_NUGGET, 6500);
    public static final Item DIAMOND_SHARD = registerSimpleItem("diamond_shard", Stacks.DIAMOND_SHARD, 11500);
    
    private static Item registerSimpleItem(String ID, ItemStack stack, long sellMoney) {
        Item item = new Item(ID, stack, sellMoney);
        item.register();
        return item;
    }

    private static Item registerSimpleItem(String ID, ItemStack stack, long sellMoney, List<CombinePossibilty> combinePossibilties) {
        Item item = new Item(ID, stack, sellMoney, combinePossibilties);
        item.register();
        return item;
    }

    public static void register() {
    }
}
