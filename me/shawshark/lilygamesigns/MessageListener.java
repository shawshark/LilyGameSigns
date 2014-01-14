package me.shawshark.lilygamesigns;

import java.io.UnsupportedEncodingException;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;

public class MessageListener {

	Connect connect;
	
    public LilyGameSigns lgs;
    
	public MessageListener(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	
    @EventListener
    public void onMessage(MessageEvent event) {
    				String[] data = null;
    				
    		if(event.getChannel().equalsIgnoreCase("LilyGameSigns")) {
                    try { data = event.getMessageAsString().split(",,"); } 
                    catch (UnsupportedEncodingException e) { e.printStackTrace();
                    return; 
                    }
                    String serverusername = data[0];
                    String onlineusers = data[1];
                    String maxusers = data[2];
                    String status = data[3];

                    for (sendsign s: lgs.signlist){
    					if(serverusername.equalsIgnoreCase(s.user)){
    						Sign sign = (Sign) s.loc.getBlock().getState();
    						if(status.equalsIgnoreCase("ingame")) {
    							sign.setLine(0, ChatColor.GOLD + "" + ChatColor.BOLD +   "[IN-GAME]");
    						s.line0 = "[IN-GAME]";
    						
    						
    						}else if(status.equalsIgnoreCase("full")){
    							sign.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD +   "[FULL]");
    							s.line0 = "[FULL]";
    							
    							
    						}else if(status.equalsIgnoreCase("restarting")) {
    							sign.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD +   "RESTARTING");
    							s.line0 = "[RESTARTING]";
    							
    						}else if(status.equalsIgnoreCase("open")){
    							sign.setLine(0, ChatColor.GREEN + "" + ChatColor.BOLD +   "[OPEN]");
    							s.line0 = "[OPEN]";
    							
    						}
    						sign.setLine(3, onlineusers + " / " + maxusers);
    						sign.update();
    					}
    				}     
            }
    }
	
	
	
}
