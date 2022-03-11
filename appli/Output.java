package appli;

import jeu.Carte;
import jeu.Joueur;
import jeu.Table;

import java.util.ArrayList;

public class Output {

    /**
     * Retourne le message de début de partie grâce à une liste de joueurs
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
        return "Les " + String.valueOf(joueurs.size()) + " joueurs sont " + players + ". Merci de jouer à 6 qui prend !";
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
     * Met en forme une série d'une liste de series avec son numéro
     * @param serie    la liste
     * @param numSerie le numéro
     * @return la série
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
        return "- série n° " + String.valueOf(numSerie) + " : " + cartes;
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
     * Indique les cartes qui vont êtres posées au cours de la manche actuelle d'une table
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
        return "Les cartes " + cartes + " vont être posées.";
    }

    /**
     * Indique les cartes qui ont été posées au cours de la dernière manche d'une table
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
        return "Les cartes " + cartes + " ont été posées.";
    }

    /**
     * Indique qui a ramassé des têtes de boeufs au cour d'une manche
     * @param t
     * @return
     */
    public static String tetesDeBoeufs(Table t) {
        String message = "";
        for (int i = 0; i < t.getJoueurs().size(); ++i) {
            if (t.getJoueurs().get(i).getPointsDM() > 0) {
                if (message == "") {
                    if (t.getJoueurs().get(i).getPointsDM() == 1) {
                        message = t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " tête de boeufs";
                    } else {
                        message = t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " têtes de boeufs";
                    }
                } else {
                    if (t.getJoueurs().get(i).getPointsDM() == 1) {
                        message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " tête de boeufs";
                    } else {
                        message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPointsDM()) + " têtes de boeufs";
                    }
                }
            }
        }
        if (message == "") {
            message = "Aucun joueur ne ramasse de tête de boeufs.";
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
        t.getJoueurs().sort(Joueur::compareToNom); // ordre alphabétique
        t.getJoueurs().sort(Joueur::compareToPoints); // ordre classement
        for (int i = 0; i < t.getJoueurs().size(); ++i) {
            if (t.getJoueurs().get(i).getPoints() > 1) {
                message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPoints()) + " têtes de boeufs";
            } else {
                message = message + "\n" + t.getJoueurs().get(i).nomJoueur() + " a ramassé " + String.valueOf(t.getJoueurs().get(i).getPoints()) + " tête de boeufs";
            }

        }

        return message;
    }
}
