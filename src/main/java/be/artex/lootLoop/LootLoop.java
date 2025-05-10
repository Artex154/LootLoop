package be.artex.lootLoop;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.listeners.PlayerBlockEvent;
import be.artex.lootLoop.listeners.PlayerConnectionEvent;
import be.artex.lootLoop.minerals.stone.Stone;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootLoop extends JavaPlugin {
    public static Plugin instance;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockEvent(), this);

        Mineral.registerMineral(new Stone());

        instance = this;
    }

}
