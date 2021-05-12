package graphisme;

import java.awt.Color;

public class Parc implements Item{
	private static int cpt ;
	private int id;
	private String type;
	
	public Parc() {
		id = cpt;
		cpt ++;
		type = "parc";
	}
	
	public static int getNbParc() {
		return cpt;
	}
	
	public String toString() {
		return getStringID();
	}
	
	public String getStringID() {
		return String.format("%c%02d", type.charAt(0), id);
	}
	
	public Color getColor() {
		return Color.GREEN;
	}
	
}
