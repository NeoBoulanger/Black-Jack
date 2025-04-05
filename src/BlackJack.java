public class BlackJack {
	
	public static void main(String args[]) throws Exception{


		Carte carte1 = new Carte(Carte.CARREAU, 7);
		carte1.retourner();
		System.out.println(carte1);	


		Carte carte2 = new Carte(Carte.TREFLE, 10);
		carte2.retourner();
		System.out.println(carte2);	

		Paquet paquet = new Paquet("../data/cartes.txt");
		paquet.retournerPaquet();
		System.out.println(paquet);
	}
}