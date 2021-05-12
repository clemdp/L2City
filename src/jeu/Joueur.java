package jeu;
import batiments.*;
import exception.*;
import graphisme.Item;
import ville.*;

/**
 * Classe final Joueur :
 * n'a pas vocation a avoir de sous-classes
 * A pour attributs un nom, une ville et un porteMonnaie
 *  * */

public final class Joueur {
	private String nom;
	private VilleJPanel ville;
	private /*static*/ int porteMonnaie;
	
	/* Constructeur prenant en parametres un nom de joueur
	 * et une ville, initialise le porte monnaie � 100.000 */
	public Joueur(String nom, VilleJPanel ville) {
		this.nom = nom;
		this.ville = ville;
		porteMonnaie = 100000;
	}
	
	/* Si le joueur a suffisamment d'argent, ajoute le batiment
	 * dans la ville et debite le prix dans le porteMonnaie */
	public void acheterBatiment(Batiments b) {
		if (porteMonnaie >= b.getPrix()) {
			ville.ajouter(b);
			porteMonnaie = porteMonnaie - b.getPrix();
			System.out.println(nom+" a achete "+b.toString());
		}
	}
	
	/* Modification de la methode acheterBatiment avec l'Item 
	 * ajoute l'Item dans la ville et debite le prix dans le
	 * porteMonnaie */
	public void acheterItem(Item item, int x, int y) throws ItemNullException{
		if (item == null) {
			throw new ItemNullException();
		}
		if (item instanceof Batiments) {
			int prix = ((Batiments)item).getPrix();
			if (porteMonnaie >= prix) {
				ville.ajouter(item, x, y);
				depense(prix);
				System.out.println("Joueur "+nom+" a achete "+item.toString());
			} else {
				System.out.println("Pas assez d'argent ! "+prix);
			}
		}
		
	}
	
	/* Ramasse les loyers et les ajoutes dans le porteMonnaie */
	public void recupererLoyer() throws ClassException{
		porteMonnaie += ville.releverLoyer();
	}
	
	/* Renvoie le contenu du porte-monnaie */
	public int getPorteMonnaie() {
		return porteMonnaie;
	}
	
	public void depense(int prix) {
		porteMonnaie = porteMonnaie - prix;
		System.out.println(nom+" a depense "+prix);
	}
	
	/* Initialisation de la ville du joueur */
	public void init(int nbTour) throws InterruptedException {
		for(int i = 0; i < nbTour; i ++) {
			Thread.sleep(50); 	//ralenti l'affichage
			ville.ajouter(Generateur.getNewItem(0.4, 0.3));
			ville.repaint(); 	//redessine le graphique
		}
		
	}
	
	
	
	public void update(String[] tab) {		
		try {
			int x = Integer.parseInt(tab[1]);
			int y = Integer.parseInt(tab[2]);
			acheterItem(Menu.action(tab[0]), x-1, y-1);
		} catch (NumberFormatException e){
			System.out.println("Erreur int expression : "+e.getMessage());
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Erreur : aucun argument de donne");
		} catch (ItemNullException ine) {
			System.out.println(ine.toString());
		}
		System.out.println(ville.toString());
		ville.repaint();
		
	}

}
