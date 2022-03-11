package appli;

import jeu.Carte;
import jeu.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static appli.Input.*;
import static appli.Output.*;

import static util.Console.*;


public class Application {
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

