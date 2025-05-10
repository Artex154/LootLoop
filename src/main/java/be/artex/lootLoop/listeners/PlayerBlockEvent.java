package be.artex.lootLoop.listeners;

import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.scoreboard.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerBlockEvent implements Listener {
    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();

        int minedBlocks = playerPDC.get(Statistics.MINED_BLOCS, PersistentDataType.INTEGER) + 1;

        playerPDC.set(Statistics.MINED_BLOCS, PersistentDataType.INTEGER, minedBlocks);

        FastBoard board = PlayerConnectionEvent.boards.get(player.getUniqueId());

        if (board != null)
            Scoreboard.updateBoard(board, player);
        else
            player.sendMessage(Component.text("[", NamedTextColor.DARK_GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.RED).append(
                            Component.text("]", NamedTextColor.DARK_GRAY).append(
                                    Component.text(" ᴠᴏᴜs ɴᴇ ᴘᴏsséᴅᴇᴢ ᴘᴀs ᴅᴇ sᴄᴏʀᴇʙᴏᴀʀᴅ, ᴅéᴄᴏɴɴɴᴇᴄᴛᴇᴢ ᴇᴛ ʀᴇᴄᴏɴɴᴇᴄᴛᴇᴢ ᴠᴏᴜs ᴘᴏᴜʀ ʟᴇ ʀᴇᴄᴇᴠᴏɪʀ.")))));
    }
}
