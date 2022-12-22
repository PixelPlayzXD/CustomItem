package ga.pixelplayz.customitem.commands;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.commands.subcommands.giveallCommand;
import ga.pixelplayz.customitem.commands.subcommands.helpCommand;
import ga.pixelplayz.customitem.commands.subcommands.reloadCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PixelPlayz implements CommandExecutor {

    private final CustomItem CustomItem;
    reloadCommand obj1;
    giveallCommand obj2;
    helpCommand obj3;
    public PixelPlayz(ga.pixelplayz.customitem.CustomItem CustomItem){
        this.CustomItem = CustomItem;
        obj1 = new reloadCommand(CustomItem);
        obj2 = new giveallCommand(CustomItem);
        obj3 = new helpCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label, String[] args){
        if (args.length == 0) {
            obj3.onHelp(sender);
        } else if (args[0].equalsIgnoreCase("reload")) {
            obj1.onReload(sender);
        } else if (args[0].equalsIgnoreCase("giveall")) {
            obj2.onGiveAll();
            sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"All items have been given to all players");
        } else if (args[0].equalsIgnoreCase("help")) {
            obj3.onHelp(sender);
        }else {
            sender.sendMessage(ChatColor.YELLOW+"Usage:"+ChatColor.GREEN+" /pixelplayz"+ChatColor.RED+" <subcommand>");
        }
        return true;
    }
}
