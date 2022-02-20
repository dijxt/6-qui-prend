package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Table {
    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private ArrayList<Carte> pioche = new ArrayList<>();
    private ArrayList<ArrayList<Carte>> lisTab = new ArrayList<>();
    private ArrayList<Joueur> ordreJoueur = new ArrayList<>();

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

    public void poserCarte(int carte, int choix){
        int tete = 0;
        this.lisTab.get(choix).add(new Carte(carte));

        if (this.lisTab.get(choix).size() > 5){
            for (int i = 0; i < 5; ++i){
                tete = tete + this.lisTab.get(choix).get(i).getTete();
            }

            this.lisTab.get(choix).subList(0, 5).clear();
        }
    }
    public void jouerCarte(int carte, int joueur){
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
    }

    public void ordreJeu(){
        this.ordreJoueur = this.joueurs;
        this.ordreJoueur.sort(Joueur::compareTo);
    }

    public void remettreOrdre(){
        this.joueurs.sort(Joueur::compareToNum);
    }

    public ArrayList<Joueur> getOrdreJoueur() {
        return ordreJoueur;
    }

    public ArrayList<ArrayList<Carte>> getLisTab() {
        return lisTab;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}
