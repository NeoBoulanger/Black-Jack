public class Jeu {
	
	private Paquet pioche;

	private Paquet paquet_joueur;

	private Paquet paquet_croupier;

	/**
	 * Permet de creer un jeu avec des paquets
	 * une pioche, une main joueur, une main croupier
	 */
	public Jeu() throws Exception{
		this.pioche = new Paquet("../data/cartes.txt");
		this.paquet_joueur = new Paquet();
		this.paquet_croupier = new Paquet();
	}

	/**
	 * Permet de piocher une carte et de retourner vrai si le joueur effectue un "bust"
	 * 
	 * @return Vrai si le joueur dépasse 21 et faux si le joueur ne dépasse pas 21
	 */ 
	public boolean piocherJoueur() {
		// On initialise une somme à 0
		int somme=0;

		// On pioche une carte dans la pioche et on l'ajoute au paquet du joueur
		this.paquet_joueur.ajouterCarte(this.pioche.piocherCarte());

		// On parcours le paquet du joueur et on fais la somme 
		for(int i=0; i<=this.paquet_joueur.getNbCarte()-1; i++) {
			somme+=this.paquet_joueur.getCarte(i).getPuissance();
		}

		// Retourne vrai si le joueur a bust
		return (somme>21);
	}

	/**
	 * Permet de piocher une carte et de retourner vrai si le croupier effectue un "bust"
	 * 
	 * @return Vrai si le croupier dépasse 21 et faux si le croupier ne dépasse pas 21
	 */ 
	public boolean piocherCroupier() {
		// On initialise une somme à 0
		int somme=0;

		// On pioche une carte dans la pioche et on l'ajoute au paquet du joueur
		this.paquet_croupier.ajouterCarte(this.pioche.piocherCarte());

		// On parcours le paquet du joueur et on fais la somme 
		for(int i=0; i<=this.paquet_croupier.getNbCarte()-1; i++) {
			somme+=this.paquet_croupier.getCarte(i).getPuissance();
		}

		// Retourne vrai si le joueur a bust
		return (somme>21);
	}	

}