package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Table {
    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private ArrayList<Carte> pioche = new ArrayList<>();
    private ArrayList<ArrayList<Carte>> lisTab = new ArrayList<>();
    private ArrayList<Joueur> ordreJoueur = new ArrayList<>();

    /**
     * Constructeur de la classe table, initialise une partie avec une liste de joueurs
     * @param listeNoms les joueurs
     */
    public Table(ArrayList<String> listeNoms){
        // on vérifie que l'on a le bon nombre de joueurs
        assert(listeNoms.size() > 1 && listeNoms.size() < 11);

        // on initialise une pioche
        for (int i = 1; i < 105; ++i){
            this.pioche.add(new Carte(i));
        }

        // on mélange la pioche
        Collections.shuffle(this.pioche);

        // on attribue la première carte de chaque liste
        for (int i = 0; i < 4; ++i){
            this.lisTab.add(new ArrayList<>());
            this.lisTab.get(i).add(this.pioche.get(this.pioche.size() - 1));
            this.pioche.remove(this.pioche.size() - 1);
        }


        // on donne à chaque joueur 10 cartes

        int numJoueur = 0;
        for (String p : listeNoms){
            this.joueurs.add(new Joueur(p, numJoueur));
            for (int j = 0; j < 10; ++j){
                joueurs.get(numJoueur).prendreCarte(this.pioche.get(this.pioche.size() - 1));
                this.pioche.remove(this.pioche.size() - 1);
            }
            joueurs.get(numJoueur).trierDeck();
            ++numJoueur;
        }
    }

    /**
     * Choisit la série sur laquelle une carte doit être posée
     * @param c la carte
     * @return un numéro de série
     */
    public int choixListe(int c){
        int choix = -1;
        int diff = 105;

        for (int i = 0; i < 4; ++i){
            if(c > this.lisTab.get(i).get(this.lisTab.get(i).size() - 1).getNum()
                    && c - this.lisTab.get(i).get(this.lisTab.get(i).size() - 1).getNum() < diff)
            {
                choix = i;
                diff = c - this.lisTab.get(i).get(this.lisTab.get(i).size() - 1).getNum();
            }
        }

        return choix;
    }

    /**
     * Joue une carte d'un joueur sur la table
     * @param carte la carte
     * @param joueur le joueur
     * @return le nombre de têtes de b?ufs devant êtres ramassés
     */
    public int jouerCarte(int carte, int joueur){
        int choix = this.choixListe(carte);
        int tete = 0;

        if (choix == -1){}
        else {
            this.lisTab.get(choix).add(new Carte(carte));

            if (this.lisTab.get(choix).size() > 5){
                for (int i = 0; i < 5; ++i){
                    tete = tete + this.lisTab.get(choix).get(i).getTete();
                }

                this.lisTab.get(choix).subList(0, 5).clear();
            }
        }
        return tete;
    }

    /**
     * Tri les joueur par rapport à l'ordre des cartes d'une manche
     */
    public void ordreJeu(){
        this.ordreJoueur = this.joueurs;
        this.ordreJoueur.sort(Joueur::compareTo);
    }

    /**
     * Remet les joueurs à leur ordre initial
     */
    public void remettreOrdre(){
        this.joueurs.sort(Joueur::compareToNum);
    }

    /**
     * Renvoie une liste de joueurs ordonnés
     * @return la liste
     */
    public ArrayList<Joueur> getOrdreJoueur() {
        return ordreJoueur;
    }

    /**
     * Renvoie les séries
     * @return les séries
     */
    public ArrayList<ArrayList<Carte>> getLisTab() {
        return lisTab;
    }

    /**
     * Renvoie les joueurs
     * @return les joueurs
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}
