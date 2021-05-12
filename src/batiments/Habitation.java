/**
 * 
 */
package batiments;

/** 
 * @author Clement
 * 
 * Classe fille abstraite Habitation herite de Batiments
 * 
 * **/

public abstract class Habitation extends Batiments {
	private char classeEnergie;
	/* Constructeur utilisant 2 parametres 
	 * utiles au constructeur de la classe mere */
	public Habitation(String type, int surface) {
		// TODO Auto-generated constructor stub
		super(type, surface);
		classeEnergie = (char)(Math.random()*('G'-'A') + 'A');
	}
	
	/* Prend un seul constructeur de plus que le precedent
	 * la classe energetique est passee en parametre */
	public Habitation(String type, int surface, char classeEnergie) {
		this(type, surface);
		this.classeEnergie = classeEnergie;
	}
	
	/* Renvoie une chaine composee de la chaine renvoyee 
	 * par la mere + la classe energetique et le nb d'habitants*/
	public String toString() {
		return super.toString()+" classe "+classeEnergie+
				" nbHab = "+getNbHab();
	}
	
	/* Renvoie le nb d'habitants :
	 * depend du sous-type d'habitation */
	public abstract int getNbHab();
	
	/* Renvoie le prix d'achat d'une habitation */
	public int getPrix() {
		return getSurface()*250*(10+'G'-classeEnergie);
	}
}
