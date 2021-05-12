package batiments;

import java.awt.Color;

public class CentreCommercial extends Commerce implements AEtage{
	private final static int NBMAXBOUTIQUES = 300;
	private int nbBoutiques;
	/* Constructeur par defaut, qui utilise le constructeur mere
	 * initialise le nombre de boutiques de maniere aleatoire
	 * initialise la surface en fonction du nombre de boutiques */
	public CentreCommercial() {
		super("Centre Commercial", ((int)(Math.random()*50 +50)));		// TODO Auto-generated constructor stub
		nbBoutiques = (int)(Math.random()*NBMAXBOUTIQUES);
		this.setSurface(nbBoutiques*((int)(Math.random()*50 + 50)));
	}
	
	/* Getteur sur le prix : obligatoire car abstraite dans
	 * la classe mere */
	public int getPrix() {
		return 50*getSurface();
	}
	
	/* Permet d'ajouter des boutiques si besoin */
	public void ajouterBoutiques() {
		nbBoutiques ++;
		this.setSurface(getSurface() + (int)(Math.random()*50 + 50));
	}
	
	/* Retourne le nombre d'etages*/
	public int getNbEtages() {
		return (int)(Math.random()*4);
	}
	
	/* Retourne la couleur de l'objet */
	public Color getColor() {
		return Color.BLUE;
	}
}
