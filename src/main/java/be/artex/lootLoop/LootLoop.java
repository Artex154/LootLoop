package be.artex.lootLoop;

import be.artex.lootLoop.listeners.PlayerConnectionEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootLoop extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvent(), this);
    }

}
