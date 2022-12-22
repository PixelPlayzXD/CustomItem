package ga.pixelplayz.customitem.miscellaneous;

import ga.pixelplayz.customitem.CustomItem;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemGenerator implements Listener {

    private final ga.pixelplayz.customitem.CustomItem CustomItem;

    public ItemGenerator(CustomItem CustomItem){
        this.CustomItem = CustomItem;
    }

    public ItemStack getSelector(Player player,String num){
        String itemnumber = "item".concat(num);
        String Item = CustomItem.getConfig().getString(itemnumber.concat(".Item"));
        Item = Item.toUpperCase();
        String ItemName = ChatColor.translateAlternateColorCodes('&',CustomItem.getConfig().getString(itemnumber.concat(".ItemName")));
        ItemName = PlaceholderAPI.setPlaceholders(player,ItemName);
        List<String> LoreList = new ArrayList<String>();
        LoreList = CustomItem.getConfig().getStringList(itemnumber.concat(".ItemLore"));
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
}
