package makerski.tools;

import jdk.javadoc.internal.tool.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class adventure implements CommandExecutor {
    private final Tools plugin = Tools.getPlugin(Tools.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player)sender;
        if(player.hasPermission("gm.adventure")) {
            player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            player.setGameMode(GameMode.ADVENTURE);
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', ""), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("gamemode-change")));

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
        }
        return false;
    }
}
