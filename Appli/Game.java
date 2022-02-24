package Appli;

import jeu.Carte;
import jeu.Table;

import java.util.Scanner;

import static Appli.Input.saisirSerie;
import static Appli.Output.afficherSerie;
import static Appli.Output.cartesAJouer;

public class Game {

    /**
     * Joue la carte d'un joueur sur une table
     * @param t la table
     * @param joueur le joueur
     * @param sc entrée clavier si besoin de sélectionner une série à ramasser
     */
    public static void jouerCarte(Table t, int joueur, Scanner sc){
        int carte = t.getJoueurs().get(joueur).getProchainCoup();
        if (t.choixListe(t.getJoueurs().get(joueur).getProchainCoup()) == -1){ // si le joueur doit ramasser une série
            int serie = -1;
            System.out.println(cartesAJouer(t));
            System.out.println("Pour poser la carte " + String.valueOf(t.getJoueurs().get(joueur).getProchainCoup()) + ", " + t.getJoueurs().get(joueur).nomJoueur() + " doit choisir la série qu'il va ramasser.");
            for (int j = 0; j < 4; ++j){
                System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
            }
            serie = saisirSerie(joueur, sc);
            int head = 0;
            while (!t.getLisTab().get(serie - 1).isEmpty()){
                head += t.getLisTab().get(serie - 1).get(0).getTete();
                t.getLisTab().get(serie - 1).remove(0);
            }
            t.getJoueurs().get(joueur).setPoints(head);
            t.getJoueurs().get(joueur).setPointsDM(head);
            t.getLisTab().get(serie - 1).add(new Carte(t.getJoueurs().get(joueur).getProchainCoup()));
            t.getJoueurs().get(joueur).jposerCarte(carte);
        }
        else { // poser la carte
            t.getJoueurs().get(joueur).jposerCarte(carte);
            t.getJoueurs().get(joueur).setPointsDM(t.jouerCarte(carte, joueur));
            t.getJoueurs().get(joueur).setPoints(t.getJoueurs().get(joueur).getPointsDM());
        }

    }
}
