package be.artex.lootLoop.api.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public enum ItemRarity {
    COMMON("ᴄᴏᴍᴍᴏɴ ɪᴛᴇᴍ", NamedTextColor.WHITE),
    UNCOMMON("ᴜɴᴄᴏᴍᴍᴏɴ ɪᴛᴇᴍ", NamedTextColor.GREEN),
    RARE("ʀᴀʀᴇ ɪᴛᴇᴍ", NamedTextColor.BLUE),
    EPIC("ᴇᴘɪᴄ ɪᴛᴇᴍ", NamedTextColor.DARK_PURPLE),
    LEGENDARY("ʟᴇɢᴇɴᴅᴀʀʏ ɪᴛᴇᴍ", NamedTextColor.GOLD),
    MYTHIC("ᴍʏᴛʜɪᴄ ɪᴛᴇᴍ", NamedTextColor.LIGHT_PURPLE);

    private final String text;
    private final Component displayText;
    private final NamedTextColor color;

    ItemRarity(String text, NamedTextColor color) {
        this.text = text;
        this.color = color;
        this.displayText = Component.text(this.text, this.color);
    }

    public Component getDisplayText() {
        return displayText;
    }

    public TextColor getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
