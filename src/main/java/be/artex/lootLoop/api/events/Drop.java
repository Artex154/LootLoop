package be.artex.lootLoop.api.events;

import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public abstract class Drop extends Event {
    @Override
    public void event(@NotNull BlockBreakEvent event) {
        Player player = event.getPlayer();

        Component itemName = getItem().getStack().getItemMeta().hasCustomName()
                ? getItem().getStack().getItemMeta().customName()
                : Component.text("<null>");

        player.sendMessage(
                Component.text("ʀᴀʀᴇ ᴅʀᴏᴘ! ", NamedTextColor.BLUE)
                        .decorate(TextDecoration.BOLD)
                        .append(itemName)
                        .append(Component.text(" (" + getDropChance() + "%).", NamedTextColor.GOLD))
        );

        player.getInventory().addItem(getItem().getStack());
    }

    @Override
    public float getProbability() {
        return getDropChance();
    }

    public abstract @NotNull Item getItem();
    public abstract float getDropChance();
}
