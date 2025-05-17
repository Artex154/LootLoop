package be.artex.lootLoop;

import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class Statistics {
    private static final Plugin MAIN = LootLoop.getInstance();

    public static final NamespacedKey MINED_BLOCS = new NamespacedKey(MAIN, "mined_blocks");
    public static final NamespacedKey MONEY = new NamespacedKey(MAIN, "money");

    public static int getInt(Player player, NamespacedKey key) {
        return player.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
    }

    public static int addInt(Player player, NamespacedKey key, int i) {
        PersistentDataContainer PDC = player.getPersistentDataContainer();

        int m = PDC.get(key, PersistentDataType.INTEGER) + i;

        PDC.set(key, PersistentDataType.INTEGER, m);

        return m;
    }

    public static int setInt(Player player, NamespacedKey key, int i) {
        player.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, i);

        return i;
    }

    public static int playerHoursPlaytime(Player player) {
        return player.getStatistic(Statistic.TOTAL_WORLD_TIME) / (20 * 60 * 60);
    }
}
