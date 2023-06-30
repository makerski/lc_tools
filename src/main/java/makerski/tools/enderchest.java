package makerski.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class enderchest implements CommandExecutor {
    private final Tools plugin = Tools.getPlugin(Tools.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("ec.use")) {
            player.openInventory(player.getEnderChest());
            player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', ""), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("enderchest-open-self")));

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
        }
        if(player.hasPermission("ec.admin")) {
            if(args.length == 1) {
                Player cel = Bukkit.getPlayerExact(args[0]);

                player.openInventory(cel.getEnderChest());
                player.sendTitle(ChatColor.translateAlternateColorCodes('&', ""), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("enderchest-open-player") + cel.getDisplayName()));
            } else {
                player.sendMessage(ChatColor.RED + "Poprawne użycie: /enderchest nick");
            }
        }
        return false;
    }
}