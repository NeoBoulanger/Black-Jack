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


}