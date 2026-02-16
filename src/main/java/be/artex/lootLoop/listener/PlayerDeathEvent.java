package be.artex.lootLoop.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerDeathEvent implements Listener {
    @EventHandler
    public void playerRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(PlayerConnectionEvent.SPAWN_POINT);
    }
}
