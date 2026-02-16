package be.artex.lootLoop.listener;

import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.scoreboard.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class PlayerConnectionEvent implements Listener {
    public static final Map<UUID, FastBoard> boards = new HashMap<>();

    public static final Location SPAWN_POINT = new Location(Bukkit.getWorlds().getFirst(), 290.5, -40, -91.5, 0, 0);

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();

        event.joinMessage(Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text("+", TextColor.color(50, 210, 50)))
                .append(Component.text("] ", NamedTextColor.DARK_GRAY))
                .append(Component.text(player.getName())));

        player.teleport(SPAWN_POINT);

        if (!playerPDC.has(Statistics.MINED_BLOCS))
            playerPDC.set(Statistics.MINED_BLOCS, PersistentDataType.INTEGER, 0);

        if (!playerPDC.has(Statistics.MONEY))
            playerPDC.set(Statistics.MONEY, PersistentDataType.INTEGER, 0);

        FastBoard board = new FastBoard(player);

        board.updateTitle(Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", TextColor.color(252, 194, 1)).decorate(TextDecoration.BOLD, TextDecoration.ITALIC));

        Scoreboard.updateBoard(board, player);

        boards.put(player.getUniqueId(), board);
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.quitMessage(Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text("-", NamedTextColor.DARK_RED))
                .append(Component.text("] ", NamedTextColor.DARK_GRAY))
                .append(Component.text(player.getName())));

        FastBoard board = boards.remove(player.getUniqueId());

        if (board != null)
           board.delete();
    }
}
