package Appli;

import jeu.Carte;
import jeu.Table;

import java.util.Scanner;

public class Input {

    /**
     * Demande à un joueur de saisir une carte
     * @param t la table
     * @param joueur le joueur
     * @param sc entrée clavier
     * @return le coup saisi
     */
    public static int saisirChoix(Table t, int joueur, Scanner sc){
        System.out.print("Saisissez votre choix : ");
        boolean choixValide = false;
        int coup = 0;


        while (!choixValide) {
            String var = sc.next();
            try {
                coup = Integer.valueOf(var);
                for (Carte c : t.getJoueurs().get(joueur).getDeck()){ // On vérifie que le joueur possède la carte
                    if(c.getNum() == coup){
                        choixValide = true;
                    }
                }
                if (!choixValide){
                    System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
            }

        }

        return coup;
    }

    /**
     * Demande à un joueur de saisir une série
     * @param joueur le joueur
     * @param sc entrée clavier
     * @return la série saisie
     */
    public static int saisirSerie(int joueur, Scanner sc){
        System.out.print("Saisissez votre choix : ");
        boolean choixValide = false;
        int serie = 0;

        while (!choixValide) {
            String var = sc.next();
            try {
                int i = Integer.parseInt(var);
                serie = Integer.valueOf(var);
                if (serie > 0 && serie < 5){
                    choixValide = true;
                }
                if (!choixValide){
                    System.out.print("Saisissez votre choix : ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Saisissez votre choix : ");
            }

        }
        return serie;
    }
}
