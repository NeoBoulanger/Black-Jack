import java.util.*;
import java.io.*;

public class Paquet {
	private ArrayList<Carte> paquet;
	private BufferedReader src;

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
}