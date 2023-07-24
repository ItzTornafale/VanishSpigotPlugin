package net.samidh.vanishplugin.commands;

import net.samidh.vanishplugin.VanishPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandVanish implements CommandExecutor {

    private VanishPlugin main;
    public CommandVanish(VanishPlugin vanishPlugin) {
        this.main = vanishPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(main.list_of_vanish_players.contains(p)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(p);
                }
                main.list_of_vanish_players.remove(p);
                p.sendMessage(main.getConfig().getString("Messages.onvanishenablemsg").replace("&", "§"));
            }else if(!main.list_of_vanish_players.contains(p)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(p);
                }
                main.list_of_vanish_players.add(p);
                p.sendMessage(main.getConfig().getString("Messages.onvanishdisablemsg").replace("&", "§"));

            }


        }


        return true;
    }
}
