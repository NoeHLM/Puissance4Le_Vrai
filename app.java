
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Case;
import model.Joueur;


import model.Joueur;

import java.io.FileWriter;
import java.util.Collections;


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
                    

                    /*1V1*/
                    clearAllContact();
                    initialisergrille();

                    break;
                case "3":
                    /*TopScore*/
                    topscore();
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

    

    private static void topscore() throws IOException {

            System.out.println("------------------------------------- \n ");
            System.out.println("Voici le tableau des scores : \n");
            int i =0;
            ArrayList<Joueur> liste = Joueur.lister();
            Collections.sort(liste, (c1, c2) -> Integer.parseInt(c1.getNb_coups()) - Integer.parseInt(c2.getNb_coups()));
                for (Joueur joueur : liste) {
                        if(i<10) {
                        System.out.println((i+1)+"    -    "+joueur.getPseudo() + " a fait " + joueur.getNb_coups()+ " coups");
                        i++;
                        }else{
                            break;
                        }
                        
            }
            
            System.out.println(" \n ");
            
            
            
    }

   

}
 