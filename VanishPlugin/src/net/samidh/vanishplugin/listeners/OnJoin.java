package net.samidh.vanishplugin.listeners;

import net.samidh.vanishplugin.VanishPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    private VanishPlugin main;
    public OnJoin(VanishPlugin vanishPlugin) {
        this.main = vanishPlugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        for(int i = 0; i < main.list_of_vanish_players.size(); i++){
            p.hidePlayer(main.list_of_vanish_players.get(i));
        }

    }

}
