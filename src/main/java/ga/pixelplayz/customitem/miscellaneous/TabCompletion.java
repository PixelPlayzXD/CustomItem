package ga.pixelplayz.customitem.miscellaneous;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        List<String> options = new ArrayList<>();
        if (args.length == 1) {
            options.add("help");
            options.add("reload");
            options.add("giveall");
        }
        return options;
    }
}
