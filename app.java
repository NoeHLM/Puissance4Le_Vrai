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
    /*
                                                main()
     La fonction main() déclare un objet Scanner nommé scan pour lire les entrées utilisateur. Il affiche ensuite
      un menu à l'utilisateur en appelant la fonction afficherMenu(). Ensuite, il entre dans une boucle infinie qui
       lit les choix de l'utilisateur. Selon le choix de l'utilisateur, il appelle les différentes fonctions
        correspondantes : gameia() pour un jeu contre l'IA, game1v1() pour un jeu en 1 contre 1, topscore() pour afficher
         les scores les plus élevés. Si l'utilisateur entre "q", la boucle s'arrête et la fonction retourne. Si l'utilisateur
          entre autre chose, un message d'erreur sera affiché. Après chaque choix, il affiche à nouveau le menu pour un nouveau choix.
     */
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
//--------------------------------------------------------
//                        gameia()
//  Elle déclare une variable score initialisée à zéro, puis appelle les méthodes ajoutplayeria(),
//   clearGrille(), addGrill() et afficherGrill() de la classe Joueur et Case respectivement. Ensuite,
//    elle vérifie la couleur des joueurs et les affecte à des variables, puis entre dans une boucle
//     while qui vérifie si la variable victoire est null. Dans cette boucle, la méthode placerCoin()
//      du joueur est appelée, suivie de la méthode IA(). Si la méthode verifiyEgalite() renvoie true,
//       la boucle s'arrête. Enfin, le résultat du jeu est affiché à l'utilisateur et la méthode score()
//        est appelée pour enregistrer le score
//--------------------------------------------------------


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
//---------------------------------------------------------------------------------------------------------------
 /**                                                 game1v1()
 * Cette méthode permet de lancer une partie à 2 joueurs.
 * Elle initialise les informations des joueurs en utilisant la méthode ajoutplayer1v1() de la classe Joueur.
 * Elle affiche ensuite le plateau de jeu avec la méthode afficherGrill().
 * Ensuite, elle utilise une boucle while pour permettre aux joueurs de jouer tour à tour.
 * Elle utilise une variable "symbolejoueur" pour savoir quel joueur doit jouer.
 * Elle utilise la méthode placerCoin() pour permettre aux joueurs de placer leurs symboles sur le plateau.
 * Elle termine en affichant à nouveau le plateau de jeu avec la méthode afficherGrill().
 */
//---------------------------------------------------------------------------------------------------------------

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
            pw.println(pseudo+";"+score);

        } 
        catch (Exception e) {
            System.out.println("error");
        }finally {
            pw.close();
        }
        
    }

    //--------------------------------------------------------------------------------------------------------
                                                //topscore()
    // Ce code définit la méthode privée statique "topscore" qui affiche les 10 meilleurs scores en utilisant les informations
//  de la classe Joueur. Il crée d'abord une liste de joueurs en utilisant la méthode statique "lister" de la classe Joueur.
//   Ensuite, il trie la liste par ordre croissant en fonction du nombre de coups de chaque joueur. Enfin, Il utilise une
//    boucle "for" pour parcourir la liste des joueurs et affiche le pseudo et le nombre de coups de chaque joueur si i est
//     inférieur à 10, et quitte la boucle sinon.
    //--------------------------------------------------------------------------------------------------------

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