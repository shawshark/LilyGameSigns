package me.shawshark.lilygamesigns;

public class Signtostring {
	
	public LilyGameSigns lgs;

	public Signtostring(LilyGameSigns lgs) {
		this.lgs = lgs;
	}
	
	public String signToString(sendsign s) {
		String world = s.loc.getWorld().getName();
		String x = Integer.toString(s.loc.getBlockX());
		String y = Integer.toString(s.loc.getBlockY());
		String z = Integer.toString(s.loc.getBlockZ());
		if ((s.line0.equals("")) || (s.line0 == null))
			s.line0 = " ";
		if ((s.line1.equals("")) || (s.line1 == null))
			s.line1 = " ";
		if ((s.line2.equals("")) || (s.line2 == null))
			s.line2 = " ";
		if ((s.line3.equals("")) || (s.line3 == null))
			s.line3 = " ";
		return s.user + "," + world + "," + x + "," + y + "," + z + ","
				+ s.line0 + "," + s.line1 + "," + s.line2 + "," + s.line3;
	}
}
