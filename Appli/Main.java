package Appli;

import jeu.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Appli.Output.*;
import static Appli.Game.jouerCarte;
import static Appli.Input.saisirChoix;

import static util.Console.clearScreen;
import static util.Console.pause;


public class Main {
    /**
     * Lit un fichier texte pour en extraire les joueurs de la partie.
     * @return Une liste de joueurs.
     */
    private static ArrayList<String> lireConfig(){
        try {
            // Prise en compte des joueurs
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
            System.exit(0);
        }
        return new ArrayList<>();
    }


    /**
     * Joue une manche, demande à chaque joueur de poser une carte
     * @param t la table
     * @param sc scanner d'entrées clavier
     */
    private static void manche(Table t, Scanner sc){
        for(int i = 0; i < lireConfig().size(); ++i){
            System.out.println(tourJoueur(t.getJoueurs().get(i).nomJoueur())); // appel du joueur
            pause();
            for (int j = 0; j < 4; ++j){ // affichage des séries en cours
                System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
            }
            System.out.println(cartesJoueur(t.getJoueurs().get(i))); // cartes du joueur
            t.getJoueurs().get(i).setProchainCoup(saisirChoix(t, i, sc)); // saisie de carte
            clearScreen();
        }
        t.ordreJeu(); // tri des cartes à jouer par ordre croissant
        for(int i = 0; i < lireConfig().size(); ++i){ // pose les cartes
            jouerCarte(t, i, sc);
        }
        System.out.println(cartesPosees(t));
        for (int j = 0; j < 4; ++j){
            System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
        }
        t.ordreTetes();
        System.out.println(tetesDeBoeufs(t)); // joueurs ayant ramassés
        t.remettreOrdre();
    }



    public static void main (String[] args) {
        Table t = new Table(lireConfig()); // on initialise une partie
        Scanner sc = new Scanner(System.in);
        System.out.println(messageDebut(lireConfig())); // annonce joueurs
        for(int i = 0; i < 10; ++i){
            manche(t, sc); // on joue 10 manches
        }
        System.out.println(messageFin(t)); // score
        sc.close();
    }

}

