package fr.zadiho.chatreplacer;

import org.bukkit.command.CommandSender;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ReplaceComponent {
    private Pattern pattern;
    private String newtext;
    private String permission;

    public ReplaceComponent(String pattern, String emoji, String permission) {
        this.pattern = Pattern.compile(pattern);
        this.newtext = emoji;
        this.permission = permission;
    }

    public String replaceText(String original) {
        if (pattern == null || newtext == null) return original;
        Matcher matcher = pattern.matcher(original);
        return matcher.replaceAll(newtext);
    }

    public boolean canReplace(CommandSender sender) {
        return permission == null || sender.hasPermission(permission);
    }
}
