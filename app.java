import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Case;
import java.io.FileWriter;

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
    private static Scanner scan = new Scanner(System.in);
    static String symbolp = null ;
    static String autour = null ;
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



    public static void gameIA() throws IOException {
        Joueur.ajoutplayeria();
        clearAllContact();
        afficherGrill();
        int symbolejoueur = 1 ;
        
        int infini = 1;

        while(infini == 1){
            if(symbolejoueur == 1){
                symbolejoueur = 2;
                symbolp = Joueur.p1symbol;
                autour = "Joueur\t"+Joueur.player1+" choisissez une colonne";
                placerCoin();
            }
            afficherGrill();
            if(symbolejoueur == 2){
                symbolejoueur = 1;
                symbolp = Joueur.p2symbol;
                IA();
            }
            afficherGrill();
        }   
        afficherGrill();
        
        Case.affichergrill();
    }
    public static void game1v1() throws IOException {
        
        clearAllContact();
        Joueur.ajoutplayer1v1();
        afficherGrill();
        int symbolejoueur = 1 ;
        
        int infini = 1;

        while(infini == 1){
            if(symbolejoueur == 1){
                symbolejoueur = 2;
                symbolp = Joueur.p1symbol;
                autour = "Joueur\t"+Joueur.player1+" choisissez une colonne";
                placerCoin();

            }
            afficherGrill();
            if(symbolejoueur == 2){
                symbolejoueur = 1;
                symbolp = Joueur.p2symbol;
                autour = "Joueur\t"+Joueur.player2+" choisissez une colonne";
                placerCoin();

            }
            afficherGrill();
        }   
        afficherGrill(); 
    
        
    }


    public static void clearAllContact(){
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

    public static void afficherGrill(){
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

        System.out.println(test.get(0).get(0));
        System.out.println("|" + test.get(1).get(0) + "|"+ test.get(1).get(1) + "|"+ test.get(1).get(2) + "|"+ test.get(1).get(3) + "|"+ test.get(1).get(4) + "|"+ test.get(1).get(5) + "|"+ test.get(1).get(6) + "|");
        System.out.println("|" + test.get(2).get(0) + "|"+ test.get(2).get(1) + "|"+ test.get(2).get(2) + "|"+ test.get(2).get(3) + "|"+ test.get(2).get(4) + "|"+ test.get(2).get(5) + "|"+ test.get(2).get(6) + "|");
        System.out.println("|" + test.get(3).get(0) + "|"+ test.get(3).get(1) + "|"+ test.get(3).get(2) + "|"+ test.get(3).get(3) + "|"+ test.get(3).get(4) + "|"+ test.get(3).get(5) + "|"+ test.get(3).get(6) + "|");
        System.out.println("|" + test.get(4).get(0) + "|"+ test.get(4).get(1) + "|"+ test.get(4).get(2) + "|"+ test.get(4).get(3) + "|"+ test.get(4).get(4) + "|"+ test.get(4).get(5) + "|"+ test.get(4).get(6) + "|");
        System.out.println("|" + test.get(5).get(0) + "|"+ test.get(5).get(1) + "|"+ test.get(5).get(2) + "|"+ test.get(5).get(3) + "|"+ test.get(5).get(4) + "|"+ test.get(5).get(5) + "|"+ test.get(5).get(6) + "|");
        System.out.println("|" + test.get(6).get(0) + "|"+ test.get(6).get(1) + "|"+ test.get(6).get(2) + "|"+ test.get(6).get(3) + "|"+ test.get(6).get(4) + "|"+ test.get(6).get(5) + "|"+ test.get(6).get(6) + "|");
    }

    public static void placerCoin(){      
        int index = 1;
        System.out.println(autour);
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
            test.get(index).set(Integer.valueOf(rep)-1, symbolp);
        } else{
            System.out.println("vous ne pouvez pas");
        }    

    }

    public static void IA(){
        int r = (int)(Math.random() * 8);
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
            test.get(index).set(r, Joueur.p2symbol);
            afficherGrill();
        } else{
            System.out.println("vous ne pouvez pas");
        }
    }

}
 