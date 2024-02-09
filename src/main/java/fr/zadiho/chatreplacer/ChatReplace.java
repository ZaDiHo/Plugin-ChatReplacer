package fr.zadiho.chatreplacer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class ChatReplace implements Listener {

    private fr.zadiho.chatreplacer.Main main;

    public ChatReplace(fr.zadiho.chatreplacer.Main main) {
        this.main = main;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        for(ReplaceComponent component: fr.zadiho.chatreplacer.Main.chatComponents) {
            if(component.canReplace(e.getPlayer())){
                 e.setMessage(component.replaceText(e.getMessage()));
            }
        }
    }

    @EventHandler
    public void onCommandSay(PlayerCommandPreprocessEvent e){
        for(ReplaceComponent component: fr.zadiho.chatreplacer.Main.chatComponents) {
            if(component.canReplace(e.getPlayer())){
                 e.setMessage(component.replaceText(e.getMessage()));
            }
        }
    }

    @EventHandler
    public void onConsoleSender(ServerCommandEvent e){
        e.setCancelled(true);
        String cmd = e.getCommand();
        for(ReplaceComponent component: fr.zadiho.chatreplacer.Main.chatComponents) {
            if(component.canReplace(e.getSender())){
                cmd = (component.replaceText(cmd));
            }
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
    }

}
