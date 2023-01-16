
package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Case {
    public static final String SEPARATEUR = "|";
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
}
