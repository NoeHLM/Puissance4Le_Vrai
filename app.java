import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

import model.Case;
import model.Joueur;

public class app {
        
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1": 
                
                    gameia();
                    
                    break;               
                case "2":
                    game1v1();    
                    break;
                case "3":
                    /*TopScore*/
                    break;
                case "q":
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

    public static void gameia(){
                
        Joueur.ajoutplayeria();
        Case.clearGrille();
        Case.addGrill();
        Case.afficherGrill();
        if (Joueur.p1color.equals("j")){
            Joueur.couleurp1 = "\u001B[33m";
            
        }else{
            Joueur.couleurp1 = "\u001B[31m";
        }
        if (Joueur.p2color.equals("j")){
            Joueur.couleurp2 = "\u001B[33m";
        }else{
            Joueur.couleurp2 = "\u001B[31m";
        }
        while(Case.victoire == null){ 
            Joueur.couleurp = Joueur.couleurp1;
            Joueur.pions = Joueur.p1symbol;                    
            Joueur.placerCoin();
            Joueur.IA();
            if(Case.verifiyEgalite()== true){
                break;
            }    
        }
        if(Case.victoire == "0"){
            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
        }else if(Case.victoire == "1"){
            System.out.println("\n\nl'IA  à gagné\n");
        }else{
            System.out.println("Egalité contre un bot");
        }
        Case.victoire = null;
        Case.vc = false;

    }

    public static void game1v1(){
        int tour = 1 ;
        Joueur.ajoutplayer1v1();
        Case.clearGrille();
        Case.addGrill();
        Case.afficherGrill();
        if (Joueur.p1color.equals("j")){
            Joueur.couleurp1 = "\u001B[33m";
        }else{
            Joueur.couleurp1 = "\u001B[31m";
        }
        if (Joueur.p2color.equals("j")){
            Joueur.couleurp2 = "\u001B[33m";
        }else{
            Joueur.couleurp2 = "\u001B[31m";
        }
        while(Case.victoire == null){ 
            if(tour == 1){
                Joueur.pions = Joueur.p1symbol;
                Joueur.couleurp = Joueur.couleurp1;
                tour = 2;
            }else{
                Joueur.pions = Joueur.p2symbol;
                Joueur.couleurp = Joueur.couleurp2;
                tour = 1;
            }                       
            Joueur.placerCoin();
            Case.afficherGrill();
            if(Case.verifiyEgalite()== true){
                System.out.println("Egalité contre un bot");
                break;
            }    
        }
        if(Case.victoire == "0"){
            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
        }else if(Case.victoire == "1"){
            System.out.println("\n\nl'équipe "+Joueur.player2+" à gagné\n");
        }
        Case.victoire = null;
        Case.vc = false;

    }

    public static void clearAll(){
        try {
            FileWriter file = new FileWriter("grille.csv");
            file.write("");
            file.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }    
}