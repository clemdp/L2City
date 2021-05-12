package batiments;

import java.awt.Color;

public class Immeuble extends Habitation implements AEtage{
	public final static int MAX_ETAGES = 10;
	private int nbEtages;
	
	Color rougefonce = new Color(100,0,0);
	/* Constructeur par defaut : 
	 * la surface d'un immeuble est toujours de 100
	 * le nb d'etages est definie aleatoirement avec
	 * un nombre max de 10 */
	public Immeuble() {
		// TODO Auto-generated constructor stub
		super("immeuble", 200);
		nbEtages = (int)(Math.random()*MAX_ETAGES);
	}
	
	/* Redefinition de la methode de l'interface AEtage */
	@Override
	public int getNbEtages(){
		return nbEtages;
	}
	
	/* Redefinition de la methode getNbHab() de la classe
	 * mere Habitation */
	@Override
	public int getNbHab() {
		return (nbEtages * getSurface())/30;
	}
	
	@Override
	public Color getColor() {
		return rougefonce;
	}
}
