package ga.pixelplayz.customitem.miscellaneous;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabCompletion implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){

        if(args.length == 1){
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("give","giveall","help","reload","send"),new ArrayList<>());
        }
        if(args.length == 2){
            List<String> playerNames = new ArrayList<>();
            List<String> emptyList = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            String subcommand = args[0];
            if(subcommand.equalsIgnoreCase("give") || subcommand.equalsIgnoreCase("send") ){
                for(int i = 0; i < players.length; i++){
                    playerNames.add(players[i].getName());
                }
            }
            return StringUtil.copyPartialMatches(args[1], playerNames, new ArrayList<>());
        }
        return null;
    }
}
