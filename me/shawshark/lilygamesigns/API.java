package me.shawshark.lilygamesigns;

public class API {
	
    public LilyGameSigns lgs;
    
	public API(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	public void send(String status) {
        lgs.s.sendinfo(status);
	}
}
