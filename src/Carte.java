public class Carte {
	// Attributs classiques
	private boolean retournee;
	private int valeur;
	private int couleur;

	// Attributs pour les couleurs
	private static final int COEUR=1;
	private static final int PIQUE=2;
	private static final int TREFLE=3;
	private static final int CARREAU=4;

	// Définition des couleurs pour afficher dans le terminal
	public static final String ROUGE = "\u001B[31m";
	public static final String BLEU_CIEL = "\u001B[94m";
	public static final String RESET = "\u001B[0m";


	/**
	 * Permet de construire une carte
	 * 
	 * @param couleur couleur de la carte (1 pour COEUR, 2 pour PIQUE, 3 pour TREFLE, 4 pour CARREAU)
	 * @param valeur valeur de la carte (As jusqu'au Roi)
	 */
	public Carte(int coul, int val){
		// Mise à jour de la valeur de la couleur
		this.couleur=coul;

		// Mise à jour de la valeur de la carte
		if(val >= 13) {this.valeur=13;}
		if(val <= 1) {this.valeur=1;}

		// Cache initialement la face de la carte (Valeur / Couleur invisible)
		this.retournee=false;
	}

	// Déclaration des Méthodes

	/**
	 * Permet de retourner une carte
	 */
	public void retourner() {
		// Remplasser retournee par non retournee
		this.retournee=!this.retournee;
	}

	/**
	 * Permet de retourner la valeur de la carte. Si la carte possède 
	 * une valeur spéciale (As, Valet, Dame, Roi), celle ci sera renvoyée
	 * avec son nom.
	 * 
	 * @return La valeur de la carte sous forme de String
	 */
	public String getValeur() {
		// On vérifie les cas où les cartes sont appelées autrement
		if(this.retournee){return "?";}
		switch (this.valeur) {
			case 1 : return "As";
			case 11 : return "Valet";
			case 12 : return "Dame";
			case 13 : return "Roi";
		}
		
		// On retourne simplement la valeur de la carte
		return Integer.toString(this.valeur);
	}

	/**
	 * Permet de retourner le nom de la couleur associée (Coeur, Pique, Trefle, Carreau)
	 * 
	 * @return Nom de la couleur sous forme de String
	 */
	public String getCouleur() {
		// On retourne le nom de la couleur associée
		if(this.retournee){return "?";}
		switch (this.couleur) {
			case Carte.COEUR : return "Coeur";
			case Carte.PIQUE : return "Pique";
			case Carte.TREFLE : return "Trèfle";
			case Carte.CARREAU : return "Carreau";
		}
		return "";
	}

	/**
	 * Permet de retourner les details de la carte sous forme de texte
	 * (As de Coeur, 10 de Pique, ...)
	 * 
	 * @return Le nom de la couleur de la carte sous forme de String
	 */ 
	public String toStringPhrase() {
		// On construit la présentation d'une carte
		return (this.getValeur() + " de " + this.getCouleur()); 
	}

	/** 
	 * Permet de retourner le modèle de la carte qui apparaitra
	 * dans le terminal
	 * 
	 * @return les caractéristique de la carte
	 */
	public String toString() {
		// Si c'est coeur alors
		if (this.couleur == COEUR) {
			return ("[ " + ROUGE + this.valeur + " \u2665" + RESET + " ]");
		}

		// Si c'est carreau alors
		if (this.couleur == CARREAU) {
			return ("[ " + ROUGE + this.valeur + " \u2666" + RESET + " ]");
		}

		// Si c'est trefle alors
		if (this.couleur == TREFLE) {
			return ("[ " + BLEU_CIEL + this.valeur + " \u2663" + RESET + " ]");
		}

		// Si c'est pique alors
		return ("[ " + BLEU_CIEL + this.valeur + " \u2660" + RESET + " ]");
	}
}