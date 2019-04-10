package de.cryt4x.invsync.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.cryt4x.invsync.commands.InvLoadCommand;
import de.cryt4x.invsync.commands.InvSaveCommand;
import de.cryt4x.invsync.commands.InvSyncInfoCommand;

public class Main extends JavaPlugin
{
	private static Main plugin;
	public void onEnable ()
	{
		plugin = this;
		
		//Server-Console Output
		System.out.println("[InvSync] Third Plugin of CryT4x (ctpl3) loaded!");
		
		//Plugin-Info
		getCommand("invsyncinfo").setExecutor(new InvSyncInfoCommand());
		
		//Commands
		getCommand("invsave").setExecutor(new InvSaveCommand());
		getCommand("invload").setExecutor(new InvLoadCommand());
		
		//Listeners
		//PluginManager pluginManager = Bukkit.getPluginManager();
		//pluginManager.registerEvents(new <ListenerName()>, this);
	}
	public static Main getPlugin() {
		return plugin;
	}
}
