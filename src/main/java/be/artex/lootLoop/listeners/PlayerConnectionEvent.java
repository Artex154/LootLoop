package be.artex.lootLoop.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionEvent implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text("+", TextColor.color(50, 210, 50)))
                .append(Component.text("] ", NamedTextColor.DARK_GRAY))
                .append(Component.text("Artex54")));
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        event.quitMessage(Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text("-", NamedTextColor.DARK_RED))
                .append(Component.text("] ", NamedTextColor.DARK_GRAY))
                .append(Component.text("Artex54")));
    }
}
