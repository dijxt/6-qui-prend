package Appli;
import jeu.table;
import Appli.InputOutput;
import util.Console.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Appli.InputOutput.*;
import static util.Console.clearScreen;
import static util.Console.pause;


public class Main {

    private static ArrayList<String> lireConfig(){
        try {
            // Prise en compte des joueurs;
            FileInputStream nomsJoueurs = new FileInputStream("config.txt");
            Scanner sc = new Scanner(nomsJoueurs);
            ArrayList<String> listeJoueurs = new ArrayList<>();
            while (sc.hasNext()) {
                listeJoueurs.add(sc.next());
            }
            sc.close();
            return listeJoueurs;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void serie(table t){
        for(int i = 0; i < lireConfig().size(); ++i){
            System.out.println(tourJoueur(t.getJoueurs().get(i).nomJoueur()));
            pause();
            for (int j = 0; i < 4; ++j){
                System.out.println(afficherSerie(t.getLisTab().get(j), j + 1));
            }
            t.getJoueurs().get(i).setProchainCoup(saisirChoix(t, i));
            clearScreen();
        }


    }

    private static void jouer(table t){
        for(int i = 0; i < 10; ++i){
            serie(t);
        }
    }

    public static void main (String[] args) {
        table t = new table(lireConfig());
        System.out.println(messageDebut(lireConfig()));
        jouer(t);

    }

}

