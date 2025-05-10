package be.artex.lootLoop.listeners;

import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.scoreboard.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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

        addMinedBlock(PlayerConnectionEvent.boards.get(player.getUniqueId()), player, player.getPersistentDataContainer());

        Mineral mineral = Mineral.getMineralFromMaterial(event.getBlock().getType());

        if (mineral == null)
            return;

        Event mineralEvent = Mineral.generateEvent(mineral);

        if (mineralEvent != null)
            mineralEvent.event(event);
    }

    private static void addMinedBlock(FastBoard board, Player player, PersistentDataContainer PDC) {
        int minedBlocks = PDC.get(Statistics.MINED_BLOCS, PersistentDataType.INTEGER) + 1;

        PDC.set(Statistics.MINED_BLOCS, PersistentDataType.INTEGER, minedBlocks);

        if (board != null)
            Scoreboard.updateBoard(board, player);
        else
            player.sendMessage(Component.text("[", NamedTextColor.DARK_GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.RED).append(
                            Component.text("]", NamedTextColor.DARK_GRAY).append(
                                    Component.text(" ᴠᴏᴜs ɴᴇ ᴘᴏsséᴅᴇᴢ ᴘᴀs ᴅᴇ sᴄᴏʀᴇʙᴏᴀʀᴅ, ᴅéᴄᴏɴɴɴᴇᴄᴛᴇᴢ ᴇᴛ ʀᴇᴄᴏɴɴᴇᴄᴛᴇᴢ ᴠᴏᴜs ᴘᴏᴜʀ ʟᴇ ʀᴇᴄᴇᴠᴏɪʀ.")))));
    }

}
