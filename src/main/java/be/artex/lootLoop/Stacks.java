package be.artex.lootLoop;

import be.artex.lootLoop.api.items.ItemRarity;
import be.artex.lootLoop.api.items.builders.ItemBuilder;
import be.artex.lootLoop.api.items.builders.ItemStackBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    public static final ItemStack BORDER = ItemStackBuilder.create(Material.BLACK_STAINED_GLASS_PANE)
            .name(" ")
            .build();

    public static final ItemStack COMBINE_ITEM = ItemStackBuilder.create(Material.ANVIL)
            .name(Component.text("ᴄᴏᴍʙɪɴᴇ ᴛʜᴇ ɪᴛᴇᴍs", NamedTextColor.YELLOW))
            .lore(Component.text("ᴄʟɪᴄᴋ ᴛᴏ ᴄᴏᴍʙɪɴᴇ ᴛʜᴇ ɪᴛᴇᴍs", NamedTextColor.GRAY))
            .build();

    public static final ItemStack NO_RESULT = ItemStackBuilder.create(Material.BARRIER)
            .name(Component.text("ɪᴛᴇᴍs ɴᴏᴛ ᴄᴏᴍʙɪɴᴀʙʟᴇs", NamedTextColor.RED))
            .lore(Component.text("ᴛʜᴇsᴇs ɪᴛᴇᴍs ᴄᴀɴ ɴᴏᴛ ʙᴇ ᴄᴏᴍʙɪɴᴇᴅ", NamedTextColor.GRAY))
            .build();

    public static final ItemStack STONE_CUBE = ItemBuilder.
            create(Material.COBBLESTONE, ItemRarity.COMMON)
            .name("sᴛᴏɴᴇ ᴄᴜʙᴇ")
            .description(Component.text("ᴀɴ ɪᴛᴇᴍ ɴᴏᴛ ᴡᴏʀᴛʜ ᴍᴜᴄʜ.   ", NamedTextColor.GRAY))
            .build();

    public static final ItemStack HARD_ROCK = ItemBuilder.
            create(Material.STONE, ItemRarity.UNCOMMON)
            .name("ʜᴀʀᴅ ʀᴏᴄᴋ")
            .description(Component.text("ᴀ ᴠᴇʀʏ ʜᴀʀᴅ, ʙᴜᴛ ᴀʟsᴏ ʜᴇᴀᴠʏ ʀᴏᴄᴋ.", NamedTextColor.GRAY))
            .build();

    public static final ItemStack FOSSIL = ItemBuilder.
            create(Material.BONE, ItemRarity.EPIC)
            .name("ғᴏssɪʟ")
            .description(Component.text(" ɪᴛ sᴀɪᴅ ᴛʜᴀᴛ ɪᴛ ᴄᴏᴍᴇs ғʀᴏᴍ ᴀ ᴠᴇʀʏ ᴏʟᴅ ᴄɪᴠɪsɪʟᴀᴛɪᴏɴ.   ", NamedTextColor.GRAY), Component.text("ɪᴛ ʜᴀs ᴀ ᴠᴇʀʏ ɢʀᴇᴀᴛ ᴠᴀʟᴜᴇ.", NamedTextColor.GRAY))
            .build();

    public static final ItemStack RECOMBOBULATOR = ItemBuilder.create(Material.EMERALD, ItemRarity.LEGENDARY)
            .name("ʀᴇᴄᴏᴍʙᴏʙᴜʟᴀᴛᴏʀ")
            .description(Component.text("ɪᴛ sᴀɪᴅ ᴛʜᴀᴛ ᴡʜᴇɴ ᴄᴏᴍʙɪɴᴇᴅ ᴡɪᴛʜ ᴀɴᴏᴛʜᴇʀ ɪᴛᴇᴍ, ᴛʜᴀᴛ ɪᴛᴇᴍ's ʀᴀʀɪᴛʏ ᴜᴘɢʀᴀᴅᴇs.     ", NamedTextColor.GRAY))
            .build();

    public static final ItemStack AMETHYST_GEODE = ItemBuilder.
            create(Material.AMETHYST_BLOCK, ItemRarity.UNCOMMON)
            .name("ᴀᴍᴇᴛʜʏsᴛ ɢᴇᴏᴅᴇ")
            .description(Component.text("ᴀ ɢᴇᴏᴅᴇ ʀᴀʀᴇʟʏ ғᴏᴜɴᴅ ғʀᴏᴍ ᴀᴍᴇᴛʜʏsᴛ.   ", NamedTextColor.GRAY))
            .build();

    public static final ItemStack AMETHYST_SHARD = ItemBuilder.
            create(Material.AMETHYST_SHARD, ItemRarity.COMMON)
            .name("ᴀᴍᴇᴛʜʏsᴛ sʜᴀʀᴅ")
            .build();

    public static final ItemStack IRON_NUGGET = ItemBuilder.create(Material.IRON_NUGGET, ItemRarity.COMMON)
            .name("ɪʀᴏɴ ɴᴜɢɢᴇᴛ")
            .build();

    public static final ItemStack GOLD_NUGGET = ItemBuilder.create(Material.GOLD_NUGGET, ItemRarity.UNCOMMON)
            .name("ɢᴏʟᴅ ɴᴜɢɢᴇᴛ")
            .build();

    public static final ItemStack DIAMOND_SHARD = ItemBuilder.create(Material.PRISMARINE_SHARD, ItemRarity.UNCOMMON)
            .name("ᴅɪᴀᴍᴏɴᴅ sʜᴀʀᴅ")
            .build();

}
