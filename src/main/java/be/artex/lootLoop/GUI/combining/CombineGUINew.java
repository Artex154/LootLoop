package be.artex.lootLoop.GUI.combining;

import be.artex.lootLoop.Stacks;
import be.artex.lootLoop.api.items.Item;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.github.stefvanschie.inventoryframework.pane.util.Slot;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CombineGUINew {
    private static final ChestGui GUI = new ChestGui(5, "Combine Items");
    private static boolean isInventorySetUp = false;

    private static void setupInventory() {
        int[] borderSlots = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 12, 13, 14, 16, 17,
                18, 19, 20, 21, 23, 24, 25, 26,
                27, 28, 29, 30, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
        };

        StaticPane pane = new StaticPane(0, 0, 9, 5);

        GuiItem border = new GuiItem(Stacks.BORDER);
        border.setAction(event -> event.setCancelled(true));
        border.setVisible(true);

        GuiItem air = new GuiItem(new ItemStack(Material.AIR));

        GuiItem combine = new GuiItem(Stacks.COMBINE_ITEM);
        border.setAction(event -> {
            Item firstItem = Item.getItemFromStack(pane.getItem(Slot.fromIndex(11)).getItem());
            Item secondItem = Item.getItemFromStack(pane.getItem(Slot.fromIndex(15)).getItem());
            ItemStack result = Stacks.NO_RESULT;

            if (firstItem != null && secondItem != null)
                result = combine(firstItem, secondItem);

            GuiItem item = new GuiItem(result);
            pane.addItem(item, Slot.fromIndex(22));

            if (!result.isSimilar(Stacks.NO_RESULT)) {
                pane.addItem(air, Slot.fromIndex(11));
                pane.addItem(air, Slot.fromIndex(15));
            }
        });
        pane.addItem(combine, Slot.fromIndex(31));

        border.setVisible(true);

        for (int i : borderSlots)
            pane.addItem(border, Slot.fromIndex(i));

        pane.setVisible(true);
        GUI.addPane(pane);

        isInventorySetUp = true;
    }

    public static void openInventory(Player player) {
        if (!isInventorySetUp)
            setupInventory();

        GUI.show(player);
    }

    public static @NotNull ItemStack combine(Item firstItem, Item secondItem) {
        if (firstItem == null || secondItem == null)
            return Stacks.NO_RESULT;

        for (CombinePossibilty possibilty : CombinePossibilty.getCombinePossibilties()) {
            Item[] items = possibilty.getParams();

            Item fItem = items[0];
            Item sItem = items[1];

            if (fItem.equals(firstItem) && sItem.equals(secondItem))
                return possibilty.getResult().getItemStack();
        }

        return Stacks.NO_RESULT;
    }
}
