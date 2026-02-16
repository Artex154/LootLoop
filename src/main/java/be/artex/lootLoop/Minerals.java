package be.artex.lootLoop;

import be.artex.lootLoop.api.Mineral;
import be.artex.lootLoop.mineral.*;

public class Minerals {
    public static final Mineral STONE = Mineral.registerMineral(new Stone());
    public static final Mineral AMETHYST = Mineral.registerMineral(new Amethyst());
    public static final Mineral COAL = Mineral.registerMineral(new Coal());
    public static final Mineral IRON = Mineral.registerMineral(new Iron());
    public static final Mineral GOLD = Mineral.registerMineral(new Gold());
    public static final Mineral LAPIS = Mineral.registerMineral(new Lapis());
    public static final Mineral REDSTONE = Mineral.registerMineral(new Redstone());
    public static final Mineral DIAMOND = Mineral.registerMineral(new Diamond());
    public static final Mineral EMERALD = Mineral.registerMineral(new Emerald());

    public static void register() {
    }
}
