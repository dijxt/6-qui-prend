package appli;

import jeu.Carte;
import jeu.Joueur;
import jeu.Table;

import java.util.ArrayList;

public class Output {

    /**
     * Retourne le message de d�but de partie gr�ce � une liste de joueurs
     * @param joueurs la liste
     * @return le message
     */
    public static String messageDebut(ArrayList<String> joueurs) {
        String players = "";
        for (String e : joueurs) {
            if (e == joueurs.get(0)) {
                players = players + e;
            } else if (e == joueurs.get(joueurs.size() - 1)) {
                players = players + " et " + e;
            } else {
                players = players + ", " + e;
            }
        }
        return "Les " + String.valueOf(joueurs.size()) + " joueurs sont " + players + ". Merci de jouer � 6 qui prend !";
    }

    /**
     * Indique le prochain joueur qui doit jouer
     * @param joueur le joueur
     * @return le message
     */
    public static String tourJoueur(String joueur) {
        return "A " + joueur + " de jouer.";
    }

    /**
     * Met en forme une s�rie d'une liste de series avec son num�ro
     * @param serie    la liste
     * @param numSerie le num�ro
     * @return la s�rie
     */
    public static String afficherSerie(ArrayList<Carte> serie, int numSerie) {
        String cartes = "";
        for (Carte c : serie) {
            if (c == serie.get(0)) {
                cartes = cartes + c.toString();
            } else {
                cartes = cartes + ", " + c.toString();
            }
        }
        return "- s�rie n� " + String.valueOf(numSerie) + " : " + cartes;
    }

    /**
     * Indique les cartes qu'un joueur peut encore jouer
     * @param j le joueur
     * @return ses cartes
     */
    public static String cartesJoueur(Joueur j) {
        String cartes = "- Vos cartes : ";
        for (Carte c : j.getDeck()) {
            if (c == j.getDeck().get(0)) {
                cartes = cartes + c.toString();
            } else {
                cartes = cartes + ", " + c.toString();
            }
        }
        return cartes;
    }

    /**
     * Indique les cartes qui vont �tres pos�es au cours de la manche actuelle d'une table
     * @param t la table
     * @return les cartes
     */
    public static String cartesAJouer(Table t) {
        String cartes = "";
        for (Joueur j : t.getOrdreJoueur()) {
            if (j == t.getOrdreJoueur().get(0)) {
                cartes = cartes + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            } else if (j == t.getOrdreJoueur().get(t.getOrdreJoueur().size() - 1)) {
                cartes = cartes + " et " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            } else {
                cartes = cartes + ", " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            }
        }
        return "Les cartes " + cartes + " vont �tre pos�es.";
    }

    /**
     * Indique les cartes qui ont �t� pos�es au cours de la derni�re manche d'une table
     * @param t la table
     * @return les cartes
     */
    public static String cartesPosees(Table t) {
        String cartes = "";
        for (Joueur j : t.getOrdreJoueur()) {
            if (j == t.getOrdreJoueur().get(0)) {
                cartes = cartes + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            } else if (j == t.getOrdreJoueur().get(t.getOrdreJoueur().size() - 1)) {
                cartes = cartes + " et " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            } else {
                cartes = cartes + ", " + String.valueOf(j.getProchainCoup()) + " (" + j.nomJoueur() + ")";
            }
        }
        return "Les cartes " + cartes + " ont �t� pos�es.";
    }

    /**
     * Indique qui a ramass� des t�tes de boeufs au cour d'une manche
     * @param t
     * @return
     */
    public static String tetesDeBoeufs(Table t) {
        String message = "";
        for (int i = 0; i < t.getJoueurs().size(); ++i) {
            if (t.getJoueurs().get(i).getPointsDM() > 0) {
                if (message == "") {
                    if (t.getJoueurs().get(i).getPointsDM() == 1) {
                        message = t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " t�te de boeufs";
                    } else {
                        message = t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " t�tes de boeufs";
                    }
                } else {
                    if (t.getJoueurs().get(i).getPointsDM() == 1) {
                        message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " t�te de boeufs";
                    } else {
                        message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " t�tes de boeufs";
                    }
                }
            }
        }
        if (message == "") {
            message = "Aucun joueur ne ramasse de t�te de boeufs.";
        }
        return message;
    }

    /**
     * Donne les resultats de fin de partie d'une table
     * @param t la table
     * @return les resultats
     */
    public static String messageFin(Table t) {
        String message = "** Score final";
        t.getJoueurs().sort(Joueur::compareToNom); // ordre alphab�tique
        t.getJoueurs().sort(Joueur::compareToPoints); // ordre classement
        for (int i = 0; i < t.getJoueurs().size(); ++i) {
            if (t.getJoueurs().get(i).getPoints() > 1) {
                message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPoints()) + " t�tes de boeufs";
            } else {
                message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramass� " + String.valueOf(t.getJoueurs().get(i).getPoints()) + " t�te de boeufs";
            }

        }

        return message;
    }
}
