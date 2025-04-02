import java.util.*;
import java.io.*;

public class Paquet {
	private ArrayList<Carte> paquet;
	private BufferedReader src;
	private static int nbCarte=0;

	public Paquet() throws Exception{
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

	public Carte piocherCarte() {
		// Génération d'un index pour piocher une carte au hasard
		int index = Math.ceil(Math.random()*52)+1;
		Carte carte = this.paquet.get(index);
		this.paquet.retirerCarte(index);

	}

	public retirerCarte(int index) {
		this.paquet.remove(index);
	}
}