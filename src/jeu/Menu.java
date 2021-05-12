package jeu;


import batiments.*;
import graphisme.*;

public class Menu {
	
	public static String getMenu() {
		return " Menu du Jeu : \n [M] : "
				+ "ajoute une nouvelle maison \n"
				+ " [I] : ajoute un nouvel immeuble \n"
				+ " [U] : ajoute une nouvelle usine \n"
				+ " [B] : ajoute une nouvelle boutique \n"
				+ " [R] : ajoute une nouvelle route \n"
				+ " [P] : ajoute un nouveau parc \n"
				+ " [C] : ajoute un centre commercial";
	}
	
	public static Item action(String s) {
		Item i = null;
		switch(s) {
			case("m"):
				i = new Maison();
				break;
			case("M"):
				i = new Maison();
				break;
			case("i"):
				i = new Immeuble();
				break;
			case("I"):
				i = new Immeuble();
				break;
			case("u"):
				i = new Usine();
				break;
			case("U"):
				i = new Usine();
				break;
			case("b"):
				i = new Boutique();
				break;
			case("B"):
				i = new Boutique();
				break;
			case("r"):
				i = new Route();
				break;
			case("R"):
				i = new Route();
				break;
			case("p"):
				i = new Parc();
				break;
			case("P"):
				i = new Parc();
				break;
			case("c"):
				i = new CentreCommercial();
				break;
			case("C"):
				i = new CentreCommercial();
				break;			
			default:
				break;		
		}
		return i;
	}
}