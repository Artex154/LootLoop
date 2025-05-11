package be.artex.lootLoop.commands;

import be.artex.lootLoop.LootLoop;
import be.artex.lootLoop.Statistics;
import be.artex.lootLoop.api.Item;
import be.artex.lootLoop.listeners.PlayerConnectionEvent;
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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Sell implements CommandExecutor {
    public static List<UUID> confirmation = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player))
            return true;

        ItemStack stack = player.getInventory().getItemInMainHand();
        Item item = Item.getItemFromStack(stack);

        if (item == null || item.getSellMoney() == 0) {
            player.sendMessage(Component.text("[", NamedTextColor.DARK_GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.RED).append(
                            Component.text("]", NamedTextColor.DARK_GRAY).append(
                                    Component.text(" ᴄᴇᴛ ɪᴛᴇᴍ ɴ'ᴇsᴛ ᴘᴀs ᴠᴇɴᴅᴀʙʟᴇ.")))));
            return true;
        }

        String itemName = "<null>";
        int moneyInt = stack.getAmount() * item.getSellMoney();

        String money = formatNumber(moneyInt);

        if (stack.getItemMeta().hasCustomName()) {
            Component component = stack.getItemMeta().customName();
            itemName = PlainTextComponentSerializer.plainText().serialize(component);
        }

        if (confirmation.contains(player.getUniqueId())) {
            player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));

            Statistics.addMoney(player, moneyInt, PlayerConnectionEvent.boards.get(player.getUniqueId()));
            confirmation.remove(player.getUniqueId());

            player.sendMessage(Component.text("[", NamedTextColor.GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.WHITE).append(
                            Component.text("]", NamedTextColor.GRAY).append(
                                    Component.text(" ᴠᴏᴜs ᴀᴠᴇᴢ ᴠᴇɴᴅᴜ ").append(
                                            Component.text(itemName)).append(
                                                    Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                            Component.text(" ᴘᴏᴜʀ ", NamedTextColor.GRAY)).append(
                                                                    Component.text("$" + money, TextColor.color(50, 210, 50)).append(
                                                                            Component.text(".", NamedTextColor.GRAY))))))));
        } else {
            player.sendMessage(Component.text("[", NamedTextColor.GRAY).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.WHITE).append(
                            Component.text("]", NamedTextColor.GRAY).append(
                                    Component.text(" ᴠᴏᴜs ᴀʟʟᴇᴢ ᴠᴇɴᴅʀᴇ ").append(
                                            Component.text(itemName)).append(
                                            Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                    Component.text(" ᴘᴏᴜʀ ", NamedTextColor.GRAY)).append(
                                                    Component.text("$" + money, TextColor.color(50, 210, 50)).append(
                                                            Component.text(", ᴍᴇʀᴄɪ ᴅᴇ ʀᴇᴛᴀᴘᴘᴇʀ ʟᴀ ᴄᴏᴍᴍᴀɴᴅᴇ ᴘᴏᴜʀ ᴄᴏɴғɪʀᴍᴇʀ ʟᴀ ᴠᴇɴᴛᴇ.", NamedTextColor.GRAY))))))));

            confirmation.add(player.getUniqueId());

            Bukkit.getScheduler().runTaskLater(LootLoop.instance, () ->
                    confirmation.remove(player.getUniqueId()), 5*20L);
        }

        return true;
    }

    public static String formatNumber(int number) {
        return String.format("%,d", number).replace(",", "'");
    }
}
