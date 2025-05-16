package be.artex.lootLoop.api.items;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public enum ItemRarity {
    COMMON(Component.text("ᴏʙᴊᴇᴛ ᴄᴏᴍᴍᴜɴ", NamedTextColor.WHITE)),
    UNCOMMON(Component.text("ᴏʙᴊᴇᴛ ᴘᴇᴜ ᴄᴏᴍᴍᴜɴ", NamedTextColor.GREEN)),
    RARE(Component.text("ᴏʙᴊᴇᴛ ʀᴀʀᴇ", NamedTextColor.BLUE)),
    EPIC(Component.text("ᴏʙᴊᴇᴛ ᴇᴘɪǫᴜᴇ", NamedTextColor.DARK_PURPLE)),
    LEGENDARY(Component.text("ᴏʙᴊᴇᴛ ʟᴇɢᴇɴᴅᴀɪʀᴇ", NamedTextColor.GOLD)),
    MYTHIC(Component.text("ᴏʙᴊᴇᴛ ᴍʏᴛʜɪǫᴜᴇ", NamedTextColor.LIGHT_PURPLE));

    private final Component text;

    ItemRarity(Component text) {
        this.text = text;
    }

    public Component getText() {
        return text;
    }
}
