package fr.zadiho.chatreplacer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class Main extends JavaPlugin {

    public static Set<ReplaceComponent> chatComponents = new HashSet<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigurationSection section = getConfig().getConfigurationSection("texts");
        for(String key : section.getKeys(false)){
            chatComponents.add(new ReplaceComponent(section.getString(key + ".originaltext"), section.getString(key + ".newtext"), section.getString(key + "permission")));
        }
        
        Bukkit.getServer().getConsoleSender().sendMessage( "\n" +ChatColor.DARK_GRAY + "---------------------------\n" + ChatColor.GOLD + "Chat Replacer vient de démarrer.\n" + ChatColor.DARK_GRAY + "---------------------------");
        registerListeners();
        registerCommands();
    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatReplace(this), this);
    }

    private void registerCommands(){
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage( "\n" +ChatColor.DARK_GRAY + "---------------------------\n" + ChatColor.GOLD + "Chat Replacer vient de s'éteindre.\n" + ChatColor.DARK_GRAY + "---------------------------");
    }



}
