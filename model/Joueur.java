package model;

public class Joueur {
    private String pseudo;
    private int nb_coups;
    private String color;
    private String symbol;
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public int getNb_coups() {
        return nb_coups;
    }
    public void setNb_coups(int nb_coups) {
        this.nb_coups = nb_coups;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
