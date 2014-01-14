package me.shawshark.lilygamesigns;

import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.RedirectRequest;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class listener implements Listener {
	
    public LilyGameSigns lgs;
    
	public listener(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	

	
	@EventHandler
	public void onsignPlace(SignChangeEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getState().getType() == Material.SIGN_POST || e.getBlock().getState().getType() == Material.WALL_SIGN){
				if(lgs.lilygamesigns.contains(p)) {
					lgs.signlist.add(new sendsign(e.getLine(1), e.getBlock().getLocation(),
							e.getLine(0), e.getLine(1), e.getLine(2), e.getLine(3)));
					p.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "LilyGameSigns" + ChatColor.GRAY + "] " + e.getLine(1) + " has been created!");
				
				}	
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		String ingameconfig = lgs.getConfig().getString("Messages.In-Game");
		String fullconfig = lgs.getConfig().getString("Messages.Full");
		String restartingconfig = lgs.getConfig().getString("Messages.Restarting");
		String Ingame = ChatColor.translateAlternateColorCodes('&', ingameconfig);
		String Full = ChatColor.translateAlternateColorCodes('&', fullconfig);
		String Restarting = ChatColor.translateAlternateColorCodes('&', restartingconfig);
	    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
	      for (sendsign ls : lgs.signlist) {
	        if (!ls.loc.equals(e.getClickedBlock().getLocation())) continue;
	        Sign s = (Sign) e.getClickedBlock().getState();
	        if(s.getLine(0).contains("[IN-GAME]") ){
	        	e.getPlayer().sendMessage(Ingame);
	        continue;
	        }else if(s.getLine(0).contains("[FULL]")) {
	        	e.getPlayer().sendMessage(Full);
	        	continue;
	        }else if(s.getLine(0).contains("RESTARTING")) {
	        	e.getPlayer().sendMessage(Restarting);
	        	continue;
	        }else if(s.getLine(0).contains("[OPEN]")) {
					try {
						lgs.connect.request(new RedirectRequest(s.getLine(1), e.getPlayer().getName()));
					} catch (IndexOutOfBoundsException | RequestException e1) {
						e1.printStackTrace();
					}
				break;
	        }
	      }	
	}
}
