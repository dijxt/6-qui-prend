package jeu;

public class Game {
    public static void jouerCarte(Table t, int joueur){
        int carte = t.getJoueurs().get(joueur).getProchainCoup();
        t.getJoueurs().get(joueur).jposerCarte(carte);
        t.jouerCarte(carte, joueur);
    }

    public static void quiVaRamasser(Table t){
        for (int i = 0; i < t.getJoueurs().size(); ++i){
            if (t.getJoueurs().get(i).getDoitRamasser()){
                int serie = -1;
                serie = saisirSerie
                t.getJoueurs().get(i).setDoitRamasser();
            }
        }
    }
}
