package be.artex.lootLoop.listener;

import be.artex.lootLoop.LootLoop;
import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.events.Event;
import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerBlockEvent implements Listener {
    private static final Map<Location, Material> BLOCKS = new HashMap<>();

    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();

        event.setCancelled(true);

        breakBlock(player, event.getBlock());
    }

    private static void breakBlock(Player player, Block block) {
        addMinedBlock(PlayerConnectionEvent.boards.get(player.getUniqueId()), player);

        Material blockMaterial = block.getType();
        BlockData blockData = block.getBlockData();

        block.setType(Material.BEDROCK);

        Bukkit.getScheduler().runTaskLater(LootLoop.getInstance(), () -> {
            block.setType(blockMaterial);
            block.setBlockData(blockData);

        }, 20*20L);

        Mineral mineral = Mineral.getMineralFromMaterial(blockMaterial);

        if (mineral == null)
            return;

        Event mineralEvent = Mineral.generateEvent(mineral);

        if (mineralEvent != null)
            mineralEvent.event(player, block);
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

}
