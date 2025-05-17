package be.artex.lootLoop;

import be.artex.lootLoop.api.items.Item;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.command.Sell;
import be.artex.lootLoop.item.materials.Fossil;
import be.artex.lootLoop.listener.PlayerBlockEvent;
import be.artex.lootLoop.listener.PlayerConnectionEvent;
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

        getCommand("sell").setExecutor(new Sell());

        Mineral.registerMineral(new Stone());

        Item.registerItem(new StoneCube());
        Item.registerItem(new HardRock());
        Item.registerItem(new Fossil());

        instance = this;
    }

    public static Plugin getInstance() {
        return instance;
    }
}
