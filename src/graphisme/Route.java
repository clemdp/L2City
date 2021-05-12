package graphisme;

import java.awt.Color;

public class Route implements Item {
	private String type;
	private static int cpt;
	private int id;
	
	Color marronClair = new Color(240,200,70);
	
	public Route() {
		id = cpt;
		cpt ++;
		type = "route";
	}
	
	public static int getNbRoutes() {
		return cpt;
	}
	
	public String toString() {
		return getStringID();
	}
	
	public String getStringID() {
		return String.format("%c%02d", type.charAt(0), id);
	}
	
	public Color getColor() {
		return marronClair;
	}
	
	public int getPrix() {
		return 10;
	}
	
	public int getLoyer() {
		return 0;
	}
}
