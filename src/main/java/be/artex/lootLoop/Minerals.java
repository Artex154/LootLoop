package be.artex.lootLoop;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.mineral.Amethyst;
import be.artex.lootLoop.mineral.Stone;

public class Minerals {
    public static final Mineral STONE = Mineral.registerMineral(new Stone());
    public static final Mineral AMETHYST = Mineral.registerMineral(new Amethyst());

    public static void register() {
    }
}
