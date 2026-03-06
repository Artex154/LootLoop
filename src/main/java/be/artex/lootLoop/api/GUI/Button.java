package be.artex.lootLoop.api.GUI;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Button {
    public abstract ItemStack getStack();
    public abstract int getButtonIndex();

    public void onClick(Inventory inventory, Player player) {
    }

}
