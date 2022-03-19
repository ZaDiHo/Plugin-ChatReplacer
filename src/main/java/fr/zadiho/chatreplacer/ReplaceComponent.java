package fr.zadiho.chatreplacer;

import org.bukkit.command.CommandSender;

public class ReplaceComponent {
    private String originaltext;
    private String newtext;
    private String permission;

    public ReplaceComponent(String text, String emoji, String permission) {
        this.originaltext = text;
        this.newtext = emoji;
        this.permission = permission;
    }
    public String replaceText(String original){
        if (originaltext == null || newtext == null) return original;
        return original.replaceAll(originaltext, newtext);
    }
    public boolean canReplace(CommandSender sender){
        return permission == null || sender.hasPermission(permission);
    }
}
