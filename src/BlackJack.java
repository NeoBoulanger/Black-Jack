import java.util.*;
public class BlackJack {
	public static void main(String args[]) throws Exception{

		Scanner sc=new Scanner(System.in);
		boolean continuer=true;


		
		while(continuer){
				Jeu jeu = new Jeu();

				System.out.println("Solde actuel : " + jeu.getSolde());
				System.out.println("Miser une somme : ");
				jeu.miser(sc.nextInt());
				System.out.println("Très bien, la partie commence");
				Thread.sleep(2000);

				System.out.println(jeu.toString()+'\n'+'\n');

				jeu.piocherJoueur();
				Thread.sleep(2000);
				System.out.println(jeu.toString()+'\n'+'\n');

				jeu.piocherCroupier();
				Thread.sleep(2000);
				System.out.println(jeu.toString()+'\n'+'\n');

				jeu.piocherJoueur();
				Thread.sleep(2000);
				System.out.println(jeu.toString()+'\n'+'\n');

				jeu.piocherCroupier();
				jeu.retournerCroupier(1);
				Thread.sleep(2000);
				System.out.println(jeu.toString()+'\n'+'\n');
				Thread.sleep(3000);

				System.out.println(jeu.toString());
				System.out.println("    [1]-Tirer  [2]-Rester  [3]-Doubler  [4]-Décliner"+'\n');

				System.out.print("Choississez une action : ");
				int action=sc.nextInt();
				System.out.println(jeu.toString()+'\n'+'\n');

				if(action == 1 ){
					jeu.tirer();
				}

				if(action == 2 ){
					jeu.rester();
				}

				if(action == 3 ){
					jeu.doubler();
				}

				if(action == 4 ){
					jeu.decliner();
				}

				jeu.majSolde();
				System.out.println('\n' + "Continuer ?");
				System.out.println(Carte.BLEU_CIEL + "Oui : 1" + Carte.ROUGE + "\t" + "\t" + "Non : 0" + Carte.RESET + '\n');
				
				int reponse=sc.nextInt();

				if(reponse==1){}
				else{
					continuer=false;
				}
		}




	}
}