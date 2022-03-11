package test;

import jeu.Carte;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class CarteTest {
    public static void main(String[] args) {
        // test tetes de boeufs
        for (int i = 1; i < 105; ++i){
            Carte c = new Carte(i);
            System.out.println(c.toString());
        }
        // test tri
        ArrayList<Carte> l = new ArrayList<>();
        Carte a = new Carte(25);
        Carte b = new Carte(55);
        l.add(b);
        l.add(a);
        l.sort(Carte::compareTo);
        assertTrue(l.get(0) == a && l.get(1) == b);
        // test tetes de boeuf
        assertEquals(2, a.getTete());
        assertEquals(7, b.getTete());
    }
}