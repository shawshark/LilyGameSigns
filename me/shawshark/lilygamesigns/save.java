package me.shawshark.lilygamesigns;

public class save {
	
    public LilyGameSigns lgs;
    
	public save(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	public void saveSigns() {
		for (sendsign s : lgs.signlist) {
			lgs.strsignslist.add(lgs.signts.signToString(s));
		}
		lgs.getConfig().set("sendsigns", lgs.strsignslist);
		lgs.saveConfig();
	}
}
