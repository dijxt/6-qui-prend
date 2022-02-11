package Appli;
import jeu.carte;
import util.Console.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;


public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream nomsJoueurs = new FileInputStream("config.txt");
            Scanner sc = new Scanner(nomsJoueurs);
            ArrayList<String> listeJoueurs = new ArrayList<>();
            while (sc.hasNext()) {
                listeJoueurs.add(sc.next());
            }
            for (String j : listeJoueurs){
                System.out.println(j);
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}

