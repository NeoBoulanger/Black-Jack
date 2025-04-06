import java.util.*;
import java.io.*;

public class Paquet {
	private ArrayList<Carte> paquet;
	private BufferedReader src;
	private int nbCarte=0;

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
		this.paquet = new ArrayList<Carte>();
		int i=0;
		String[] carteSplit;
		String ligne;
		while ((ligne=this.src.readLine())!=null) {
			carteSplit=ligne.split(";");

			Carte carte=new Carte(Integer.parseInt(carteSplit[0]), Integer.parseInt(carteSplit[1]));

			this.paquet.add(carte);
		}
		this.nbCarte=52;
	}
	
	/**
	 * Permet de retirer une carte du paquet à l'aide d'un indice donné
	 * 
	 * @param index Indice de la carte à supprimer
	 */
	public void retirerCarte(int index) {
		this.paquet.remove(index);
		this.nbCarte-=1;
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
		this.nbCarte+=1;
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
		for (int i=0; i<=this.paquet.size()-1;i++) {
			res+= this.paquet.get(i).toString() + " ";
		}
		return res;
	}

	public void retournerPaquet(){
		for(int i=0; i<=this.paquet.size() - 1 ;i++){
			this.paquet.get(i).retourner();
		}
	}

	public void retournerCarte(int index) {
		this.paquet.get(index-1).retourner();
	}

	public int getNbCarte() {
		return this.nbCarte;
	}

	public Carte getCarte(int index) {
		return this.paquet.get(index);
	}

	public int getSomme(){
		int somme=0;
		for (int i=0; i<=this.paquet.size()-1; i++) {
			somme+=this.paquet.get(i).getPuissance();
		}
		return somme;
	}
}