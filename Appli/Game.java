package Appli;

import jeu.Carte;
import jeu.Table;

import java.util.Scanner;

import static Appli.Input.saisirSerie;
import static Appli.Output.afficherSerie;

public class Game {
    public static void jouerCarte(Table t, int joueur, Scanner sc){
        int carte = t.getJoueurs().get(joueur).getProchainCoup();
        if (t.choixListe(t.getJoueurs().get(joueur).getProchainCoup()) == -1){
            int serie = -1;
            System.out.println("Pour poser la carte " + String.valueOf(t.getJoueurs().get(joueur).getProchainCoup()) + ", " + t.getJoueurs().get(joueur).nomJoueur() + " doit choisir la série qu'il va ramasser.");
            for (int j = 0; j < 4; ++j){
                System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
            }
            serie = saisirSerie(t, joueur, sc);
            for (int j = 0; j < t.getLisTab().get(serie - 1).size(); ++j){
                t.getJoueurs().get(joueur).setPoints(t.getLisTab().get(serie - 1).get(0).getTete());
                t.getLisTab().get(serie - 1).remove(0);
            }
            t.getLisTab().get(serie - 1).add(new Carte(t.getJoueurs().get(joueur).getProchainCoup()));
            t.getJoueurs().get(joueur).jposerCarte(carte);
        }
        else {
            t.getJoueurs().get(joueur).jposerCarte(carte);
            t.jouerCarte(carte, joueur);
        }

    }

    /*public static void quiVaRamasser(Table t, Scanner sc){
        for (int i = 0; i < t.getJoueurs().size(); ++i){
            if (t.choixListe(t.getJoueurs().get(i).getProchainCoup()) == -1){
                t.getJoueurs().get(i).setDoitRamasser(true);
            }
        }
        for (int i = 0; i < t.getJoueurs().size(); ++i){
            if (t.getJoueurs().get(i).getDoitRamasser()){
                int serie = -1;
                System.out.println("Pour poser la carte " + String.valueOf(t.getJoueurs().get(i).getProchainCoup()) + ", " + t.getJoueurs().get(i).nomJoueur() + " doit choisir la série qu'il va ramasser.");
                for (int j = 0; j < 4; ++j){
                    System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
                }
                serie = saisirSerie(t, i, sc);
                for (int j = 0; j < t.getLisTab().get(serie - 1).size(); ++j){
                    t.getJoueurs().get(i).setPoints(t.getLisTab().get(serie - 1).get(0).getTete());
                    t.getLisTab().get(serie - 1).remove(0);
                }
                t.getLisTab().get(serie - 1).add(new Carte(t.getJoueurs().get(i).getProchainCoup()));

                t.getJoueurs().get(i).setDoitRamasser(false);
            }
        }
    }*/
}
