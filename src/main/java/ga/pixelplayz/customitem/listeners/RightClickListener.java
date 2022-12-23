package ga.pixelplayz.customitem.listeners;

import ga.pixelplayz.customitem.CustomItem;
import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class RightClickListener implements Listener {

    private final HashMap<UUID, Long> cooldown;
    private final CustomItem CustomItem;
    ItemGenerator obj;

    public RightClickListener(CustomItem CustomItem){
        this.CustomItem = CustomItem;
        this.cooldown = new HashMap<>();
        obj = new ItemGenerator(CustomItem);
    }

    @EventHandler(priority= EventPriority.HIGH)
    public void onRightClick (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(CustomItem.getConfig().getString("commandCooldown.enabled").equals("true")){
            if(!cooldown.containsKey(player.getUniqueId())){
                cooldown.put(player.getUniqueId(),System.currentTimeMillis());
                runCommand(event);
            } else {
                long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                if(timeElapsed >= CustomItem.getConfig().getLong("commandCooldown.cooldown")){
                    cooldown.put(player.getUniqueId(),System.currentTimeMillis());
                    runCommand(event);
                }
            }
        } else {
            runCommand(event);
        }
    }
    public void runCommand (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item;
        String num;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            for (int i = 1;i < 10;i++){
                num = Integer.toString(i);
                if(CustomItem.getConfig().getString(("item".concat(num).concat(".enabled"))).equals("true")){
                    item = player.getInventory().getItemInHand();
                    if(item.equals(obj.getSelector(player, num))){
                        player.performCommand(CustomItem.getConfig().getString(("item".concat(num).concat(".Command"))));
                        break;
                    }
                }
            }
        }
    }
}