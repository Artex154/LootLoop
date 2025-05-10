package be.artex.lootLoop;

import be.artex.lootLoop.listeners.PlayerBlockEvent;
import be.artex.lootLoop.listeners.PlayerConnectionEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.PublicKey;

public final class LootLoop extends JavaPlugin {
    public static Plugin instance;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockEvent(), this);

        instance = this;
    }

}
