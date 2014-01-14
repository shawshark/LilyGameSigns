package me.shawshark.lilygamesigns;

import java.util.ArrayList;
import java.util.List;

import lilypad.client.connect.api.Connect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LilyGameSigns extends JavaPlugin {
	
	Connect connect;
	
	public List<sendsign> signlist = new ArrayList<sendsign>();
	public List<String> strsignslist = new ArrayList<String>();
	public List<Player> lilygamesigns = new ArrayList<Player>();
	
	public listener l = new listener(this);
	public send s = new send(this);
	public save save = new save(this);
	public load load = new load(this);
	public MessageListener ml = new MessageListener(this);
	public Stringtosign sts = new Stringtosign(this);
	public API api = new API(this);
	public Signtostring signts = new Signtostring(this);
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(new listener(this), this);
        connect = Bukkit.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
        connect.registerEvents(new MessageListener(this));
        saveConfig();
		load.loadConfig();
	}
	
	@Override
	public void onDisable() {
		save.saveSigns();
		saveConfig();
		connect.unregisterEvents(new MessageListener(this));
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {  
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Error: Commands can only be done in-game.");
		} else {
			 if(label.equalsIgnoreCase("lilygamesigns")) {
				 Player p = (Player)sender;
				 if(args.length < 1) {
					 p.sendMessage(ChatColor.GOLD + "-----[ Welcome to LilyGameSigns]-----");
					 p.sendMessage(ChatColor.GREEN + "/LilyGameSigns place - To enable saving of sign placment.");
				 } else {
					 if(args[0].equalsIgnoreCase("place")) {
						 if(p.hasPermission("lilygamesigns.place")) {
							 if(!lilygamesigns.contains(p)) {
								 lilygamesigns.add(p);
								 p.sendMessage(ChatColor.GREEN + "You may now place a game sign!");
							 } else {
								 lilygamesigns.remove(p);
								 p.sendMessage(ChatColor.GREEN + "Sign saving is disabled!");
							 }
						 } 
					 } 
				 }
			 } else if(cmd.getName().equalsIgnoreCase("debug")) {
				 if(sender.isOp()) {
					 api.send("open");
				 }
			 }
		}
		return false;
	}
}
