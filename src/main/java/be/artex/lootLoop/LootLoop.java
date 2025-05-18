package be.artex.lootLoop;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.command.Sell;
import be.artex.lootLoop.command.Test;
import be.artex.lootLoop.item.materials.fossil.Fossil;
import be.artex.lootLoop.item.materials.fossil.LegFossil;
import be.artex.lootLoop.item.usable.Recombobulator;
import be.artex.lootLoop.listener.InventoryClick;
import be.artex.lootLoop.listener.PlayerBlockEvent;
import be.artex.lootLoop.listener.PlayerConnectionEvent;
import be.artex.lootLoop.listener.PlayerInteract;
import be.artex.lootLoop.mineral.Stone;
import be.artex.lootLoop.item.materials.stone.HardRock;
import be.artex.lootLoop.item.materials.stone.StoneCube;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootLoop extends JavaPlugin {
    private static Plugin instance;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);

        getCommand("sell").setExecutor(new Sell());
        getCommand("test").setExecutor(new Test());

        Mineral.registerMineral(new Stone());

        Item.registerItem(new StoneCube());
        Item.registerItem(new HardRock());
        Item.registerItem(new Fossil());
        Item.registerItem(new LegFossil());
        Item.registerItem(new Recombobulator());

        instance = this;
    }

    public static Plugin getInstance() {
        return instance;
    }
}
