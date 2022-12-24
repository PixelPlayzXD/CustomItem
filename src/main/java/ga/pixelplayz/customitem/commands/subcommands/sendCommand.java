package ga.pixelplayz.customitem.commands.subcommands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sendCommand {
    public void onSend(String[] args, CommandSender sender){
        Player player = Bukkit.getServer().getPlayer(args[1]);
        if (player == null) {
            sender.sendMessage(ChatColor.WHITE+""+ChatColor.BOLD+"CustomItem >>> "+ChatColor.RED+"Player not found.");
        } else {
            StringBuilder messageBuilder = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                messageBuilder.append(args[i]).append(" ");
            }
            String message = messageBuilder.toString().trim();
            message = ChatColor.translateAlternateColorCodes('&',message);
            message = PlaceholderAPI.setPlaceholders(player,message);
            player.sendMessage(message);
        }
    }
}
