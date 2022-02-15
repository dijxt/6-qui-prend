package jeu;

import java.util.ArrayList;

public class joueur {
    private String nom = ".";
    private int points = 0;
    private ArrayList<carte> deck = new ArrayList<>();
    private int prochainCoup = 0;

    public joueur(String nom){
        this.nom = nom;

    }

    public void prendreCarte(carte c){
        this.deck.add(c);
    }

    public void jposerCarte(carte c){
        this.points = this.points /*+ table.poserCarte(c)*/;
    }


    public String nomJoueur() {
        return nom;
    }

    public ArrayList<carte> getDeck() {
        return deck;
    }

    public void setProchainCoup(int prochainCoup) {
        this.prochainCoup = prochainCoup;
    }

    public int getProchainCoup() {
        return prochainCoup;
    }
}
