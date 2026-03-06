package be.artex.lootLoop;

import be.artex.lootLoop.command.Sell;
import be.artex.lootLoop.command.Test;
import be.artex.lootLoop.listener.*;
import be.artex.lootLoop.registry.Items;
import be.artex.lootLoop.registry.Minerals;
import org.bukkit.Bukkit;
import org.bukkit.GameRules;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootLoop extends JavaPlugin {
    private static Plugin instance;
    public static World world;

    @Override
    public void onEnable() {
        instance = this;
        world = Bukkit.getWorlds().getFirst();

        gameRulesSetup(world);
        commandsSetup();
        listenersSetup();

        Items.register();
        Minerals.register();
    }

    private void gameRulesSetup(World world) {
        world.setGameRule(GameRules.PVP, false);
        world.setGameRule(GameRules.ADVANCE_TIME, false);
        world.setGameRule(GameRules.ADVANCE_WEATHER, false);
        world.setGameRule(GameRules.FALL_DAMAGE, false);
        world.setGameRule(GameRules.FIRE_DAMAGE, false);
        world.setGameRule(GameRules.DROWNING_DAMAGE, false);
        world.setGameRule(GameRules.IMMEDIATE_RESPAWN, true);
        world.setGameRule(GameRules.KEEP_INVENTORY, true);
        world.setGameRule(GameRules.LOCATOR_BAR, false);
        world.setGameRule(GameRules.MOB_GRIEFING, false);
        world.setGameRule(GameRules.RAIDS, false);
        world.setGameRule(GameRules.SHOW_DEATH_MESSAGES, false);
        world.setGameRule(GameRules.SHOW_ADVANCEMENT_MESSAGES, false);
        world.setGameRule(GameRules.SPAWN_WANDERING_TRADERS, false);
        world.setGameRule(GameRules.SPAWN_PATROLS, false);
        world.setGameRule(GameRules.SPAWN_PHANTOMS, false);
        world.setGameRule(GameRules.SPAWNER_BLOCKS_WORK, false);
        world.setGameRule(GameRules.TNT_EXPLODES, false);
    }

    public void commandsSetup() {
        getCommand("sell").setExecutor(new Sell());
        getCommand("test").setExecutor(new Test());
    }

    public void listenersSetup() {
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLevelChange(), this);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
