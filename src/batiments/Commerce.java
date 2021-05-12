package batiments;

/**
 * Classe abstraite Commerce herite de Batiments 
 * (pck un commerce c'est un batiment)
 * */

public abstract class Commerce extends Batiments{
	
	
	/* Constructeur qui prend les parametres necessaires
	 * au constructeur de la classe mere +
	 * initialise le stock avec aucune Marchandise */
	public Commerce(String type, int surface) {
		super(type, surface);
	}
	
	
}
