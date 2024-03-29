package de.cryt4x.invsync.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.cryt4x.invsync.main.Main;

public class InvLoadCommand implements CommandExecutor
{
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("ctpl2.invsave"))
			{
				if (args.length == 0)
				{
					Inventory playerInv = player.getInventory();
					FileConfiguration config = Main.getPlugin().getConfig();
					for (int i=0;i<41;i++)
					{
						playerInv.setItem(i, config.getItemStack(player.getName()+".inv."+i));
					}
					
					player.sendMessage("§6Inventory loaded!");
				}
				else
				{
					player.sendMessage("§cPls use §6/myinv$c!");
				}
			}
			else
			{
				player.sendMessage("§cYou don't have permission to do that!");
			}
		}
		else
		{
			sender.sendMessage("This command can only be executed by a player!");
		}
		return false;
	}
}
