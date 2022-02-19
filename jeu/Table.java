package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class table {
    private ArrayList<joueur> joueurs = new ArrayList<>();
    private ArrayList<carte> pioche = new ArrayList<>();
    private ArrayList<ArrayList<carte>> lisTab = new ArrayList<>();

    public table(ArrayList<String> listeNoms){
        // on initialise une pioche
        for (int i = 1; i < 105; ++i){
            this.pioche.add(new carte(i));
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
            this.joueurs.add(new joueur(p));
            for (int j = 0; j < 10; ++j){
                joueurs.get(numJoueur).prendreCarte(this.pioche.get(this.pioche.size() - 1));
                this.pioche.remove(this.pioche.size() - 1);
            }
            ++numJoueur;
        }
    }


    private int choixListe(carte c){
        int choix = -1;
        int diff = 105;

        for (int i = 0; i < 4; ++i){
            if(c.getNum() > this.lisTab.get(i).get(this.lisTab.get(i).size()).getNum()
                    && c.getNum() - this.lisTab.get(i).get(this.lisTab.get(i).size()).getNum() < diff)
            {
                choix = i;
                diff = c.getNum() - this.lisTab.get(i).get(this.lisTab.get(i).size()).getNum();
            }
        }

        return choix;
    }

    public int poserCarte(carte c){
        int choix = this.choixListe(c);
        int tete = 0;

        if (choix == -1){
            /*choix = scanner*/;
            for (int i = 0; i < this.lisTab.get(choix).size(); ++i){
                tete = tete + this.lisTab.get(choix).get(i).getTete();
            }
            for (int i = 0; i < this.lisTab.get(choix).size(); ++i){
                this.lisTab.get(choix).remove(0);
            }
            this.lisTab.get(choix).add(c);
        }
        else {
            this.lisTab.get(choix).add(c);

            if (this.lisTab.get(choix).size() < 5){
                for (int i = 0; i < 5; ++i){
                    tete = tete + this.lisTab.get(choix).get(i).getTete();
                }

                for (int i = 0; i < 5; ++i){
                    this.lisTab.get(choix).remove(0);
                }
            }
        }

        return tete;
    }

    public ArrayList<ArrayList<carte>> getLisTab() {
        return lisTab;
    }

    public ArrayList<joueur> getJoueurs() {
        return joueurs;
    }
}
