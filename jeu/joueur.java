package jeu;

import java.util.ArrayList;

public class joueur {
    private String nom = ".";
    private int points = 0;
    private ArrayList<carte> deck = new ArrayList<>();
    private ArrayList<carte> ramasse = new ArrayList<>();

    public joueur(String nom){
        this.nom = nom;

    }

    public void prendreCarte(carte c){
        this.deck.add(c);
    }

    public void jposerCarte(carte c){
        this.points = this.points /*+ table.poserCarte(c)*/;
    }
}
