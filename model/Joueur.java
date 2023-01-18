package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;


public class Joueur {
    private String pseudo;
    private String nb_coups;
    private String color;
    private String symbol;
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getNb_coups() {
        return nb_coups;
    }
    public void setNb_coups(String nb_coups) {
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
    public static ArrayList<Joueur> lister() throws IOException {
        
    ArrayList<Joueur> list = new ArrayList<>();
    String SEPARATEUR = ";";
    BufferedReader buf = new BufferedReader(new FileReader("joueur.csv"));
    try {
        String ligne = buf.readLine();
        while (ligne != null) {
            String[] tab = ligne.split(SEPARATEUR);
            Joueur j = new Joueur();
            j.setPseudo(tab[0]);
            j.setNb_coups(tab[1]);
            j.setColor(tab[2]);
            j.setSymbol(tab[3]);
            
            list.add(j);
            ligne = buf.readLine();
        }
    } catch (IOException e) {
        System.out.println("Erreur de lecture sur le fichier");
    } finally {
        buf.close();
    }
    return list;

}

public static void ecrire(ArrayList<Joueur> liste) throws IOException {
    // Ouvrez le fichier en utilisant un BufferedWriter
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("joueur.csv"));
        for (Joueur contact : liste) {
            try {
                writer.write(contact.getPseudo() + ";" + contact.getNb_coups() + ";" + contact.getColor() + ";"
                        + contact.getSymbol() + "\n");
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    } finally {
        if (writer != null) {
            writer.close();
        }
    }
 }
 public static ArrayList<Joueur> top10(ArrayList<Joueur> liste) throws IOException{
    BufferedReader buf = new BufferedReader(new FileReader("Joueur.csv"));
    String SEPARATEUR = ";";
        try {
            String ligne = buf.readLine();
            for (int i = 0; i < 10 ; i++) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueur c = new Joueur();
                c.setPseudo(tab[0]);
                c.setNb_coups(tab[1]);
                liste.add(c);
                ligne = buf.readLine();
                System.out.println(ligne);
            }
        
        } catch (IOException e) {
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            buf.close();
        }
        return liste;
 }

}

