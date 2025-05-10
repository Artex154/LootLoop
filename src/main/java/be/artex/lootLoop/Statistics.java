package be.artex.lootLoop;

import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class Statistics {
    public static final NamespacedKey MINED_BLOCS = new NamespacedKey(LootLoop.instance, "lootloop/mined_blocks");

    public static int playerHoursPlaytime(Player player) {
        return player.getStatistic(Statistic.TOTAL_WORLD_TIME) / (20 * 60 * 60);
    }
}
