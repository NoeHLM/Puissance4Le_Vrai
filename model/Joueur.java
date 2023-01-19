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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Joueur {
    private static Scanner scan = new Scanner(System.in);
    private String pseudo;
    private String nb_coups;
    private String color;
    private String symbol;
    public static String player1 = null;
    public static String player2 = null;
    public static String p1color = null;
    public static String p2color= null;
    public static String p1symbol = null;
    public static String p2symbol= null;


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
    public void setColor(String color) throws ParseException {
        Pattern pat = Pattern.compile("j");
        Pattern pat2 = Pattern.compile("r");
        Matcher test = pat.matcher(color);
        Matcher test2 = pat2.matcher(color);
        if (test.matches()) {
            this.color = color;
        }
        else if(test2.matches()){
            this.color = color;

        } else {
            throw new ParseException("la couleur est incorrect.", 0);
        }

    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) throws ParseException {
        Pattern pat = Pattern.compile("@");
        Pattern pat2 = Pattern.compile("=");
        Matcher test = pat.matcher(symbol);
        Matcher test2 = pat2.matcher(symbol);
        if (test.matches()) {
            this.symbol = symbol;
        }
        else if(test2.matches()){
            this.symbol = symbol;

        } else {
            throw new ParseException("le symbole est incorrect.", 0);
        }
        
    }
    public static ArrayList<Joueur> lister() throws IOException, ParseException {
        
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

    public static void ajoutplayer() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null || player2 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);

                
            }
            if (player2 == null){
                System.out.println("Saisir le nom du joueur 2");
                j.setPseudo(scan.nextLine());
                player2 = j.getPseudo();  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }

            System.out.println(player1);
            System.out.println(player2);
            System.out.println(p1color);
            System.out.println("la couleur du joueur 2 est "+""+p2color);
            System.out.println(p1symbol);
            System.out.println(p2symbol);
        }

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


 
    public static void ajoutplayeria() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                player2 = "ia";
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);   
            }
            if (player2 == "ia"){  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }

    

        }
    }

    public static void ajoutplayer1v1() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null || player2 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);

                
            }
            if (player2 == null){
                System.out.println("Saisir le nom du joueur 2");
                j.setPseudo(scan.nextLine());
                player2 = j.getPseudo();  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }
        }

    }
}

