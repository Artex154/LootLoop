package be.artex.lootLoop.GUI.combining;

import be.artex.lootLoop.api.items.Item;

import java.util.Collections;
import java.util.List;

public class CombinePossibilty {
    private static final List<CombinePossibilty> COMBINE_POSSIBILTIES = List.of();

    private final Item item1;
    private final Item item2;
    private final Item result;

    public CombinePossibilty(Item param1, Item param2, Item result) {
        this.item1 = param1;
        this.item2 = param2;
        this.result = result;
    }

    public Item getResult() {
        return result;
    }

    public Item[] getParams() {
        return new Item[]{item1, item2};
    }

    public static void registerPossibility(CombinePossibilty possibilty) {
        COMBINE_POSSIBILTIES.add(possibilty);
    }

    public static List<CombinePossibilty> getCombinePossibilties() {
        return Collections.unmodifiableList(COMBINE_POSSIBILTIES);
    }
}
