package me.shawshark.lilygamesigns;

import org.bukkit.Location;

public class sendsign {
	
		public Location loc;
		public String user;
		public String line0;
		public String line1;
		public String line2;
		public String line3;
		public sendsign(String userins, Location locins,String line0ins, String line1ins, String line2ins, String line3ins){
		this.loc = locins;
		this.user = userins;
		this.line0 = line0ins;
		this.line1 = line1ins;
		this.line2 = line2ins;
		this.line3 = line3ins;
	}
}
