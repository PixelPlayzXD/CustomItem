package ga.pixelplayz.customitem.commands;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.commands.subcommands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomItemCommand implements CommandExecutor {

    private final CustomItem CustomItem;
    reloadCommand obj1;
    giveallCommand obj2;
    helpCommand obj3;
    giveCommand obj4;
    sendCommand obj5;
    public CustomItemCommand(ga.pixelplayz.customitem.CustomItem CustomItem){
        this.CustomItem = CustomItem;
        obj1 = new reloadCommand(CustomItem);
        obj2 = new giveallCommand(CustomItem);
        obj3 = new helpCommand();
        obj4 = new giveCommand(CustomItem);
        obj5 = new sendCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label, String[] args){
        if(sender instanceof Player){
            isPlayer(args, sender);
        } else {
            notPlayer(args, sender);
        }
        return true;
    }


    public void isPlayer (String[] args, CommandSender sender){
        Player player = (Player)sender;
        String playerName = player.getName();
        if (args.length == 0) {
            if(player.hasPermission("customitem")){
                obj3.onHelp(sender);
            }
        } else if (args[0].equalsIgnoreCase("reload")) {
            if(player.hasPermission("customitem.reload")){
                obj1.onReload(sender);
            }
        } else if (args[0].equalsIgnoreCase("giveall")) {
            if(player.hasPermission("customitem.giveall")){
                obj2.onGiveAll();
                sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"All items have been given to all players");
            }
        } else if (args[0].equalsIgnoreCase("help")) {
            if(player.hasPermission("customitem")){
                obj3.onHelp(sender);
            }
        } else if (args[0].equalsIgnoreCase("give")) {
            if(player.hasPermission("customitem.give")){
                obj4.onGive(player);
                sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"Given items from config to "+ChatColor.GREEN+playerName);
            }
        } else if (args[0].equalsIgnoreCase("send")) {
            if(args.length < 2){
                sender.sendMessage(ChatColor.GOLD+"Usage: "+ChatColor.YELLOW+"/customitem send <player> <message>");
            } else if (player.hasPermission("customitem.send")){
                obj5.onSend(args, sender);
            }
        } else {
            sender.sendMessage(ChatColor.GOLD+"Usage"+ChatColor.WHITE+":"+ChatColor.YELLOW+" /customitem <subcommand>");
        }
    }




    public void notPlayer(String[] args, CommandSender sender){
        if(args.length == 0){
            obj3.onHelp(sender);
        } else if (args[0].equalsIgnoreCase("reload")) {
            obj1.onReload(sender);
        } else if (args[0].equalsIgnoreCase("giveall")) {
            obj2.onGiveAll();
            sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"All items have been given to all players");
        } else if (args[0].equalsIgnoreCase("give")) {
            obj4.onGive(Bukkit.getPlayer(args[1]));
            sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"Given items from config to "+ChatColor.GREEN+args[1]);
        } else if (args[0].equalsIgnoreCase("help")) {
            obj3.onHelp(sender);
        } else if (args[0].equalsIgnoreCase("send")) {
            if(args.length < 2){
                sender.sendMessage(ChatColor.GOLD+"Usage: "+ChatColor.YELLOW+"/customitem send <player> <message>");
            } else {
                obj5.onSend(args, sender);
            }
        } else {
            sender.sendMessage(ChatColor.GOLD+"Usage"+ChatColor.WHITE+":"+ChatColor.YELLOW+" /customitem <subcommand>");
        }
    }
}
