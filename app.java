import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import model.Case;
import java.io.FileWriter;

import model.Case;

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
    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1": 
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
                    /*1V1*/
                    afficherGrill();
                    verifiyEgalite();    
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
            test.get(index).set(Integer.valueOf(rep)-1, "@");
        } else{
            System.out.println("Deja pris");
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
            if(test.get(1).get(r) == "_"){
                test.get(index).set(r, "=");
                z = true;
            } else{
                z = false;
            }
        } while(z ==false);
    }
}

    