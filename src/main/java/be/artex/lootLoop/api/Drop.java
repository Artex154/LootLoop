package be.artex.lootLoop.api;

import be.artex.lootLoop.api.items.Item;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Drop {
    private final Item item;
    private final float probabilty;

    public Drop(Item item, float probability) {
        this.item = item;
        this.probabilty = probability;
    }

    public Item getItem() {
        return item;
    }

    public float getProbability() {
        return probabilty;
    }

    public void drop(@NotNull Player player, double fortuneMultiplier) {
        Component itemName = this.item.getItemStack().getItemMeta().hasCustomName()
                ? this.item.getItemStack().getItemMeta().customName()
                : Component.text("<null>");

        player.sendMessage(
                Component.text("ʀᴀʀᴇ ᴅʀᴏᴘ! ", NamedTextColor.BLUE)
                        .decorate(TextDecoration.BOLD)
                        .append(itemName)
                        .append(Component.text(" (" + this.probabilty + "%).", NamedTextColor.GOLD))
        );

        ItemStack stack = getItem().getItemStack();
        applyFortuneMultiplier(stack, fortuneMultiplier);

        player.getInventory().addItem(stack);
    }

    public static @Nullable Drop generateDrop(@NotNull Mineral mineral) {
        return generateDrop(mineral, new Random().nextFloat(100));
    }

    public static @Nullable Drop generateDrop(@NotNull Mineral mineral, float lootnum) {
        Drop drop = null;

        for (Drop d : mineral.getDrops()) {
            if (!(lootnum <= d.getProbability()))
                continue;

            if (drop == null || d.getProbability() < drop.getProbability())
                drop = d;
        }

        return drop;
    }

    protected void applyFortuneMultiplier(@NotNull ItemStack stack, double miningFortune) {
        miningFortune = miningFortune / 100;
        int integerPart = (int) miningFortune;
        double decimalPart = miningFortune - integerPart;

        Random random = new Random();
        float lootnum = random.nextFloat();

        if (decimalPart > lootnum)
            integerPart += 1;

        stack.setAmount(integerPart);
    }
}
