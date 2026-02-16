package be.artex.lootLoop;

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
        String minedBlocks = String.valueOf(playerPDC.get(Statistics.MINED_BLOCS, PersistentDataType.LONG));
        String money = String.valueOf(playerPDC.get(Statistics.MONEY, PersistentDataType.LONG));

        board.updateLines(
                Component.text("          ", TextColor.color(60, 60, 60)).decorate(TextDecoration.STRIKETHROUGH).append(
                        Component.text("           ", NamedTextColor.DARK_GRAY).decorate(TextDecoration.STRIKETHROUGH)).append(
                                Component.text("          ", TextColor.color(60, 60, 60)).decorate(TextDecoration.STRIKETHROUGH)),
                Component.text(player.getName() + ":", NamedTextColor.GRAY),
                Component.text(" ᴍᴏɴᴇʏ: ").append(
                                Component.text("$" + money, TextColor.color(50, 210, 50))),
                Component.text(" ᴘʟᴀʏᴛɪᴍᴇ: ").append(
                        Component.text(Statistics.playerHoursPlaytime(player) + " ʜᴏᴜʀs", NamedTextColor.BLUE)),
                Component.text(" ᴍɪɴᴇᴅ ʙʟᴏᴄᴋs: ").append(
                        Component.text(minedBlocks + " ʙʟᴏᴄᴋs", TextColor.color(255, 179, 67))),
                Component.text(" "),
                Component.text("ᴘʟᴀʏᴇʀ ᴄᴏᴜɴᴛ: ").append(
                        Component.text(Bukkit.getOnlinePlayers().size(), TextColor.color(235, 75, 6))),
                Component.text(" "),
                Component.text("ʟᴏᴏᴛʟᴏᴏᴘ.ᴍɪɴᴇʜᴜᴛ.ɢɢ", NamedTextColor.GRAY),
                Component.text("                               ", TextColor.color(NamedTextColor.DARK_GRAY)).decorate(TextDecoration.STRIKETHROUGH)
        );
    }
}
