package ga.pixelplayz.customitem;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomItem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("§fCustomItem >>> §aPlugin Has Been Loaded");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }


    @EventHandler(priority= EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(this.getConfig().getString("item1.enabled").equals("true")){
            String TheCommand1 = this.getConfig().getString("item1.Command");
            String NameOfItem1 = this.getConfig().getString("item1.Item");
            NameOfItem1 = NameOfItem1.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem1)) {
                player.performCommand(TheCommand1);
            }
        }
        if(this.getConfig().getString("item2.enabled").equals("true")){
            String TheCommand2 = this.getConfig().getString("item2.Command");
            String NameOfItem2 = this.getConfig().getString("item2.Item");
            NameOfItem2 = NameOfItem2.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem2)) {
                player.performCommand(TheCommand2);
            }
        }
        if(this.getConfig().getString("item3.enabled").equals("true")){
            String TheCommand3 = this.getConfig().getString("item3.Command");
            String NameOfItem3 = this.getConfig().getString("item3.Item");
            NameOfItem3 = NameOfItem3.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem3)) {
                player.performCommand(TheCommand3);
            }
        }
        if(this.getConfig().getString("item4.enabled").equals("true")){
            String TheCommand4 = this.getConfig().getString("item4.Command");
            String NameOfItem4 = this.getConfig().getString("item4.Item");
            NameOfItem4 = NameOfItem4.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem4)) {
                player.performCommand(TheCommand4);
            }
        }
        if(this.getConfig().getString("item5.enabled").equals("true")){
            String TheCommand5 = this.getConfig().getString("item5.Command");
            String NameOfItem5 = this.getConfig().getString("item5.Item");
            NameOfItem5 = NameOfItem5.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem5)) {
                player.performCommand(TheCommand5);
            }
        }
        if(this.getConfig().getString("item6.enabled").equals("true")){
            String TheCommand6 = this.getConfig().getString("item6.Command");
            String NameOfItem6 = this.getConfig().getString("item6.Item");
            NameOfItem6 = NameOfItem6.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem6)) {
                player.performCommand(TheCommand6);
            }
        }
        if(this.getConfig().getString("item7.enabled").equals("true")){
            String TheCommand7 = this.getConfig().getString("item7.Command");
            String NameOfItem7 = this.getConfig().getString("item7.Item");
            NameOfItem7 = NameOfItem7.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem7)) {
                player.performCommand(TheCommand7);
            }
        }
        if(this.getConfig().getString("item8.enabled").equals("true")){
            String TheCommand8 = this.getConfig().getString("item8.Command");
            String NameOfItem8 = this.getConfig().getString("item8.Item");
            NameOfItem8 = NameOfItem8.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem8)) {
                player.performCommand(TheCommand8);
            }
        }
        if(this.getConfig().getString("item9.enabled").equals("true")){
            String TheCommand9 = this.getConfig().getString("item9.Command");
            String NameOfItem9 = this.getConfig().getString("item9.Item");
            NameOfItem9 = NameOfItem9.toUpperCase();
            if(player.getInventory().getItemInHand().getType() == Material.valueOf(NameOfItem9)) {
                player.performCommand(TheCommand9);
            }
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,String[] args){
        if (command.getName().equals("customitemreload")) {
            reloadConfig();
            sender.sendMessage("§f§lCustomItem >>> §aConfig Reloaded");
        }
        return true;
    }

    public ItemStack getSelector(PlayerJoinEvent event,String num){
        Player player = event.getPlayer();
        String itemnumber = "item".concat(num);
        String Item = this.getConfig().getString(itemnumber.concat(".Item"));
        Item = Item.toUpperCase();
        String ItemName = ChatColor.translateAlternateColorCodes('&',this.getConfig().getString(itemnumber.concat(".ItemName")));
        ItemName = PlaceholderAPI.setPlaceholders(player,ItemName);
        List<String> LoreList = new ArrayList<String>();
        LoreList = this.getConfig().getStringList(itemnumber.concat(".ItemLore"));
        for(int i=0;i<LoreList.size();i++){
            LoreList.set(i,ChatColor.translateAlternateColorCodes('&',LoreList.get(i)));
        }
        LoreList = PlaceholderAPI.setPlaceholders(player,LoreList);
        ItemStack ServerSelector = new ItemStack(Material.valueOf(Item));
        ItemMeta ServerSelectorMeta = ServerSelector.getItemMeta();
        ServerSelectorMeta.setDisplayName(ItemName);
        ServerSelectorMeta.setLore(LoreList);
        ServerSelector.setItemMeta(ServerSelectorMeta);
        return ServerSelector;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(this.getConfig().getString("world.enabled").equals("true")) {
            String worldname = this.getConfig().getString("world.name");
            if(player.getPlayer().getWorld().getName().equals(worldname)) {
                if(this.getConfig().getString("item1.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item1.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"1"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item2.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item2.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"2"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item3.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item3.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"3"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item4.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item4.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"4"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item5.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item5.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"5"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item6.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item6.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"6"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item7.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item7.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"7"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item8.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item8.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"8"));
                        }
                    }, 20);
                }
                if(this.getConfig().getString("item9.enabled").equals("true")){
                    int SlotNumber = this.getConfig().getInt("item9.SlotNumber");
                    int NewSlotNumber = SlotNumber-1;
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                        public void run(){
                            e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"9"));
                        }
                    }, 20);
                }
            }
        }else{
            if(this.getConfig().getString("item1.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item1.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"1"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item2.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item2.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"2"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item3.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item3.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"3"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item4.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item4.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"4"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item5.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item5.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"5"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item6.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item6.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"6"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item7.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item7.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"7"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item8.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item8.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"8"));
                    }
                }, 20);
            }
            if(this.getConfig().getString("item9.enabled").equals("true")){
                int SlotNumber = this.getConfig().getInt("item9.SlotNumber");
                int NewSlotNumber = SlotNumber-1;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    public void run(){
                        e.getPlayer().getInventory().setItem(NewSlotNumber, getSelector(e,"9"));
                    }
                }, 20);
            }
        }
    }

    @Override
    public void onDisable() {
        System.out.println("§fCustomItem >>> §cPlugin Has Been Disabled");
    }
}
