package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur implements Comparable<Joueur>{
    private String nom = "";
    private int points = 0;
    private ArrayList<Carte> deck = new ArrayList<>();
    private int prochainCoup = 0;
    private int numJoueur = -1;
    private int pointsDM = 0;

    /**
     * Constructeur de la classe, cr�e un joueur
     * @param nom son nom
     * @param numJoueur son num�ro
     */
    public Joueur(String nom, int numJoueur){
        this.nom = nom;
        this.numJoueur = numJoueur;
    }

    /**
     * Tri les cartes d'un joueur
     */
    public void trierDeck(){
        Collections.sort(this.deck);
    }

    /**
     * ajoute une carte au deck
     * @param c la carte
     */
    public void prendreCarte(Carte c){
        this.deck.add(c);
    }

    /**
     * pose une carte
     * @param carte la carte
     */
    public void jposerCarte(int carte){
        for(int i = 0; i < deck.size(); ++i){
            if (deck.get(i).getNum() == carte){
                deck.remove(i);
            }
        }
    }

    /**
     *
     */
    public boolean estDansPioche(int carte){
        boolean choixValide = false;
        for (Carte c : this.deck){ // On v�rifie que le joueur poss�de la carte
            if(c.getNum() == carte){
                choixValide = true;
            }
        }
        return choixValide;
    }

    /**
     * Renvoie le nom du joueur
     * @return le nom
     */
    public String nomJoueur() {
        return nom;
    }

    /**
     * Renvoie les cartes du joueur
     * @return les cartes
     */
    public ArrayList<Carte> getDeck() {
        return deck;
    }

    /**
     * D�finie le prochain coup du joueur
     * @param prochainCoup le num�ro de carte
     */
    public void setProchainCoup(int prochainCoup) {
        this.prochainCoup = prochainCoup;
    }

    /**
     * Renvoie le num�ro de la prochaine carte � jouer
     * @return le num�ro
     */
    public int getProchainCoup() {
        return prochainCoup;
    }

    /**
     * Ajoute des points
     * @param points le nombre de points
     */
    public void setPoints(int points) {
        this.points = this.points + points;
    }

    /**
     * Renvoie le nombre de points du joueur
     * @return les points
     */
    public int getPoints() {
        return points;
    }

    /**
     * D�finie les points pris sur une manche
     * @param pointsDM les points
     */
    public void setPointsDM(int pointsDM) {
        this.pointsDM = pointsDM;
    }

    /**
     * Renvoie le nombre de points pris sur une manche
     * @return les points
     */
    public int getPointsDM() {
        return pointsDM;
    }

    /**
     * Comparateur qui permet de trier l'ordre de passage
     * @param o l'objet � comparer
     * @return une valeur de comparaison
     */
    @Override
    public int compareTo(Joueur o) {
        return (this.prochainCoup - o.prochainCoup);
    }

    /**
     * Comparateur qui permet de remettre en ordre les joueurs
     * @param o l'objet � comparer
     * @return une valeur de comparaison
     */
    public int compareToNum(Joueur o){
        return (this.numJoueur - o.numJoueur);
    }

    /**
     * Comparateur qui permet de trier l'ordre des r�sultats
     * @param o l'objet � comparer
     * @return une valeur de comparaison
     */
    public int compareToPoints(Joueur o){
        return (this.points - o.points);
    }

    /**
     * Comparateur qui permet de trier l'ordre des t�tes de boeuf
     * @param o l'objet � comparer
     * @return une valeur de comparaison
     */
    public int compareToPointsManche(Joueur o){
        return (this.pointsDM - o.pointsDM);
    }

    /**
     * Comparateur qui permet de trier l'ordre des r�sultats par nom
     * @param o l'objet � comparer
     * @return une valeur de comparaison
     */

    public int compareToNom(Joueur o){
        return (this.nom.compareTo(o.nom));
    }
}
