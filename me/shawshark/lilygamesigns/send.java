package me.shawshark.lilygamesigns;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;

import org.bukkit.Bukkit;

public class send {
	
    public LilyGameSigns lgs;
    
	public send(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
    public void sendinfo(String status) {
	 	
    	String serverusername = lgs.connect.getSettings().getUsername();
        String onlinecount = Bukkit.getOnlinePlayers().length + "";
        String maxusers = Bukkit.getMaxPlayers() + "";
        
        try {
        	MessageRequest request = new 
        			MessageRequest(Collections.<String> emptyList(), "LilyGameSigns",
        					serverusername 
        					+ ",," + 
        					onlinecount
        					+ ",," + 
        					maxusers 
        					+ ",," + 
        					status);
              lgs.connect.request(request); 
              } catch (UnsupportedEncodingException | RequestException e){e.printStackTrace();
        } 
	}

}
