package appli;

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
                choixValide = t.getJoueurs().get(joueur).estDansPioche(coup);
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
