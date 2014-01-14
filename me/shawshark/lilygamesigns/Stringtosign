package me.shawshark.lilygamesigns;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Stringtosign {

	
    public LilyGameSigns lgs;

	public Stringtosign(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	
	public sendsign stringToSign(String s) {
		String[] ssplit = s.split(",");
		String user = ssplit[0];
		World w = Bukkit.getWorld(ssplit[1]);
		int x = Integer.parseInt(ssplit[2]);
		int y = Integer.parseInt(ssplit[3]);
		int z = Integer.parseInt(ssplit[4]);
		String line0 = ssplit[5];
		String line1 = ssplit[6];
		String line2 = ssplit[7];
		String line3 = ssplit[8];
		Location loc = new Location(w, x, y, z);
		return new sendsign(user, loc, line0, line1, line2, line3);
	}
}
