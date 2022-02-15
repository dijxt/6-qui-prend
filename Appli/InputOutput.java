package Appli;

import jeu.carte;
import jeu.joueur;
import jeu.table;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

    public static String messageDebut(ArrayList<String> joueurs) {
        String players = "";
        for (String e:joueurs) {
            if (e == joueurs.get(0)){
                players = players + e;
            }
            else if (e == joueurs.get(joueurs.size()-1)){
                players = players + " et " + e;
            }
            else {
                players = players + ", " + e;
            }
        }
        return "Les " + String.valueOf(joueurs.size()) + " joueurs sont " + players + " Merci de jouer à 6 qui prend !";
    }

    public static String tourJoueur(String joueur){
        return "A " + joueur + " de jouer.";
    }

    public static String afficherSerie(ArrayList<carte> serie, int numSerie){
        String cartes = "";
        for (carte c : serie){
            if (c.getTete() > 1){
                if (c == serie.get(0)){
                    cartes = cartes + c.getNum() + " (" + c.getTete() + ")";
                }
                else{
                    cartes = cartes + ", " + c.getNum() + "(" + c.getTete() + ")";
                }
            }
            else{
                if (c == serie.get(0)){
                    cartes = cartes + c.getNum();
                }
                else{
                    cartes = cartes + ", " + c.getNum();
                }
            }
        }
        return "- série n° " + String.valueOf(numSerie) + " : " + cartes;
    }

    public static int saisirChoix(table t, int joueur){
        System.out.print("Saisissez votre choix : ");
        boolean choixValide = false;
        int coup = 0;
        Scanner sc = new Scanner(System.in);
        while (choixValide){
            coup = Integer.valueOf(sc.next());
            for (carte c : t.getJoueurs().get(joueur).getDeck()){
                if(c.getNum() == coup){
                    choixValide = true;
                }
            }
            if (choixValide == false){
                System.out.print("Vous n’avez pas cette carte, saisissez votre choix : ");
            }
        }
        sc.close();
        return coup;
    }

    public static String cartesAJouer(table t){
        String cartes = "";
        for (joueur j : t.getJoueurs()){
            if (j == t.getJoueurs().get(0)){
                cartes = cartes + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            }
            else if (j == t.getJoueurs().get(t.getJoueurs().size() - 1)){
                cartes = cartes + " et " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            }
            else {
                cartes = cartes + ", " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            }
        }
        return "Les cartes " + cartes + " vont êtres posées";
    }
}
