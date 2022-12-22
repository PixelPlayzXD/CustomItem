package ga.pixelplayz.customitem.listeners;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final ga.pixelplayz.customitem.CustomItem CustomItem;
    ItemGenerator obj;
    public PlayerJoinListener(CustomItem CustomItem){
        this.CustomItem = CustomItem;
        obj = new ItemGenerator(CustomItem);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(CustomItem.getConfig().getString("world.enabled").equals("true")) {
            String worldname = CustomItem.getConfig().getString("world.name");
            if(player.getWorld().getName().equals(worldname)) {
                GiveItemToPlayer(player);
            }
        }else{
            GiveItemToPlayer(player);
        }
    }

    public void GiveItemToPlayer (Player player) {
        String num;
        for(int i = 1;i < 10;i++) {
            num = Integer.toString(i);
            String itemnumber = "item".concat(num);
            if (CustomItem.getConfig().getString(itemnumber.concat(".enabled")).equals("true")) {
                int SlotNumber = CustomItem.getConfig().getInt(itemnumber.concat(".SlotNumber"));
                int NewSlotNumber = SlotNumber - 1;
                final String newnum = num;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CustomItem, new Runnable() {
                    public void run() {
                        player.getInventory().setItem(NewSlotNumber, obj.getSelector(player, newnum));
                    }
                }, 20);
            }
        }
    }


}
