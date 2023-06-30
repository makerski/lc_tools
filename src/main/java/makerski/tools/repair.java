package makerski.tools;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class repair implements CommandExecutor {
    private final Tools plugin = Tools.getPlugin(Tools.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Komenda jest dostępna tylko dla graczy!");
            return true;
        }

        Player player = (Player) sender;
        ItemStack itemInHand = player.getItemInHand();

        if (player.hasPermission("repair.use")) {
            if (itemInHand == null) {
                player.sendTitle(ChatColor.translateAlternateColorCodes('&', ""), ChatColor.translateAlternateColorCodes('&', "&cTego przedmiotu nie da się naprawić!"));
                return true;
            }

            itemInHand.setDurability((short) 0);
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', ""), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("repair-sucess")));
            return true;

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
        }
        return false;
    }
}