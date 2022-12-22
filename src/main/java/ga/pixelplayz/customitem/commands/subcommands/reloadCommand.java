package ga.pixelplayz.customitem.commands.subcommands;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class reloadCommand implements Listener {

    private final CustomItem CustomItem;
    ItemGenerator obj1;
    giveallCommand obj2;

    public reloadCommand(ga.pixelplayz.customitem.CustomItem CustomItem) {
        this.CustomItem = CustomItem;
        obj1 = new ItemGenerator(CustomItem);
        obj2 = new giveallCommand(CustomItem);
    }

    public void onReload(CommandSender sender) {
        CustomItem.reloadConfig();
        sender.sendMessage(ChatColor.WHITE+""+ ChatColor.BOLD+"CustomItem >>> "+ChatColor.GREEN+"Config Reloaded");
        obj2.onGiveAll();
    }
}