package batiments;

import java.awt.Color;

public class Maison extends Habitation{
	/* Constructeur par defaut :
	 * la surface est initialisee aleatoirement
	 * avec une valeur comprise entre 20 et 120 (exclus) */
	public Maison() {
		// TODO Auto-generated constructor stub
		super("maison", (int)(Math.random()*100 + 20));
	}
	
	/* Redefinition de la methode getNbHab
	 * de la classe mere Habitation */
	@Override
	public int getNbHab() {
		return getSurface()/20;
	}
	
	@Override
	public Color getColor() {
		return Color.red;
	}
}
