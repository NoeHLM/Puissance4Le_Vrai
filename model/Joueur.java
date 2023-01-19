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
    public static ArrayList<Joueur> lister() throws IOException {
        // Initialisation de la liste qui va contenir les objets Joueur
        ArrayList<Joueur> list = new ArrayList<>();
        // Définition du séparateur utilisé dans le fichier csv
        String SEPARATEUR = ";";
        // Initialisation d'un BufferedReader pour lire le fichier csv
        BufferedReader buf = new BufferedReader(new FileReader("joueur.csv"));
        try {
            // Lecture de la première ligne du fichier
            String ligne = buf.readLine();
            // Boucle pour lire toutes les lignes du fichier
            while (ligne != null) {
                // Découpage de la ligne en utilisant le séparateur défini précédemment
                String[] tab = ligne.split(SEPARATEUR);
                // Création d'un objet Joueur
                Joueur j = new Joueur();
                // Définition du pseudo du joueur à partir de la première colonne du tableau
                j.setPseudo(tab[0]);
                // Définition du nombre de coups du joueur à partir de la deuxième colonne du tableau
                j.setNb_coups(tab[1]);
                
                // Ajout de l'objet Joueur à la liste
                list.add(j);
                // Lecture de la ligne suivante
                ligne = buf.readLine();
            }
        } catch (IOException e) {
            // Affichage d'un message d'erreur en cas de problème de lecture du fichier
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            // Fermeture du BufferedReader
            buf.close();
        }
        // Retour de la liste des joueurs
        return list;
    }
    

    public static void ajoutplayer() {
        // Initialisation d'un nouvel objet Joueur
        Joueur j = new Joueur();
        // Définition de la chaîne de caractères "red" pour la couleur rouge
        String red = "r";
        // Définition de la chaîne de caractères "@" pour le symbole
        String symb1 = "@";
    
        // Boucle qui s'exécute tant que les variables player1 et player2 sont nulles
        while(player1 == null || player2 == null){
            // Si player1 est null
            if (player1 == null){
                // Demande du nom du joueur 1
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                // Boucle pour demander la couleur du joueur 1
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
                // Boucle pour demander le symbole du joueur 1
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
            // Si player2 est null
            if (player2 == null){
                // Demande du nom du joueur 2
                System.out.println("Saisir le nom du joueur 2");
                j.setPseudo(scan.nextLine());
                player2 = j.getPseudo();  
                // Définition de la couleur du joueur 2 en fonction de la couleur du joueur 1
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                // Définition du symbole du joueur 2 en fonction du symbole du joueur 1
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }
    
            // Affichage des informations des joueurs

            System.out.println(" Le joueur : " +player1+ " a choisi la couleur "+p1color+" et le symbole "+p1symbol);
            System.out.println(" Le joueur : " +player2+ " a choisi la couleur "+p2color+" et le symbole "+p2symbol);
        }

    }

    

}

public static void ecrire(ArrayList<Joueur> liste) throws IOException {
    // Ouvrez le fichier en utilisant un BufferedWriter
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("joueur.csv"));
        // Boucle pour parcourir la liste de Joueur
        for (Joueur contact : liste) {
            try {
                // Ecriture des informations dans le fichier csv
                writer.write(contact.getPseudo() + ";" + contact.getNb_coups() + ";" + contact.getColor() + ";"
                        + contact.getSymbol() + "\n");
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    } finally {
        if (writer != null) {
            // Fermeture du BufferedWriter
            writer.close();
        }
    }
 }

 public static ArrayList<Joueur> top10(ArrayList<Joueur> liste) throws IOException{
    // Ouvrez le fichier en utilisant un BufferedReader
    BufferedReader buf = new BufferedReader(new FileReader("Joueur.csv"));
    // Définition du séparateur utilisé dans le fichier csv
    String SEPARATEUR = ";";
        try {
            // Lecture de la première ligne
            String ligne = buf.readLine();
            // Boucle pour lire les 10 premières lignes
            for (int i = 0; i < 10 ; i++) {
                // Split des informations de chaque ligne en utilisant le séparateur
                String[] tab = ligne.split(SEPARATEUR);
                Joueur c = new Joueur();
                // Ajout des informations dans un objet Joueur
                c.setPseudo(tab[0]);
                c.setNb_coups(tab[1]);
                // Ajout de l'objet Joueur à la liste
                liste.add(c);
                ligne = buf.readLine();
                // Affichage de la ligne
                System.out.println(ligne);
            }
        
        } catch (IOException e) {
            // Affichage d'un message d'erreur en cas de problème de lecture du fichier
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            // Fermeture du BufferedReader
            buf.close();
        }
        // Retour de la liste
        return liste;
 }


 public static void ajoutplayer1v1() {
    // Initialisation d'un nouvel objet Joueur
    Joueur j = new Joueur();
    // Définition de la chaîne de caractères "red" pour la couleur rouge
    String red = "r";
    // Définition de la chaîne de caractères "@" pour le symbole
    String symb1 = "@";

    // Boucle qui s'exécute tant que les variables player1 et player2 sont nulles
    while(player1 == null || player2 == null){
        // Si player1 est null
        if (player1 == null){
            // Demande du nom du joueur 1
            System.out.println("Saisir le nom du joueur 1");
            j.setPseudo(scan.nextLine());
            player1 = j.getPseudo();
            // Boucle pour demander la couleur du joueur 1
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
            // Boucle pour demander le symbole du joueur 1
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
        // Si player2 est null
        if (player2 == null){
            // Demande du nom du joueur 2
            System.out.println("Saisir le nom du joueur 2");
            j.setPseudo(scan.nextLine());
            player2 = j.getPseudo();  
            // Définition de la couleur du joueur 2 en fonction de la couleur du joueur 1
            if (p1color.equals(red)){
                p2color = "j";
            }  
            else{
                p2color = "r";
            }
            
            // Définition du symbole du joueur 2 en fonction du symbole du joueur 1
            if (p1symbol.equals(symb1)){
                p2symbol = "=";
            }  
            else{
                p2symbol = "@";
            }   
        }

        // Affichage des informations des joueurs

        System.out.println(" Le joueur : " +player1+ " a choisi la couleur "+p1color+" et le symbole "+p1symbol);
        System.out.println(" Le joueur : " +player2+ " a choisi la couleur "+p2color+" et le symbole "+p2symbol);
        }

    }

    public static void ajoutplayeria() {
        // Initialisation d'un nouvel objet Joueur
        Joueur j = new Joueur();
        // Définition de la chaîne de caractères "red" pour la couleur rouge
        String red = "r";
        // Définition de la chaîne de caractères "@" pour le symbole
        String symb1 = "@";
    
        // Boucle qui s'exécute tant que la variable player1 est null
        while(player1 == null){
            // Si player1 est null
            if (player1 == null){
                // Demande du nom du joueur 1
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                player2 = "ia";
                // Boucle pour demander la couleur du joueur 1
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
                // Boucle pour demander le symbole du joueur 1
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
            // Si player2 est "ia"
            if (player2 == "ia"){  
                // Définition de la couleur du joueur 2 en fonction de la couleur du joueur 1
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                // Définition du symbole du joueur 2 en fonction du symbole du joueur 1
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

