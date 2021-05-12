package ville;

import batiments.*;
import graphisme.*;
/**
 * Classe finale Generateur : 
 * ne peut pas etre instanciee
 * renvoie un batiment au hasard
 * Les proportions sont 30% de Maisons, 30% d'Immeubles, 40% d'Usines
 * */
public final class Generateur {
	/* Methode static car il s'agit d'une classe utilitaire */
	public static Batiments getNewBatiments() {
		if (Math.random() < 0.3) {
			return new Maison();
		} else if (Math.random() >= 0.3 && Math.random() < 0.6) {
			return new Immeuble();
		} else {
			return new Usine();
		}
	}
	public static Item getNewItem(double probB, double probP) {
		double rand = Math.random();
		if (rand < probB) {
			if (rand < probB*0.3)
				return new Maison();
			else if (rand >= probB*0.3 && Math.random() < probB*0.6) {
				return new Immeuble();
			}
			else if (rand >= probB*0.6){
				return new Usine();
			}			
		}	
		else if (rand >= 1-probB && rand < 1-probP) {
			return new Parc();
		}
		return new Route();
	}
}
