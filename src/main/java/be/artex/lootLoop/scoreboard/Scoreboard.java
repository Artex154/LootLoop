package be.artex.lootLoop.scoreboard;

import be.artex.lootLoop.Statistics;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Scoreboard {
    public static void updateBoard(FastBoard board, Player player) {
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        int minedBlocks = playerPDC.get(Statistics.MINED_BLOCS, PersistentDataType.INTEGER);
        int money = playerPDC.get(Statistics.MONEY, PersistentDataType.INTEGER);

        board.updateLines(
                Component.text("          ", TextColor.color(60, 60, 60)).decorate(TextDecoration.STRIKETHROUGH).append(
                        Component.text("           ", NamedTextColor.DARK_GRAY).decorate(TextDecoration.STRIKETHROUGH)).append(
                                Component.text("          ", TextColor.color(60, 60, 60)).decorate(TextDecoration.STRIKETHROUGH)),
                Component.text(" "),
                Component.text(player.getName() + ":", NamedTextColor.GRAY),
                Component.text(" ᴍᴏɴᴇʏ: ").append(
                                Component.text("$" + money, TextColor.color(50, 210, 50))),
                Component.text(" ᴛᴇᴍᴘs ᴅᴇ ᴊᴇᴜ: ").append(
                        Component.text(Statistics.playerHoursPlaytime(player) + " ʜᴇᴜʀᴇs", NamedTextColor.BLUE)),
                Component.text(" ʙʟᴏᴄs ᴍɪɴés: ").append(
                        Component.text(minedBlocks + " ʙʟᴏᴄs", TextColor.color(255, 179, 67))),
                Component.text(" "),
                Component.text("ᴊᴏᴜᴇᴜʀs: ").append(
                        Component.text(Bukkit.getOnlinePlayers().size(), TextColor.color(235, 75, 6))),
                Component.text(" "),
                Component.text("ᴘʟᴀʏ.ᴀᴛʟᴀsᴡᴏʀʟᴅ.ғʀ", NamedTextColor.GRAY),
                Component.text("                               ", TextColor.color(NamedTextColor.DARK_GRAY)).decorate(TextDecoration.STRIKETHROUGH)
        );
    }
}
