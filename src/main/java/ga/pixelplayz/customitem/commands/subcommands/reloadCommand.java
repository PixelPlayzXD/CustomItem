package ga.pixelplayz.customitem.commands.subcommands;

import ga.pixelplayz.customitem.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class reloadCommand implements Listener {

    private final CustomItem CustomItem;
    public reloadCommand(ga.pixelplayz.customitem.CustomItem CustomItem) {
        this.CustomItem = CustomItem;
    }

    public void onReload(CommandSender sender) {
        CustomItem.reloadConfig();
        sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"Config Reloaded");
    }
}