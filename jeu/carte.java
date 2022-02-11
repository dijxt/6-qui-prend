package jeu;

public class carte {
    private int num = 0;
    private int tete = 0;

    public carte(int val){
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

    public int getNum() {
        return num;
    }

    public int getTete() {
        return tete;
    }
}
