package ga.pixelplayz.customitem;

import ga.pixelplayz.customitem.commands.CustomItemCommand;
import ga.pixelplayz.customitem.commands.subcommands.giveCommand;
import ga.pixelplayz.customitem.commands.subcommands.giveallCommand;
import ga.pixelplayz.customitem.commands.subcommands.reloadCommand;
import ga.pixelplayz.customitem.listeners.PlayerJoinListener;
import ga.pixelplayz.customitem.listeners.RightClickListener;
import ga.pixelplayz.customitem.miscellaneous.ItemGenerator;
import ga.pixelplayz.customitem.miscellaneous.TabCompletion;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItem extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        System.out.println("§fCustomItem >>> §aPlugin Has Been Enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new RightClickListener(this),this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this),this);
        Bukkit.getPluginManager().registerEvents(new ItemGenerator(this),this);
        Bukkit.getPluginManager().registerEvents(new reloadCommand(this),this);
        Bukkit.getPluginManager().registerEvents(new giveallCommand(this),this);
        Bukkit.getPluginManager().registerEvents(new giveCommand(this),this);
        getCommand("customitem").setExecutor(new CustomItemCommand(this));
        getCommand("customitem").setTabCompleter(new TabCompletion());
    }

    @Override
    public void onDisable() {
        System.out.println("§fCustomItem >>> §cPlugin Has Been Disabled");
    }
}
