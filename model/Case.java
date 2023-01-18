
package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Case {
    public static final String SEPARATEUR = "|";
    public static String p1color;
    private String activesymbol;
    private String etat;
    public String getActivesymbol() {
        return activesymbol;
    }
    public void setActivesymbol(String activesymbol) {
        this.activesymbol = activesymbol;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void enregistrer() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("grille.csv", true)));
        try {
            pw.println(" 1 2 3 4 5 6 7");
            pw.println(this.toString());
            pw.println(this.toString());
            pw.println(this.toString());
            pw.println(this.toString());
            pw.println(this.toString());
            pw.println(this.toString());
        } finally {
            pw.close();
        }
    }

    public static void placeCoin() throws IOException{
        ArrayList<String> list = new ArrayList<>();
        BufferedReader buf = new BufferedReader(new FileReader("grille.csv"));
        try {
            String ligne = buf.readLine();
            String[] tab = ligne.split(SEPARATEUR);
            while(ligne != null){ 
                list.add(Arrays.toString(tab));       
                System.out.println(Arrays.toString(tab));
                ligne = buf.readLine();
                tab = ligne.split(SEPARATEUR);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } finally{
            buf.close();
        }
    }

    @Override
    public String toString() {
        // return this.getNom() + ";" + this.getPrenom();*
        StringBuilder build = new StringBuilder();
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        build.append(getActivesymbol());
        build.append(SEPARATEUR);
        return build.toString();
    }
    public static void affichergrill() throws IOException{
        BufferedReader buf = new BufferedReader(new FileReader("grille.csv"));
        try {
            String ligne = buf.readLine();
            while (ligne != null) {
                
            System.out.println(ligne);  
            ligne = buf.readLine();  
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            buf.close();
        }
    }
}
