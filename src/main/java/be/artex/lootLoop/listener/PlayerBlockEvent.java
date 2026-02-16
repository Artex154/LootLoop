package be.artex.lootLoop.listener;

import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerBlockEvent implements Listener {
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        event.setCancelled(true);

        Mineral mineral = Mineral.getMineralFromMaterial(block.getType());

        if (mineral == null)
            return;

        mineral.onBreak(player, block);

        addMinedBlock(PlayerConnectionEvent.boards.get(player.getUniqueId()), player);
    }

    private static void addMinedBlock(FastBoard board, Player player) {
        Statistics.addLong(player, Statistics.MINED_BLOCS, 1);

        if (board != null)
            Scoreboard.updateBoard(board, player);
        else
            player.sendMessage(Component.text("[", NamedTextColor.RED).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", NamedTextColor.RED).append(
                                    Component.text(" ʏᴏᴜ ᴅᴏ ɴᴏᴛ ʜᴀᴠᴇ ᴛʜᴇ sᴄᴏʀᴇʙᴏᴀʀᴅ. ᴘʟᴇᴀsᴇ ᴅɪsᴄᴏɴɴᴇᴄᴛ ᴀɴᴅ ʀᴇᴄᴏɴɴᴇᴄᴛ.")))));
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

}
