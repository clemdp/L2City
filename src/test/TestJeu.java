package test;

import ville.*;

public class TestJeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Maison m1 = new Maison();
		Maison m2 = new Maison();
		System.out.println(m1.toString());
		System.out.println(m1.getStringID());
		System.out.println(m2.toString());
		System.out.println(m2.getStringID());
		System.out.println("Nb batiments crees : "+Batiments.getNbBatiments());
		*/
		Ville v = new Ville("L2City", 12);
		for(int i = 0; i < 12; i++) {
			v.ajouter(Generateur.getNewBatiments());
		}
		System.out.println(v.toString());
		v.afficherBatimentAEtage(3);
		v.afficherVille();
	}

}
