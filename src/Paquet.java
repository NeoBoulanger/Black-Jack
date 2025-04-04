import java.util.*;
import java.io.*;

public class Paquet {
	private ArrayList<Carte> paquet;
	private BufferedReader src;
	private static int nbCarte=0;

	/** 
	 * Constructeur vide permettant de construire un paquet vide.
	 * Utile pour créer un paquet pour le joueur ou le croupier
	 */
	public Paquet () {
		this.paquet = new ArrayList<Carte>();
	}

	/** 
	 * Permet de construire une pioche avec le fichier de données
	 * 
	 * @param fichier Le chemin du fichier où se trouve les données
	 */
	public Paquet(String fichier) throws Exception{
		this.src=new BufferedReader(new FileReader("../data/cartes.txt"));
		int i=0;
		String[] carteSplit;
		while (i<=53) {
			String split=this.src.readLine();
			carteSplit=split.split(";");

			Carte carte=new Carte(Integer.parseInt(carteSplit[0]), Integer.parseInt(carteSplit[1]));

			this.paquet.add(carte);
		}
	}
	
	/**
	 * Permet de retirer une carte du paquet à l'aide d'un indice donné
	 * 
	 * @param index Indice de la carte à supprimer
	 */
	public void retirerCarte(int index) {
		this.paquet.remove(index);
	}

	/**
	 * Permet de piocher une carte dans le paquet construit. La carte est choisi au hasard puis supprimée du paquet
	 * 
	 * @return La carte qui a été piochée
	 */
	public Carte piocherCarte() {
		// Génération d'un index pour piocher une carte au hasard
		int index = (int) (Math.random()*this.paquet.size());
		Carte carte = this.paquet.get(index);
		this.retirerCarte(index);
		return carte;
	}

	/**
	 * Permet d'ajouter une carte au paquet, cela permet de creer un paquet joueur et croupier
	 * et d'ajouter les cartes piochée
	 * 
	 * @param carte Carte à ajouter au paquet
	 */
	public void ajouterCarte(Carte c) {
		this.paquet.add(c);
	}

	/**
	 * Permet de retourner le paquet de carte sous format texte
	 * 
	 * @return Le paquet et les caractéristique des cartes sous forme de texte
	 */
	public String toString() {
		//	Création de la String de return
		String res="";
		// Parcours de la liste et concaténation des cartes
		for (int i=0; i<=this.paquet.size();i++) {
			res+= this.paquet.get(i).toString() + " ";
		}
		return res;
	}
}