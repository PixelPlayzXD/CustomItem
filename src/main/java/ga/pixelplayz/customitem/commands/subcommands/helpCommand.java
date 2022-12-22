package ga.pixelplayz.customitem.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class helpCommand {
    public void onHelp(CommandSender sender){
        sender.sendMessage(ChatColor.GOLD+"pixelplayz:\n   "+ChatColor.YELLOW+" help: "+ChatColor.WHITE+"display this menu\n    "+ChatColor.YELLOW+"giveall: "+ChatColor.WHITE+"give all players the item from config\n    "+ChatColor.YELLOW+"reload: "+ChatColor.WHITE+"reload the plugin");
    }
}
