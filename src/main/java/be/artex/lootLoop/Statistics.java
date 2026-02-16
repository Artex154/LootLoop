package be.artex.lootLoop;

import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class Statistics {
    private static final Plugin MAIN = LootLoop.getInstance();

    public static final NamespacedKey MINED_BLOCS = new NamespacedKey(MAIN, "mined_blocks");
    public static final NamespacedKey MONEY = new NamespacedKey(MAIN, "money");

    public static long getLong(Player player, NamespacedKey key) {
        return player.getPersistentDataContainer().get(key, PersistentDataType.LONG);
    }

    public static long setLong(Player player, NamespacedKey key, long i) {
        player.getPersistentDataContainer().set(key, PersistentDataType.LONG, i);

        return i;
    }

    public static long addLong(Player player, NamespacedKey key, long i) {
        long m = getLong(player, key) + i;

        setLong(player, key, m);

        return m;
    }

    public static long removeLong(Player player, NamespacedKey key, long i) {
        long m = getLong(player, key) - i;

        setLong(player, key, m);

        return m;
    }

    public static int playerHoursPlaytime(Player player) {
        return player.getStatistic(Statistic.TOTAL_WORLD_TIME) / (20 * 60 * 60);
    }
}
