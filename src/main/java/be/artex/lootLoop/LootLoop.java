package be.artex.lootLoop;

import be.artex.lootLoop.api.Item;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.commands.Sell;
import be.artex.lootLoop.listeners.PlayerBlockEvent;
import be.artex.lootLoop.listeners.PlayerConnectionEvent;
import be.artex.lootLoop.minerals.stone.Stone;
import be.artex.lootLoop.minerals.stone.drops.fossil.Fossil;
import be.artex.lootLoop.minerals.stone.drops.hardRock.HardRock;
import be.artex.lootLoop.minerals.stone.drops.stoneCube.StoneCube;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootLoop extends JavaPlugin {
    public static Plugin instance;

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

}
