
package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Case {
    public static List<List<String>> test = new ArrayList<>();
    private static List<String> ligneIndex = new ArrayList<>();
    private static List<String> ligne1 = new ArrayList<>();
    private static List<String> ligne2 = new ArrayList<>();
    private static List<String> ligne3 = new ArrayList<>();
    private static List<String> ligne4 = new ArrayList<>();
    private static List<String> ligne5 = new ArrayList<>();
    private static List<String> ligne6 = new ArrayList<>();
    public static boolean vv = false;
    public static boolean vc = false;
    public static String victoire = null;
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
            pw.println("1 2 3 4 5 6 7");
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

    public static void addGrill(){
        ligneIndex.add(" 1 2 3 4 5 6 7");
        for(int i=0; i<7;i++){
            ligne1.add("_");
            ligne2.add("_");
            ligne3.add("_");
            ligne4.add("_");
            ligne5.add("_");
            ligne6.add("_");
        }
        test.add(ligneIndex);
        test.add(ligne1);
        test.add(ligne2);
        test.add(ligne3);
        test.add(ligne4);
        test.add(ligne5);
        test.add(ligne6);
    }

    public static void afficherGrill(){
        System.out.println(test.get(0).get(0));
        System.out.println("|" + test.get(1).get(0) + "|"+ test.get(1).get(1) + "|"+ test.get(1).get(2) + "|"+ test.get(1).get(3) + "|"+ test.get(1).get(4) + "|"+ test.get(1).get(5) + "|"+ test.get(1).get(6) + "|");
        System.out.println("|" + test.get(2).get(0) + "|"+ test.get(2).get(1) + "|"+ test.get(2).get(2) + "|"+ test.get(2).get(3) + "|"+ test.get(2).get(4) + "|"+ test.get(2).get(5) + "|"+ test.get(2).get(6) + "|");
        System.out.println("|" + test.get(3).get(0) + "|"+ test.get(3).get(1) + "|"+ test.get(3).get(2) + "|"+ test.get(3).get(3) + "|"+ test.get(3).get(4) + "|"+ test.get(3).get(5) + "|"+ test.get(3).get(6) + "|");
        System.out.println("|" + test.get(4).get(0) + "|"+ test.get(4).get(1) + "|"+ test.get(4).get(2) + "|"+ test.get(4).get(3) + "|"+ test.get(4).get(4) + "|"+ test.get(4).get(5) + "|"+ test.get(4).get(6) + "|");
        System.out.println("|" + test.get(5).get(0) + "|"+ test.get(5).get(1) + "|"+ test.get(5).get(2) + "|"+ test.get(5).get(3) + "|"+ test.get(5).get(4) + "|"+ test.get(5).get(5) + "|"+ test.get(5).get(6) + "|");
        System.out.println("|" + test.get(6).get(0) + "|"+ test.get(6).get(1) + "|"+ test.get(6).get(2) + "|"+ test.get(6).get(3) + "|"+ test.get(6).get(4) + "|"+ test.get(6).get(5) + "|"+ test.get(6).get(6) + "|");
    }

    public static void clearGrille(){
        test.clear();
        for(int i=0; i<7;i++){
            ligne1.clear();
            ligne2.clear();
            ligne3.clear();
            ligne4.clear();
            ligne5.clear();
            ligne6.clear();
        }
        for(int i =0;i<7;i++){}
        test.add(ligneIndex);
        test.add(ligne1);
        test.add(ligne2);
        test.add(ligne3);
        test.add(ligne4);
        test.add(ligne5);
        test.add(ligne6);
    }

    public static boolean verifiyEgalite(){
        
        List<String> column1 = new ArrayList<>();
        List<String> column2 = new ArrayList<>();
        List<String> column3 = new ArrayList<>();
        List<String> column4 = new ArrayList<>();
        List<String> column5 = new ArrayList<>();
        List<String> column6 = new ArrayList<>();
        List<String> column7 = new ArrayList<>();
        for(int i = 1;i<7;i++){
            column1.add(test.get(i).get(0));
            column2.add(test.get(i).get(1));
            column3.add(test.get(i).get(2));
            column4.add(test.get(i).get(3));
            column5.add(test.get(i).get(4));
            column6.add(test.get(i).get(5));
            column7.add(test.get(i).get(6));
        }
        if(!column1.contains("_") && !column1.contains("_") && !column2.contains("_") && !column3.contains("_") && !column4.contains("_") && !column5.contains("_") && !column6.contains("_") && !column7.contains("_")){
            vc = true;
        }

        return vc;

    }

    public static String verifyLine(String Symbolpions,  String couleurpions){
        
            
            try {
                if((test.get(6).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(6).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(6).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }
                
                } else if((test.get(5).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                } else if((test.get(4).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }else if((test.get(3).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }else if((test.get(2).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                } else if((test.get(1).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(1).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(1).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        
        
        return victoire;
        
    }

    public static String verifyColumn(String Symbolpions, String couleurpions){
        
        
        
            try {
                if((test.get(1).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(0).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(2).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(0).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(3).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(0).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }
                
                } else if((test.get(1).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(1).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                } else if((test.get(1).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(2).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }else if((test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }else if((test.get(1).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(4).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                } else if((test.get(1).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(5).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                } else if((test.get(1).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(6).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(2).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(6).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
                (test.get(3).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(6).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                    if(Symbolpions.equals(Joueur.p1symbol)){
                        victoire = "0";
                    }else{
                        victoire="1";
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        
        
        return victoire;
    }

    public static String verifyDiagoRight(String Symbolpions, String couleurpions){
        try {
            if((test.get(4).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(5).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(4).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(0).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) || 
            (test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(5).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m")) || 
            (test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(6).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }
        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        return victoire;
    }

    public static String verifyDiagoLeft(String Symbolpions, String couleurpions){
        try {
            if((test.get(6).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(0).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(4).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(3).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(0).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(5).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(4).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(2).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m")) || 
            (test.get(4).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(1).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(0).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }else if((test.get(6).get(6).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m")) ||
            (test.get(5).get(5).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m")) || 
            (test.get(4).get(4).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(3).get(3).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(2).get(2).equals( couleurpions + Symbolpions + "\u001B[0m") && test.get(1).get(1).equals( couleurpions + Symbolpions + "\u001B[0m"))){
                if(Symbolpions.equals(Joueur.p1symbol)){
                    victoire = "0";
                }else{
                    victoire="1";
                }            
            }
        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        return victoire;
    }
    
}
