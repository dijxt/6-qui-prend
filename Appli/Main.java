package Appli;
import jeu.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*import static Appli.Game.quiVaRamasser;*/
import static Appli.Input.*;
import static Appli.Output.*;
import static Appli.Game.jouerCarte;
import static util.Console.clearScreen;
import static util.Console.pause;


public class Main {

    private static ArrayList<String> lireConfig(){
        try {
            // Prise en compte des joueurs;
            FileInputStream nomsJoueurs = new FileInputStream("config.txt");
            Scanner sc = new Scanner(nomsJoueurs);
            ArrayList<String> listeJoueurs = new ArrayList<>();
            while (sc.hasNext()) {
                listeJoueurs.add(sc.next());
            }
            sc.close();
            return listeJoueurs;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }




    private static void serie(Table t, Scanner sc){
        for(int i = 0; i < lireConfig().size(); ++i){
            System.out.println(tourJoueur(t.getJoueurs().get(i).nomJoueur()));
            pause();
            for (int j = 0; j < 4; ++j){
                System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
            }
            System.out.println(cartesJoueur(t.getJoueurs().get(i)));
            t.getJoueurs().get(i).setProchainCoup(saisirChoix(t, i, sc));
            clearScreen();
        }
        t.ordreJeu();
        System.out.println(cartesAJouer(t));
        for(int i = 0; i < lireConfig().size(); ++i){
            jouerCarte(t, i, sc);
        }
        System.out.println(cartesPosees(t));
        for (int j = 0; j < 4; ++j){
            System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
        }
        // TODO: 21/02/2022 afficher tete de boeuf fin de série 
        t.remettreOrdre();
    }



    public static void main (String[] args) {
        Table t = new Table(lireConfig());
        Scanner sc = new Scanner(System.in);
        System.out.println(messageDebut(lireConfig()));
        for(int i = 0; i < 10; ++i){
            serie(t, sc);
        }
        // TODO: 21/02/2022 afficher resultat final 
        sc.close();
    }

}

