package be.artex.lootLoop.listener;

import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.scoreboard.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockEvent implements Listener {
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();

        addMinedBlock(PlayerConnectionEvent.boards.get(player.getUniqueId()), player);

        Mineral mineral = Mineral.getMineralFromMaterial(event.getBlock().getType());

        if (mineral == null)
            return;

        Event mineralEvent = Mineral.generateEvent(mineral);

        if (mineralEvent != null)
            mineralEvent.event(event);
    }

    private static void addMinedBlock(FastBoard board, Player player) {
        Statistics.addInt(player, Statistics.MINED_BLOCS, 1);

        if (board != null)
            Scoreboard.updateBoard(board, player);
        else
            player.sendMessage(Component.text("[", NamedTextColor.RED).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", NamedTextColor.RED).append(
                                    Component.text(" ʏᴏᴜ ᴅᴏ ɴᴏᴛ ʜᴀᴠᴇ ᴛʜᴇ sᴄᴏʀᴇʙᴏᴀʀᴅ. ᴘʟᴇᴀsᴇ ᴅɪsᴄᴏɴɴᴇᴄᴛ ᴀɴᴅ ʀᴇᴄᴏɴɴᴇᴄᴛ.")))));
    }

}
