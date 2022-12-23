package ga.pixelplayz.customitem.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class helpCommand {
    public void onHelp(CommandSender sender){
        sender.sendMessage(ChatColor.GOLD+"customitem:\n   "+ChatColor.YELLOW+" help: "+ChatColor.WHITE+"display this menu\n    "+ChatColor.YELLOW+"give: "+ChatColor.WHITE+"give the items from config to a specific player\n    "+ChatColor.YELLOW+"giveall: "+ChatColor.WHITE+"give all players all items from the config\n    "+ChatColor.YELLOW+"reload: "+ChatColor.WHITE+"reload the plugin");
    }
}
