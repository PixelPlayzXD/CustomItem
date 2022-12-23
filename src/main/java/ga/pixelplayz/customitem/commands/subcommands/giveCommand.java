package ga.pixelplayz.customitem.commands.subcommands;

import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class giveCommand implements Listener {

    private final ga.pixelplayz.customitem.CustomItem CustomItem;
    ItemGenerator obj;
    public giveCommand(ga.pixelplayz.customitem.CustomItem CustomItem){
        this.CustomItem = CustomItem;
        obj = new ItemGenerator(CustomItem);
    }

    public void onGive(Player player){
        String itemnumber;
        String num;
        for(int i = 1; i < 10; i++){
            num = Integer.toString(i);
            itemnumber = "item".concat(num);
            int slot = Integer.parseInt(CustomItem.getConfig().getString(itemnumber.concat(".SlotNumber")));
            slot = slot - 1;
            if(CustomItem.getConfig().getString(itemnumber.concat(".enabled")).equals("true")){
                if(CustomItem.getConfig().getString("world.enabled").equals("true")) {
                    World world = Bukkit.getWorld(CustomItem.getConfig().getString("world.name"));
                    if (player.getWorld().equals(world)) {
                        player.getInventory().setItem(slot, obj.getSelector(player, num));
                    }
                }else{
                    player.getInventory().setItem(slot, obj.getSelector(player, num));
                }
            }
        }
    }
}
