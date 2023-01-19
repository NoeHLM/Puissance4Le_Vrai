import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
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
                    topscore();
                    break;
                case "q":
                    scan.close();
                    return;
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
        int score = 0;
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
            score++;
            Joueur.IA();
            if(Case.verifiyEgalite()== true){
                break;
            }    
        }
        if(Case.victoire == "0"){

            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
            try {
                score(Joueur.player1,score);
            } catch (IOException e) {
                
            }
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
        int scorep1 =0;
        int scorep2 =0;
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
                scorep1++;
            }else{
                Joueur.pions = Joueur.p2symbol;
                Joueur.couleurp = Joueur.couleurp2;
                tour = 1;
                scorep2++;
            }                       
            Joueur.placerCoin();
            Case.afficherGrill();
            if(Case.verifiyEgalite()== true){
                System.out.println("Egalité");
                break;
            }    
        }
        if(Case.victoire == "0"){
            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
            try {
                score(Joueur.player1, scorep1);
            } catch (Exception e) {
            }
        }else if(Case.victoire == "1"){
            System.out.println("\n\nl'équipe "+Joueur.player2+" à gagné\n");
            try {
                score(Joueur.player2, scorep2);
            } catch (Exception e) {
            }
        }   
        Case.victoire = null;
        Case.vc = false;

    }
   
    public static void score(String pseudo,int score) throws IOException{
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("joueur.csv", true)));
                
        try {
            pw.println(pseudo+";"+score+"\n");

        } 
        catch (Exception e) {
            System.out.println("error");
        }finally {
            pw.close();
        }
        
    }
    private static void topscore() throws IOException, ParseException {
        int i =0;
        ArrayList<Joueur> liste = Joueur.lister();
        Collections.sort(liste, (c1, c2) -> Integer.parseInt(c1.getNb_coups()) - Integer.parseInt(c2.getNb_coups()));
        System.out.println("\n------------------------\ntop joueur :");
            for (Joueur joueur : liste) {
                    if(i<10) {
                        System.out.println(+(i+1)+"    -    "+joueur.getPseudo() + " a fait " + joueur.getNb_coups()+ " coups");
                        i++;
                    }
            else{
                break;
            }
            
        }
    }
}