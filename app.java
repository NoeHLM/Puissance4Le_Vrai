
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.io.IOException;
import model.Case;
import java.io.FileWriter;

import model.Case;
import model.Joueur;

public class app {
    private static List<List<String>> test = new ArrayList<>();
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
    static String symbolp = null ;
    static String autour = null ;
    static String couleurp1 = "";
    static String couleurp2 = "";
    static String couleurp = "";
    static String pions = null;
    
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
        clearGrille();
        addGrill();
        afficherGrill();
        if (Joueur.p1color.equals("j")){
            couleurp1 = "\u001B[33m";
            
        }else{
            couleurp1 = "\u001B[31m";
        }
        if (Joueur.p2color.equals("j")){
            couleurp2 = "\u001B[33m";
        }else{
            couleurp2 = "\u001B[31m";
        }
        while(victoire == null){ 
            couleurp = couleurp1;
            pions = Joueur.p1symbol;                    
            placerCoin();
            IA();
            if(verifiyEgalite()== true){
                System.out.println("Egalité contre un bot");
                break;
            }    
        }
        if(victoire == "0"){
            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
        }else if(victoire == "1"){
            System.out.println("\n\nl'IA  à gagné\n");
        }
        victoire = null;
        vc = false;

    }

    public static void game1v1(){
        int tour = 1 ;
        Joueur.ajoutplayer1v1();
        clearGrille();
        addGrill();
        afficherGrill();
        if (Joueur.p1color.equals("j")){
            couleurp1 = "\u001B[33m";
        }else{
            couleurp1 = "\u001B[31m";
        }
        if (Joueur.p2color.equals("j")){
            couleurp2 = "\u001B[33m";
        }else{
            couleurp2 = "\u001B[31m";
        }
        while(victoire == null){ 
            if(tour == 1){
                pions = Joueur.p1symbol;
                couleurp = couleurp1;
                tour = 2;
            }else{
                pions = Joueur.p2symbol;
                couleurp = couleurp2;
                tour = 1;
            }                       
            placerCoin();
            afficherGrill();
            if(verifiyEgalite()== true){
                System.out.println("Egalité contre un bot");
                break;
            }    
        }
        if(victoire == "0"){
            System.out.println("\n\nl'équipe "+Joueur.player1+" à gagné\n");
        }else if(victoire == "1"){
            System.out.println("\n\nl'équipe "+Joueur.player2+" à gagné\n");
        }
        victoire = null;
        vc = false;

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

    public static void placerCoin(){      
        int index = 1;
        
        
        System.out.println("Choisissez une colonne");
        String rep = scan.nextLine();
        while(1 <= Integer.valueOf(rep) && Integer.valueOf(rep) >= 8){
            System.out.println("Choisissez une autre colonne");
            rep = scan.nextLine();
        }
        while(test.get(index).get(Integer.valueOf(rep)-1) == "_" && index < 6){                        
            index++;
        }
        try {
            while(test.get(index).get(Integer.valueOf(rep)-1) != "_"){
                index--;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        if(test.get(1).get(Integer.valueOf(rep)-1) == "_"){
            test.get(index).set(Integer.valueOf(rep)-1, couleurp + pions + "\u001B[0m");
        } else{
            System.out.println("Deja pris");
        }
        verifyLine(pions, couleurp);
        verifyColumn(pions, couleurp);
        verifyDiagoLeft(pions, couleurp);
        verifyDiagoRight(pions, couleurp);
    }

    public static void IA(){
        boolean z = false;
        do{
            int r = (int)(Math.random() * 7);
            int index = 1;
            while(test.get(index).get(r) == "_" && index < 6){                        
                index++;
            }
            try {
                while(test.get(index).get(r) != "_"){
                    index--;
                }
            } catch (IndexOutOfBoundsException e) {
            }
            if(test.get(1).get(r) == "_"){
                test.get(index).set(r,couleurp2+Joueur.p2symbol+"\u001B[0m");
                z = true;
            } else{
                z = false;
            }
        } while(z ==false);
        afficherGrill();
        verifyLine(Joueur.p2symbol, couleurp2);
        verifyColumn(Joueur.p2symbol, couleurp2);
        verifyDiagoLeft(Joueur.p2symbol, couleurp2);
        verifyDiagoRight(Joueur.p2symbol, couleurp2);
    }
}

    
