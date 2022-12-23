package ga.pixelplayz.customitem.miscellaneous;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        List<String> options = new ArrayList<>();
        List<String> playerNames = new ArrayList<>();
        List<String> emptyList = new ArrayList<>();
        Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
        Bukkit.getServer().getOnlinePlayers().toArray(players);
        if (args.length == 1) {
            options.add("help");
            options.add("reload");
            options.add("give");
            options.add("giveall");
            return options;
        }
        if (args.length == 2) {
            String subcommand = args[0];
            if(subcommand.equalsIgnoreCase("give")){
                for(int i = 0; i < players.length; i++){
                    playerNames.add(players[i].getName());
                }
                return playerNames;
            }
        }
        return emptyList;
    }
}
