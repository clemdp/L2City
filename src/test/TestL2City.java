package test;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import exception.ClassException;
import exception.ItemNullException;
import jeu.*;
import ville.VilleJPanel;

public class TestL2City {
	private static final int TAILLE_CASE=15;
	private static final int NB_CASES=20;

	public static void main(String[]args) throws InterruptedException{
		JFrame f = new JFrame("L2City");	//Creation fenetre graphique
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		
		JLabel label = new JLabel("Bienvenue dans L2 City");
		
		//Creation de la ville (qui est aussi un panneau)
		VilleJPanel villeJPanel = new VilleJPanel("L2City", NB_CASES, TAILLE_CASE);
		f.setContentPane(villeJPanel); 	//ajout du panneau a la fenetre
		f.pack(); 	//adaptation de la fenetre au panneau
		f.setVisible(true); 	//affichage de la fenetre
		
		villeJPanel.add(label);	//ajout d'un titre a la fenetre
		f.setBackground(Color.white);	//defini la couleur du background
		
		Scanner scan = new Scanner(System.in);	//creation d'un Scanner
		
		System.out.println(Menu.getMenu());		//affichage du Menu
		System.out.println("Entree de type : 'lettre chiffre chiffre'");
		
		Joueur j = new Joueur("Clement", villeJPanel);	//creation d'un nouveau Joueur, on lui donne la ville cree
		
		j.init(10);	//on initialise la ville en ajoutant des batiments
		
		System.out.println(villeJPanel.toString());
		
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			String s = scan.nextLine();
			String [] tabs = s.split(" ");
			
			System.out.println("Tour n�"+(i+1));
			j.update(tabs);
			try {
				j.recupererLoyer();
				System.out.println("Loyer : "+villeJPanel.releverLoyer());
			} catch (ClassException ce) {
				System.out.println(ce.getMessage());
			} 
			System.out.println("Porte-monnaie : "+j.getPorteMonnaie());
		}
		
		scan.close();
	}
}
