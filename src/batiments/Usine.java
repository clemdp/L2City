package batiments;

import java.awt.Color;

public class Usine extends Batiments implements AEtage{
	/* Constructeur par defaut
	 * la surface d'une usine est initialisee
	 * aleatoirement entre 50 et 350 (exclus) */
	
	Color dark_green = new Color(0,100,0);
	
	public Usine() {
		// TODO Auto-generated constructor stub
		super("usine", (int)(Math.random()*300 + 50));
	}
	
	/* Redefition de la methode getPrix()
	 * de la classe mere Batiments */
	@Override
	public int getPrix() {
		return getSurface()*2000;
	}
	
	/* Redefition de la methode getNbEtages()
	 * de l'interface AEtage : par defaut
	 * une usine n'a que 3 etages. */
	@Override
	public int getNbEtages() {
		return 3;
	}
	
	@Override
	public Color getColor() {
		return Color.black;
	}
}
