
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Case;
import model.Joueur;


import model.Joueur;

import java.io.FileWriter;
import java.util.Collections;

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
    private static Scanner scan = new Scanner(System.in);
    static String symbolp = null ;
    static String autour = null ;
    static String couleurp = "";
    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1": 

                    gameIA();
                    clearGrille();
                    while(verify() == false){
                        afficherGrill();
                        placerCoin();
                        IA();
                        if(verifiyEgalite() == true){
                            System.out.println("Equality");
                        }else if(verify() == true){
                            System.out.println("Nice game");
                        }
                    }
                    break;               
                case "2":
                    game1v1();
                    verifiyEgalite();    
                    break;
                case "3":
                    /*TopScore*/
                    topscore();
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
        String co = "j";
        
        int infini = 1;

        while(infini == 1){
            if(symbolejoueur == 1){
                symbolejoueur = 2;
                symbolp = Joueur.p1symbol;
                
                autour = "Joueur\t"+Joueur.player1+" choisissez une colonne";
                System.out.println(Joueur.p1color);
                if (Joueur.p1color.equals("j")){
                    couleurp = "\u001B[33m";
                }else{
                    couleurp = "\u001B[31m";
                }
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
                if (Joueur.p1color.equals("j")){
                    couleurp = "\u001B[33m";
                }else{
                    couleurp = "\u001B[31m";
                }
                placerCoin();

            }
            afficherGrill();
            if(symbolejoueur == 2){
                symbolejoueur = 1;
                symbolp = Joueur.p2symbol;
                autour = "Joueur\t"+Joueur.player2+" choisissez une colonne";
                if (Joueur.p2color.equals("j")){
                    couleurp = "\u001B[33m";
                }else{
                    couleurp = "\u001B[31m";
                }
                placerCoin();
                

            }
            afficherGrill();
        }   
        afficherGrill(); 
     

  

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
        boolean vc = false;
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

    public static boolean verify(){
        vv = false;
        try {
            for(int i = 6;i>1;i--){
                for(int j = 0;j<6;j++){
                    if(test.get(i).get(j) == "@"){
                        if(test.get(i-1).get(j) == "@"){
                            if(test.get(i-2).get(j) == "@"){
                                if(test.get(i-3).get(j) == "@"){
                                    vv = true;
                                }
                            }
                        } else if(test.get(i).get(j+1) == "@"){
                            if(test.get(i).get(j+2) == "@"){
                                if(test.get(i).get(j+3) == "@"){
                                    vv = true;
                                }
                            }
                        } else if(test.get(i-1).get(j+1) == "@"){
                            if(test.get(i-2).get(j+2) == "@"){
                                if(test.get(i-3).get(j+3) == "@"){
                                    vv = true;
                                }
                            }
                        } else if(test.get(i-1).get(j-1) == "@"){
                            if(test.get(i-2).get(j-2) == "@"){
                                if(test.get(i-3).get(j-3) == "@"){
                                    vv = true;
                                }
                            }
                        }
                    } else{
                        if(test.get(i).get(j) == "="){
                            if(test.get(i-1).get(j) == "="){
                                if(test.get(i-2).get(j) == "="){
                                    if(test.get(i-3).get(j) == "="){
                                        vv = true;
                                    }
                                }
                            } else if(test.get(i).get(j+1) == "="){
                                if(test.get(i).get(j+2) == "="){
                                    if(test.get(i).get(j+3) == "="){
                                        vv = true;
                                    }
                                }
                            } else if(test.get(i-1).get(j+1) == "="){
                                if(test.get(i-2).get(j+2) == "="){
                                    if(test.get(i-3).get(j+3) == "="){
                                        vv = true;
                                    }
                                }
                            } else if(test.get(i-1).get(j-1) == "="){
                                if(test.get(i-2).get(j-2) == "="){
                                    if(test.get(i-3).get(j-3) == "="){
                                        vv = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        return vv;
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
            test.get(index).set(Integer.valueOf(rep)-1, couleurp+symbolp+"\u001B[0m");
        } else{
            System.out.println("Deja pris");
        }

    }  

    

    private static void topscore() throws IOException {
            int i =0;
            ArrayList<Joueur> liste = Joueur.lister();
            Collections.sort(liste, (c1, c2) -> Integer.parseInt(c1.getNb_coups()) - Integer.parseInt(c2.getNb_coups()));
                for (Joueur joueur : liste) {
                        if(i<10) {
                        System.out.println(joueur.getPseudo() + " a fait " + joueur.getNb_coups()+ " coups");
                        i++;
                        }
                else{
                    break;
                }
                
            }
            
            
            
            
            

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
            if (Joueur.p2color.equals("j")){
            couleurp = "\u001B[33m";
            }else{
            couleurp = "\u001B[31m";
            }
            if(test.get(1).get(r) == "_"){
                test.get(index).set(r,couleurp+Joueur.p2symbol+"\u001B[0m");
                z = true;
            } else{
                z = false;
            }
        } while(z ==false);
    }

}
 