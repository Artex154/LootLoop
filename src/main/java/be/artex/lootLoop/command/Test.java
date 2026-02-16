package be.artex.lootLoop.command;

import be.artex.lootLoop.api.items.Item;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player))
            return true;

        if (args.length == 0)
            return true;

        if (!player.isOp())
            return true;

        Item item = Item.getItemFromId(args[0]);

        if (item != null)
            player.getInventory().addItem(item.getItemStack());

        return true;
    }
}
