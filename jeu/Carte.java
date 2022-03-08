package jeu;

public class Carte implements Comparable<Carte>{
    private int num = 0;
    private int tete = 0;

    /**
     * Constructeur de la classe, crée une carte selon les règles du jeu
     * @param val le numéro de carte
     */
    public Carte(int val){
        this.num = val;
        if (val == 55){
            this.tete = 7;
        }
        else if ((val + 5) % 10 == 0){
            this.tete = 2;
        }
        else if (val % 10 == 0){
            this.tete = 3;
        }
        else if (val % 11 == 0){
            this.tete = 5;
        }
        else{
            this.tete = 1;
        }
    }

    /**
     * Comparateur qui permet de trier des cartes
     * @param o objet à comparer
     * @return une valeur de comparaison
     */
    @Override
    public int compareTo(Carte o) {
        return (this.num - o.num);
    }

    /**
     * Renvoie le numéro d'une carte
     * @return le numéro
     */
    public int getNum() {
        return num;
    }

    /**
     * Renvoie le nombre de têtes de boeufs d'une carte
     * @return le nombre
     */
    public int getTete() {
        return tete;
    }

    /**
     * Renvoie une carte
     * @return la carte
     */
    @Override
    public String toString() {
        if (this.tete > 1){
            return this.num + " (" + this.tete + ")";
        }
        else{
            return String.valueOf(this.num);
        }
    }
}
