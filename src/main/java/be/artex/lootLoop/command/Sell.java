package be.artex.lootLoop.command;

import be.artex.lootLoop.LootLoop;
import be.artex.lootLoop.Scoreboard;
import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sell implements CommandExecutor {
    public static Set<UUID> confirmation = Collections.synchronizedSet(new HashSet<>());

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player))
            return true;

        ItemStack stack = player.getInventory().getItemInMainHand();
        Item item = Item.getItemFromStack(stack);

        if (item == null || item.getSellValue() == 0) {
            player.sendMessage(Component.text("[", NamedTextColor.RED).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", NamedTextColor.RED).append(
                                    Component.text(" ᴛʜɪs ɪᴛᴇᴍ ɪs ɴᴏᴛ sᴇʟʟᴀʙʟᴇ.")))));
            return true;
        }

        String itemName = "<null>";
        long money = stack.getAmount() * item.getSellValue();

        if (stack.getItemMeta().hasCustomName()) {
            Component component = stack.getItemMeta().customName();
            itemName = PlainTextComponentSerializer.plainText().serialize(component);
        }

        if (isInConfirmation(player)) {
            sellLogic(player, money);

            player.sendMessage(Component.text("[", TextColor.color(255, 100, 0)).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", TextColor.color(255, 100, 0)).append(
                                    Component.text(" ʏᴏᴜ sᴏʟᴅ ", NamedTextColor.WHITE).append(
                                            Component.text(itemName, NamedTextColor.BLUE)).append(
                                                    Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                            Component.text(" ғᴏʀ ", NamedTextColor.WHITE).append(
                                                                    Component.text("$" + Scoreboard.format(money), TextColor.color(50, 210, 50)).append(
                                                                            Component.text(".")))))))));
        } else {
            player.sendMessage(Component.text("[", TextColor.color(255, 100, 0)).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", TextColor.color(255, 100, 0)).append(
                                    Component.text(" ʏᴏᴜ ᴀʀᴇ ᴀʙᴏᴜᴛ ᴛᴏ sᴇʟʟ ", NamedTextColor.WHITE).append(
                                            Component.text(itemName, NamedTextColor.BLUE)).append(
                                            Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                    Component.text(" ғᴏʀ ", NamedTextColor.WHITE).append(
                                                    Component.text("$" + Scoreboard.format(money), TextColor.color(50, 210, 50)).append(
                                                            Component.text(", ᴘʟᴇᴀsᴇ ʀᴇᴛʏᴘᴇ ᴛʜᴇ ᴄᴏᴍᴍᴀɴᴅ ᴛᴏ ᴄᴏɴғɪʀᴍ.", NamedTextColor.WHITE)))))))));

            addToConfirmation(player);
        }

        return true;
    }

    private static void sellLogic(Player player, long money) {
        player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
        Statistics.addLong(player, Statistics.MONEY, money);
        removeFromConfirmation(player);
    }

    private static void addToConfirmation(Player player) {
        UUID playerUUID = player.getUniqueId();

        confirmation.add(playerUUID);

        Bukkit.getScheduler().runTaskLater(LootLoop.getInstance(), () ->
                confirmation.remove(playerUUID), 5*20L);
    }

    private static void removeFromConfirmation(Player player) {
        confirmation.remove(player.getUniqueId());
    }

    private static boolean isInConfirmation(Player player) {
        return confirmation.contains(player.getUniqueId());
    }
}
