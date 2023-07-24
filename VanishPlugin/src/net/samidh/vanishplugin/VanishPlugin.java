package net.samidh.vanishplugin;

import net.samidh.vanishplugin.commands.CommandVanish;
import net.samidh.vanishplugin.listeners.OnJoin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class VanishPlugin extends JavaPlugin {

    public ArrayList<Player> list_of_vanish_players = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        System.out.println("[VanishPlugin] Vanish plugin is now enabled");
        getCommand("vanish").setExecutor(new CommandVanish(this));
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
    }
}
