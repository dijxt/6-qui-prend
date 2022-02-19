package Appli;

import jeu.Carte;
import jeu.Joueur;
import jeu.Table;

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

    public static String afficherSerie(ArrayList<Carte> serie, int numSerie){
        String cartes = "";
        for (Carte c : serie){
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

    public static String cartesJoueur(Joueur j){
        String cartes = "- Vos cartes : ";
        for (Carte c: j.getDeck()) {
            if (c == j.getDeck().get(j.getDeck().size() - 1)){
                if (c.getTete() > 1){
                    cartes = cartes + String.valueOf(c.getNum()) + " (" + String.valueOf(c.getTete()) + ")";
                }
                else {
                    cartes = cartes + ", " + String.valueOf(c.getNum()) + "(" + String.valueOf(c.getTete()) + ")";
                }
            }
            else {
                if (c.getTete() > 1){
                    cartes = cartes + String.valueOf(c.getNum()) + " (" + String.valueOf(c.getTete()) + ")";
                }
                else {
                    cartes = cartes + ", " + String.valueOf(c.getNum());
                }
            }
        }
        return cartes;
    }

    public static int saisirChoix(Table t, int joueur){
        System.out.print("Saisissez votre choix : ");
        boolean choixValide = false;
        int coup = 0;
        Scanner sc = new Scanner(System.in);
        while (choixValide){
            coup = Integer.valueOf(sc.next());
            for (Carte c : t.getJoueurs().get(joueur).getDeck()){
                if(c.getNum() == coup){
                    choixValide = true;
                }
            }
            if (choixValide == false){
                System.out.print("Vous n?avez pas cette carte, saisissez votre choix : ");
            }
        }
        sc.close();
        return coup;
    }

    public static String cartesAJouer(Table t){
        String cartes = "";
        for (Joueur j : t.getJoueurs()){
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
