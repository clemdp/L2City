package ville;

import batiments.*;
import exception.ClassException;
import graphisme.*;
import jeu.Menu;

import java.awt.*;
import javax.swing.*;

public class VilleJPanel extends JPanel {
	private String nom;
	private Item[][] terrain;
	private int tailleCase;
	
	/* Constructeur prenant 2 parametres : 
	 * le nom de la ville et la taille d'un cote de la matrice.
	 * Ce constructeur initialise la matrice terrain */
	public VilleJPanel(String nom, int nbCase, int tailleCase) {
		setPreferredSize(new Dimension(nbCase*tailleCase, nbCase*tailleCase));
		this.tailleCase = tailleCase;
		this.nom = nom;
		terrain = new Item[nbCase][nbCase];
	}
	
	/* Methode ajouter : permet d'ajouter un batiment a des
	 * coordonnees random uniquement si la case du terrain
	 * est vide */
	public boolean ajouter(Item b) {
		int x = (int)(Math.random()*terrain.length);
		int y = (int)(Math.random()*terrain.length);
		if ( terrain[x][y] != null ) {
			return false;
		}
		else {
			terrain[x][y] = b;
			return true;
		}
	}
	
	/* Surcharge de la methode ajouter : permet d'ajouter un item
	 * a des coordonnees donnees en argument si la case demandee
	 * est vide. */
	public boolean ajouter(Item b, int x, int y) {
		if ( terrain[x][y] != null ) {
			return false;
		}
		else {
			terrain[x][y] = b;
			return true;
		}
	}
	
	/* Affiche directement dans le terminal le contenu de la ville */
	public void afficherVille() {
		for(int i = 0; i < terrain.length; i++) {
			for(int j = 0; j < terrain.length; j++) {
				if (terrain[i][j] == null) {
					System.out.print(" . ");
				}
				else {
					System.out.print(terrain[i][j].getStringID());
				}
			} System.out.print("\n");
		}
	}
	
	/* Retourne la somme des loyers generes par les batiments */
	public int releverLoyer() {
		int loyertotal = 0;
		for(int i = 0; i < terrain.length; i++) {
			for(int j = 0; j < terrain.length; j++) {
				if (terrain[i][j] != null) {
					if (terrain[i][j] instanceof Batiments) {
						loyertotal += ((Batiments)terrain[i][j]).getLoyer();
					}
				}
			}
		} return loyertotal;
	}
	
	/* Renvoie le nombre total d'habitants dans la ville */
	public int compterHabitants() {
		int nbHab = 0;
		for(int i = 0; i < terrain.length; i++) {
			for(int j = 0; j < terrain.length; j++) {
				if (terrain[i][j] != null) {
					if (terrain[i][j] instanceof Maison || terrain[i][j] instanceof Immeuble) {
						nbHab += ((Habitation) terrain[i][j]).getNbHab();
					}
				}
			}
		} return nbHab;
	}
	
	/* Affiche uniquement les batiments ayant un nombre 
	 * d'etage superieur a nbE */
	public void afficherBatimentAEtage(int nbE) {
		for(int i = 0; i < terrain.length; i++) {
			for(int j = 0; j < terrain.length; j++) {
				if (terrain[i][j] instanceof Immeuble || terrain[i][j] instanceof Usine) {
					if (((AEtage) terrain[i][j]).getNbEtages() >= nbE) {
						System.out.println(terrain[i][j].toString());
					}
				}
			}
		}
	}
	
	/* Renvoie une breve description de la ville */
	public String toString() {
		return "Ville "+nom+" nbHab = "+compterHabitants()+"\n nbBatiments : "+Batiments.getNbBatiments()+"\n nbParcs : "+Parc.getNbParc()+"\n nbRoutes : "+Route.getNbRoutes();
	}
	
	/* Peint les Item dans la fenetre */
	public void paintComponent(Graphics g) {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[i].length; j++) {
				if (terrain[i][j] != null ) {
					g.setColor(terrain[i][j].getColor());
					if (terrain[i][j] instanceof Batiments) {
						if (terrain[i][j] instanceof AEtage) {
							g.fill3DRect(i*tailleCase, j*tailleCase, ((Batiments) terrain[i][j]).getSurface()%tailleCase + tailleCase, ((Batiments) terrain[i][j]).getSurface()%tailleCase + tailleCase, true);
						} else {
							g.fillRect(i*tailleCase, j*tailleCase, ((Batiments) terrain[i][j]).getSurface()%tailleCase + tailleCase, ((Batiments) terrain[i][j]).getSurface()%tailleCase + tailleCase);
						}
					} else {
						g.fillRect(i*tailleCase, j*tailleCase, tailleCase, tailleCase);
					}
				}
			}
		}
	}
}
