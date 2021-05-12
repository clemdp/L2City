/**
 * 
 */
package batiments;

import graphisme.Item;

/**
 * @author Clement
 * 
 * Classe mere batiment
 * 
 */
public abstract class Batiments implements Item {
	private static int nbBatiments;
	protected int id;
	protected String type;
	private int surface;
	
	/* Constructeur prenant 2 arguments */
	public Batiments(String type, int surface) {
		nbBatiments++;
		id = nbBatiments;
		this.type = type;
		this.surface = surface;
	}
	
	/*Accesseur static sur le nombre de batiments
	 * qui est un attribut static */
	public static int getNbBatiments() {
		return nbBatiments;
	}
	
	public int getSurface() {
		return surface;
	}
	
	/*Setteur en protected : seules les classes
	 * filles peuvent modifier la surface */
	protected void setSurface(int surface) {
		this.surface = surface;
	}
	
	/*Calculateur abstrait car le prix du batiment
	 * depends de proprietes et d'attributs propres
	 * aux sous-classes de batiments*/
	public abstract int getPrix();
	
	/*Le loyer depend du prix, on sait pourtant que
	 * toutes les classes filles de batiments auront
	 * un prix donc on peut deja calculer le loyer*/
	public int getLoyer() {
		return 5*getPrix()/100;
	}
	
	/*On affiche une breve description du batiment*/
	public String toString() {
		return type+" No "+id+" "+surface+"m2 prix = "+getPrix();
	}
	
	/*retourne l'ID du batiment en une chaine de 3 char*/
	public String getStringID() {
		return String.format("%c%02d", type.charAt(0), id);
	}
}
