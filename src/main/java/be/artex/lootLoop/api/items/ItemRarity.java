package be.artex.lootLoop.api.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public enum ItemRarity {
    COMMON("ᴏʙᴊᴇᴛ ᴄᴏᴍᴍᴜɴ", NamedTextColor.WHITE),
    UNCOMMON("ᴏʙᴊᴇᴛ ᴘᴇᴜ ᴄᴏᴍᴍᴜɴ", NamedTextColor.GREEN),
    RARE("ᴏʙᴊᴇᴛ ʀᴀʀᴇ", NamedTextColor.BLUE),
    EPIC("ᴏʙᴊᴇᴛ ᴇᴘɪǫᴜᴇ", NamedTextColor.DARK_PURPLE),
    LEGENDARY("ᴏʙᴊᴇᴛ ʟᴇɢᴇɴᴅᴀɪʀᴇ", NamedTextColor.GOLD),
    MYTHIC("ᴏʙᴊᴇᴛ ᴍʏᴛʜɪǫᴜᴇ", NamedTextColor.LIGHT_PURPLE);

    private final String text;
    private final TextColor color;

    ItemRarity(String text, TextColor color) {
        this.text = text;
        this.color = color;
    }

    public Component getText() {
        return Component.text(text, color);
    }

    public TextColor getColor() {
        return color;
    }
}
