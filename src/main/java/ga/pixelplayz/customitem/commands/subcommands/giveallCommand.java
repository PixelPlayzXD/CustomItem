package ga.pixelplayz.customitem.commands.subcommands;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class giveallCommand implements Listener {

    private final ga.pixelplayz.customitem.CustomItem CustomItem;
    ItemGenerator obj;
    public giveallCommand(ga.pixelplayz.customitem.CustomItem CustomItem){
        this.CustomItem = CustomItem;
        obj = new ItemGenerator(CustomItem);
    }

    public void onGiveAll(){
        World world = Bukkit.getWorld(CustomItem.getConfig().getString("world.name"));
        String num;
        int slot;
        for(int i = 1;i < 10;i++){
            num = Integer.toString(i);
            String itemnumber = "item".concat(num);
            slot = Integer.parseInt(CustomItem.getConfig().getString(itemnumber.concat(".SlotNumber")));
            slot = slot - 1;
            if(CustomItem.getConfig().getString(itemnumber.concat(".enabled")).equals("true")){
                if(CustomItem.getConfig().getString("world.enabled").equals("true")) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        giveAllPlayerItemInAWorld(player, world, obj.getSelector(player, num), slot, num);
                    }
                }else{
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        giveAllPlayerItem(player, obj.getSelector(player, num), slot, num);
                    }
                }
            }
        }
    }
    public void giveAllPlayerItemInAWorld(Player player, World world, ItemStack item, int slot, String num) {
        if (player.getWorld().equals(world)) {
            player.getInventory().setItem(slot, obj.getSelector(player, num));
        }
    }

    public void giveAllPlayerItem(Player player, ItemStack item, int slot, String num) {
        player.getInventory().setItem(slot, obj.getSelector(player, num));
    }
}
