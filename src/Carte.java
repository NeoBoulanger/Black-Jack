public class Carte {
	// Attributs classiques
	private boolean retournee;
	private int valeur;
	private int couleur;
	private int puissance;

	// Attributs pour les couleurs
	public static final int COEUR=1;
	public static final int PIQUE=2;
	public static final int TREFLE=3;
	public static final int CARREAU=4;

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
		this.valeur=val;

		// Cache initialement la face de la carte (Valeur / Couleur invisible)
		this.retournee=false;

		// Mise à jour de la puissance de la carte
		this.puissance=val;
		if(this.puissance >=10){this.puissance=10;}
		if(this.puissance <= 1){this.puissance=11;}
	}

	// Déclaration des Méthodes

	/**
	 * Permet de retourner une carte
	 */
	public void retourner() {
		// Remplasser retournee par non retournee
		this.retournee=true;
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
	 * Permet de retourner la puissance de la carte
	 * 
	 * @return La valeur de la puissance de la carte
	 */
	public int getPuissance() {
		return this.puissance;
	}

	/**
	 * Permet de retourner le nom de la couleur associée (Coeur, Pique, Trefle, Carreau)
	 * 
	 * @return Nom de la couleur sous forme de String
	 */
	public String getCouleur() {
		// On retourne le nom de la couleur associée
		switch (this.couleur) {
			case Carte.COEUR : return "Coeur";
			case Carte.PIQUE : return "Pique";
			case Carte.TREFLE : return "Trèfle";
			case Carte.CARREAU : return "Carreau";
		}
		return "";
	}

	public boolean getRetourne(){
		return this.retournee;
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
		if(!this.retournee) {return ("\u001B[37m"+"[??]"+RESET);}

		String value = String.valueOf(this.valeur);
		switch (this.valeur) {
			case 11 : value="V"; break;
			case 12 : value="D"; break;
			case 13 : value="R"; break;
		}

		// Si c'est coeur alors
		if (this.couleur == COEUR) {
			return (ROUGE + "[" + value + "\u2665" + "]" + RESET);
		}

		// Si c'est carreau alors
		if (this.couleur == CARREAU) {
			return (ROUGE + "[" + value + "\u2666" + "]" + RESET);
		}

		// Si c'est trefle alors
		if (this.couleur == TREFLE) {
			return (BLEU_CIEL + "[" + value + "\u2663" + "]" + RESET);
		}

		// Si c'est pique alors
		return (BLEU_CIEL + "[" + value + "\u2660" + "]" + RESET);
	}
}