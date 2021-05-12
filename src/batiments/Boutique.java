package batiments;

import java.awt.Color;

/**
 * Classe finale Boutique :
 * n'a pas vocation à avoir des classes filles
 * */

public class Boutique extends Commerce{
	/**/
	public Boutique() {
		// TODO Auto-generated constructor stub
		super("Boutique", (int)(Math.random()*50 + 50));
	}
	public int getPrix() {
		return 50*getSurface();
	}
	
	@Override
	public Color getColor() {
		return Color.cyan;
	}
}
