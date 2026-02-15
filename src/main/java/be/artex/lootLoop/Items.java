package be.artex.lootLoop;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.item.materials.amethyst.AmethystGeode;
import be.artex.lootLoop.item.materials.amethyst.AmethystShard;
import be.artex.lootLoop.item.materials.stone.fossil.Fossil;
import be.artex.lootLoop.item.materials.stone.fossil.LegendaryFossil;
import be.artex.lootLoop.item.materials.stone.HardRock;
import be.artex.lootLoop.item.materials.stone.StoneCube;
import be.artex.lootLoop.item.usable.Recombobulator;

public class Items {
    public static final Item STONE_CUBE = Item.registerItem(new StoneCube());
    public static final Item HARD_ROCK = Item.registerItem(new HardRock());
    public static final Item FOSSIL = Item.registerItem(new Fossil());
    public static final Item LEGENDARY_FOSSIL = Item.registerItem(new LegendaryFossil());
    public static final Item RECOMBOBULATOR = Item.registerItem(new Recombobulator());
    public static final Item AMETHYST_GEODE = Item.registerItem(new AmethystGeode());
    public static final Item AMETHYST_SHARD = Item.registerItem(new AmethystShard());

    public static void register() {
    }
}
