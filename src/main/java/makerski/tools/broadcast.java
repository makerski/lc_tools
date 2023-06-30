package makerski.tools;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class broadcast implements CommandExecutor {
    private final Tools plugin = Tools.getPlugin(Tools.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("bc.use")) {
            if(args.length >= 1) {
                StringBuilder sb = new StringBuilder();

                for(int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                String msg = sb.toString();

                if(args[0].equalsIgnoreCase("bc")) {
                    for(Player ps : Bukkit.getOnlinePlayers()) {
                        ps.sendMessage( plugin.getConfig().getString("alert-prefix" + msg.replace("&", "§")));
                    }
                } else if(args[0].equalsIgnoreCase("title")) {
                    for(Player ps: Bukkit.getOnlinePlayers()) {
                        ps.sendTitle("§c","" + msg.replace("&", "§"));
                    }

                } else if(args[0].equalsIgnoreCase("actionbar")) {
                    for(Player ps : Bukkit.getOnlinePlayers()) {
                        ps.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg.replace("&", "§")));
                    }

                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bc-use")));
                }

            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bc-use")));
            }

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
        }
        return false;
    }
}
