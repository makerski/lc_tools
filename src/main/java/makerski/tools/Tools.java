package makerski.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class Tools extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        loadConfig();
        getCommand("gm1").setExecutor(new creative());
        getCommand("gm2").setExecutor(new adventure());
        getCommand("gm3").setExecutor(new spectator());
        getCommand("gm0").setExecutor(new survival());
        getCommand("gamma").setExecutor(new gamma());
        getCommand("feed").setExecutor(new feed());
        getCommand("heal").setExecutor(new heal());
        getCommand("fly").setExecutor(new fly());
        getCommand("wb").setExecutor(new workbench());
        getCommand("bc").setExecutor(new broadcast());
        getCommand("ec").setExecutor(new enderchest());
        getCommand("repair").setExecutor(new repair());
        getCommand("kosz").setExecutor(new trash());
        getCommand("msg").setExecutor(new msg());
        Bukkit.getServer().getConsoleSender().sendMessage("Plugin na toolsy zostal wczytany");

    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }



    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("pomoc")) {
            Player player = (Player) sender;
            for (String pl : getConfig().getStringList("pomoc")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', pl));
            }


        }
        return false;


    }
}