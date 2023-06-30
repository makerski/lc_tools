package makerski.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class trash implements CommandExecutor {
    private final Tools plugin = Tools.getPlugin(Tools.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Komenda jest dostępna tylko dla graczy!");
            return true;
        }

        Player player = (Player) sender;
        Inventory trashInventory = Bukkit.createInventory(null, 54, "Śmietnik");

        for(ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {

            }
        }

        player.openInventory(trashInventory);
        return true;

    }
}
