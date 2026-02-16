package be.artex.lootLoop.command;

import be.artex.lootLoop.LootLoop;
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

        if (item == null || item.getSellMoney() == 0) {
            player.sendMessage(Component.text("[", NamedTextColor.RED).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", NamedTextColor.RED).append(
                                    Component.text(" ᴛʜɪs ɪᴛᴇᴍ ɪs ɴᴏᴛ sᴇʟʟᴀʙʟᴇ.")))));
            return true;
        }

        String itemName = "<null>";
        long money = stack.getAmount() * item.getSellMoney();

        if (stack.getItemMeta().hasCustomName()) {
            Component component = stack.getItemMeta().customName();
            itemName = PlainTextComponentSerializer.plainText().serialize(component);
        }

        if (confirmation.contains(player.getUniqueId())) {
            player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));

            Statistics.addLong(player, Statistics.MONEY, money);
            confirmation.remove(player.getUniqueId());

            player.sendMessage(Component.text("[", TextColor.color(255, 100, 0)).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", TextColor.color(255, 100, 0)).append(
                                    Component.text(" ʏᴏᴜ sᴏʟᴅ ", NamedTextColor.WHITE).append(
                                            Component.text(itemName, NamedTextColor.BLUE)).append(
                                                    Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                            Component.text(" ғᴏʀ ", NamedTextColor.WHITE).append(
                                                                    Component.text("$" + money, TextColor.color(50, 210, 50)).append(
                                                                            Component.text(".")))))))));
        } else {
            player.sendMessage(Component.text("[", TextColor.color(255, 100, 0)).append(
                    Component.text("ʟᴏᴏᴛʟᴏᴏᴘ", NamedTextColor.GOLD).append(
                            Component.text("]", TextColor.color(255, 100, 0)).append(
                                    Component.text(" ʏᴏᴜ ᴀʀᴇ ᴀʙᴏᴜᴛ ᴛᴏ sᴇʟʟ ", NamedTextColor.WHITE).append(
                                            Component.text(itemName, NamedTextColor.BLUE)).append(
                                            Component.text(" x" + stack.getAmount(), NamedTextColor.BLUE).append(
                                                    Component.text(" ғᴏʀ ", NamedTextColor.WHITE).append(
                                                    Component.text("$" + money, TextColor.color(50, 210, 50)).append(
                                                            Component.text(", ᴘʟᴇᴀsᴇ ʀᴇᴛʏᴘᴇ ᴛʜᴇ ᴄᴏᴍᴍᴀɴᴅ ᴛᴏ ᴄᴏɴғɪʀᴍ.", NamedTextColor.WHITE)))))))));

            confirmation.add(player.getUniqueId());

            Bukkit.getScheduler().runTaskLater(LootLoop.getInstance(), () ->
                    confirmation.remove(player.getUniqueId()), 5*20L);
        }

        return true;
    }
}
