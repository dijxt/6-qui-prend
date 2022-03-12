package test;

import jeu.Carte;
import jeu.Joueur;

import static org.junit.Assert.*;

public class JoueurTest {
    public static void main(String[] args) {
        // test constructeur
        Joueur j = new Joueur("test", 0);
        // test ajout de carte
        j.prendreCarte(new Carte(3));
        j.prendreCarte(new Carte(2));
        //test comparaison carte
        assertTrue(j.estDansPioche(2));
        // test tri de cartes
        j.trierDeck();
        assertEquals(j.getDeck().get(0).getNum(), 2);
        // test poser une carte
        j.jposerCarte(2);
        assertEquals(j.getDeck().get(0).getNum(), 3);
        j.jposerCarte(3);
        assertTrue(j.getDeck().isEmpty());
    }
}