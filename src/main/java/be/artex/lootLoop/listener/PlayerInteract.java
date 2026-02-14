package be.artex.lootLoop.listener;

import be.artex.lootLoop.GUI.combining.CombineGUI;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (block != null && block.getType().equals(Material.SMITHING_TABLE)) {
            event.setCancelled(true);
            player.openInventory(CombineGUI.getInventory());
        }

    }

}
