package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur implements Comparable<Joueur>{
    private String nom = ".";
    private int points = 0;
    private ArrayList<Carte> deck = new ArrayList<>();
    private int prochainCoup = 0;
    private int numJoueur = -1;
    private boolean doitRamasser = false;

    public Joueur(String nom, int numJoueur){
        this.nom = nom;
        this.numJoueur = numJoueur;
    }

    public void trierDeck(){
        Collections.sort(this.deck);
    }

    public void prendreCarte(Carte c){
        this.deck.add(c);
    }

    public void jposerCarte(int carte){
        for(int i = 0; i < deck.size(); ++i){
            if (deck.get(i).getNum() == carte){
                deck.remove(i);
            }
        }
    }

    public String nomJoueur() {
        return nom;
    }

    public ArrayList<Carte> getDeck() {
        return deck;
    }

    public void setProchainCoup(int prochainCoup) {
        this.prochainCoup = prochainCoup;
    }

    public int getProchainCoup() {
        return prochainCoup;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }

    public void setDoitRamasser(boolean doitRamasser) {
        this.doitRamasser = doitRamasser;
    }

    public boolean getDoitRamasser(){
        return doitRamasser;
    }

    @Override
    public int compareTo(Joueur o) {
        return (this.prochainCoup - o.prochainCoup);
    }

    public int compareToNum(Joueur o){
        return (this.numJoueur - o.numJoueur);
    }
}
