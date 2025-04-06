import java.io.*;

public class Jeu {
	
	private Paquet pioche;

	private Paquet paquet_joueur;
	private int solde;
	private BufferedReader src;
	private int mise=0;

	private Paquet paquet_croupier;

	public static final String VERT="\u001B[32m";
	public static final String RESET="\u001B[0m";

	/**
	 * Permet de creer un jeu avec des paquets
	 * une pioche, une main joueur, une main croupier
	 */
	public Jeu() throws Exception{
		this.pioche = new Paquet("../data/cartes.txt");
		this.paquet_joueur = new Paquet();
		this.paquet_croupier = new Paquet();
	
		this.src=new BufferedReader(new FileReader("../../solde.txt"));
		this.solde=Integer.parseInt(this.src.readLine());
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
		Carte carte=this.pioche.piocherCarte();
		carte.retourner();
		this.paquet_joueur.ajouterCarte(carte);

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

	public void retournerCroupier(int index){
		this.paquet_croupier.retournerCarte(index);
	}

	public int retournerCroupierSomme(){
		return this.paquet_croupier.getSomme();
	}

	public int retournerJoueurSomme(){
		return this.paquet_joueur.getSomme();
	}

	public void miser(int m) {
		if(m<=this.solde){
			this.mise+=m;
			this.solde-=m;
		}else{
			this.mise=this.solde;
			this.solde=0;
		}
	}

	public void gagner() {
		this.solde+=this.mise*2;
		this.mise=0;
	}

	public void perdre(){
		this.mise=0;
	}

	public void tirer() throws Exception{
		boolean bustJoueur = this.piocherJoueur();
		boolean bustCroupier=false;

		Thread.sleep(1000);
		System.out.println(this.toString()+'\n'+'\n');

		if(bustJoueur){
			this.perdre(); 
			this.paquet_croupier.retournerPaquet();
			System.out.println(this.toString()+'\n');
			System.out.println("Vous avez bust ...");
		}else{
			while(this.retournerCroupierSomme()<16) {
				bustCroupier=this.piocherCroupier();
				this.paquet_croupier.retournerPaquet();
				
				
				Thread.sleep(2000);
				System.out.println(this.toString()+'\n'+'\n');
			}

			if(bustCroupier || this.retournerJoueurSomme() > this.retournerCroupierSomme()) {
				this.gagner(); 
				System.out.println(this.toString()+'\n'+'\n');
				Thread.sleep(2000);
				System.out.println(this.toString()+'\n');
				System.out.println("Félicitations, vous avez battus le Croupier ! ");
			}else {
				this.perdre(); 
				System.out.println(this.toString()+'\n'+'\n');
				Thread.sleep(2000);
				System.out.println(this.toString()+'\n');
				System.out.println("Dommage, le Croupier vous a battu ...");
			}
		}

	}

	public void rester(){

	}

	public String toString() {
		String res="\n"+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n'+'\n';

		res+=VERT + "*****************************************************" + '\n' + RESET;
		res+="\t" + "\t" + "Table de Black Jack" + '\n';
		res+=VERT + "-----------------------------------------------------" + '\n' + RESET;

		res+="Croupier : " + '\n';
		res+="\t"+this.paquet_croupier.toString()+'\n';
		res+=VERT + '\n' + "-----------------------------------------------------" + '\n' + RESET;

		res+="Joueur : " + '\n';
		res+="\t"+this.paquet_joueur.toString()+'\n' + "\t"+"\t"+"\t"+ "Solde : " + this.solde + "\t" + "Mise : " + this.mise + '\n'+'\n';

		res+=VERT + "*****************************************************" + RESET;

		return res;
	}

}