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
        for (String key : section.getKeys(false)) {
            chatComponents.add(new ReplaceComponent(section.getString(key + ".pattern"), section.getString(key + ".newtext"), section.getString(key + "permission")));
        }

        Bukkit.getLogger().info("=================================");
        Bukkit.getLogger().info("Loading ChatReplacer by ZaDiHo...");
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("Version :" + getDescription().getVersion());
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("All is good, have a good day !");
        Bukkit.getLogger().info("===========================");
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
        Bukkit.getLogger().info("=================================");
        Bukkit.getLogger().info("Disabling ChatReplacer by ZaDiHo...");
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("All is good ! See you soon ! :)");
        Bukkit.getLogger().info("=================================");
    }



}
