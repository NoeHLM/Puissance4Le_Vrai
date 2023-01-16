import java.util.ArrayList;
import java.util.Scanner;

public class app {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    /*1VIA*/
                    break;
                case "2":
                    /*1V1*/
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
            }
    }

    public static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("------------------- MENU ---------------------");
        menus.add("----------------------------------------------");
        menus.add("1- Jouer contre l'IA");
        menus.add("2- Jouer contre un joueur");
        menus.add("2- Afficher les meilleurs scores");
        menus.add("q- Quitter");
        menus.add("----------------------------------------------");
        for (String s : menus) {
            System.out.println(s);
        }
    }
}

