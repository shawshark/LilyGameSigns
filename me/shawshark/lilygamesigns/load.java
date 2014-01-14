package me.shawshark.lilygamesigns;

import java.io.File;

public class load {

	
	
    public LilyGameSigns lgs;
    
    
	public load(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	
	public void loadConfig() {
		new File(lgs.getDataFolder(), "config.yml").exists();

		if (lgs.getConfig().contains("sendsigns"))
			for (String s : lgs.getConfig().getStringList("sendsigns"))
				lgs.signlist.add(lgs.sts.stringToSign(s));
	}
	
}
