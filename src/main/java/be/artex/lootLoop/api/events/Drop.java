package be.artex.lootLoop.api.events;

import be.artex.lootLoop.api.Event;
import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public abstract class Drop extends Event {
    @Override
    public void event(BlockBreakEvent event) {
        Player player = event.getPlayer();

        Component itemName = Component.text("<null>");

        if (getItem().getStack().getItemMeta().hasCustomName())
            itemName = getItem().getStack().getItemMeta().customName();


        player.sendMessage(Component.text("ᴅʀᴏᴘ ʀᴀʀᴇ! ", NamedTextColor.BLUE).decorate(TextDecoration.BOLD).append(itemName).append(
            Component.text(" (" + getDropChance() + "%).", NamedTextColor.GOLD)));

        player.getInventory().addItem(getItem().getStack());
    }

    @Override
    public float getProbability() {
        return getDropChance();
    }

    public abstract @NotNull Item getItem();
    public abstract float getDropChance();
}
