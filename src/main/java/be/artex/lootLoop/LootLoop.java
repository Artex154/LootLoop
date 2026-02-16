package be.artex.lootLoop;

import be.artex.lootLoop.command.Sell;
import be.artex.lootLoop.command.Test;
import be.artex.lootLoop.listener.*;
import be.artex.lootLoop.registry.Items;
import be.artex.lootLoop.registry.Minerals;
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
        Bukkit.getPluginManager().registerEvents(new PlayerDeathEvent(), this);

        getCommand("sell").setExecutor(new Sell());
        getCommand("test").setExecutor(new Test());

        Items.register();
        Minerals.register();

        instance = this;
    }

    public static Plugin getInstance() {
        return instance;
    }
}
