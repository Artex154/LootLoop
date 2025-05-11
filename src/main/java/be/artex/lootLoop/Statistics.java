package be.artex.lootLoop;

import be.artex.lootLoop.scoreboard.Scoreboard;
import fr.mrmicky.fastboard.adventure.FastBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Statistics {
    public static final NamespacedKey MINED_BLOCS = new NamespacedKey(LootLoop.instance, "lootloop/mined_blocks");
    public static final NamespacedKey MONEY = new NamespacedKey(LootLoop.instance, "lootloop/money");

    public static void addMoney(Player player, int money, FastBoard board) {
        PersistentDataContainer PDC = player.getPersistentDataContainer();

        int m = PDC.get(MONEY, PersistentDataType.INTEGER) + money;

        PDC.set(Statistics.MONEY, PersistentDataType.INTEGER, m);

        if (board != null)
            Scoreboard.updateBoard(board, player);
        else
            player.sendMessage(Component.text("[", NamedTextColor.DARK_GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.RED).append(
                            Component.text("]", NamedTextColor.DARK_GRAY).append(
                                    Component.text(" ᴠᴏᴜs ɴᴇ ᴘᴏsséᴅᴇᴢ ᴘᴀs ᴅᴇ sᴄᴏʀᴇʙᴏᴀʀᴅ, ᴅéᴄᴏɴɴɴᴇᴄᴛᴇᴢ ᴇᴛ ʀᴇᴄᴏɴɴᴇᴄᴛᴇᴢ ᴠᴏᴜs ᴘᴏᴜʀ ʟᴇ ʀᴇᴄᴇᴠᴏɪʀ.")))));
    }

    public static int playerHoursPlaytime(Player player) {
        return player.getStatistic(Statistic.TOTAL_WORLD_TIME) / (20 * 60 * 60);
    }
}
