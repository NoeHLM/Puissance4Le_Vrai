import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Case;
import java.io.FileWriter;

import model.Joueur;

public class app {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    gameIA();
                    break;
                case "2":
                    game1v1();
                    
                    break;
                case "3":
                    /*TopScore*/
                    break;
                case "4":
                    /*Leave*/
                    break;
                default:
                    System.out.println("error");
                    break;
                }
            afficherMenu();
            }
    }

    public static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("------------------- MENU ---------------------");
        menus.add("----------------------------------------------");
        menus.add("1- Jouer contre l'IA");
        menus.add("2- Jouer contre un joueur");
        menus.add("3- Afficher les meilleurs scores");
        menus.add("q- Quitter");
        menus.add("----------------------------------------------");
        for (String s : menus) {
            System.out.println(s);
        }
    }


    public static void gameIA() throws IOException {
        clearAllContact();
        initialisergrille();
        Case.affichergrill();
    }
    public static void game1v1() throws IOException {
        clearAllContact();
        initialisergrille();
        Joueur.ajoutplayer();
        
        Case.affichergrill();
    }


    public static void clearAllContact(){
        try {
            FileWriter file = new FileWriter("grille.csv");
            file.write("");
            file.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void initialisergrille() {

        Case g = new Case();
        g.setActivesymbol("_");
        g.setEtat("neutral");
        try {
            g.enregistrer();
            System.out.println("Grille reinitialisé.");
        } catch (IOException e) {
            System.out.println("Erreur à l'enregistrement");
        }
    }  
}
 