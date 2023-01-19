
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
        // Appel de la méthode ajoutplayeria() pour ajouter un joueur et une IA
        Joueur.ajoutplayeria();
        
        // Appel de la méthode afficherGrill() pour afficher le plateau de jeu
        afficherGrill();
        
        // Initialisation de la variable symbolejoueur à 1 pour définir le joueur qui joue
        int symbolejoueur = 1 ;
        // Initialisation de la variable co à "j" pour la couleur jaune
        String co = "j";
        
        // Initialisation de la variable infini à 1 pour continuer la boucle
        int infini = 1;
    
        // Boucle qui s'exécute tant que infini est égal à 1
        while(infini == 1){
            // Si le joueur actuel est le joueur 1
            if(symbolejoueur == 1){
                // Passage au joueur suivant
                symbolejoueur = 2;
                // Affectation du symbole du joueur 1 à la variable symbolp
                symbolp = Joueur.p1symbol;
                
                // Définition du message affiché pour indiquer au joueur quelle colonne choisir
                autour = "Joueur\t"+Joueur.player1+" choisissez une colonne";
                System.out.println(Joueur.p1color);
                // Affectation de la couleur jaune à couleurp si la couleur du joueur 1 est "j"
                if (Joueur.p1color.equals("j")){
                    couleurp = "\u001B[33m";
                }else{
                    couleurp = "\u001B[31m";
                }
                // Appel de la méthode placerCoin() pour placer le jeton du joueur 1
                placerCoin();
            }
            // Appel de la méthode afficherGrill() pour afficher le plateau de jeu
            afficherGrill();
            // Si le joueur actuel est l'IA
            if(symbolejoueur == 2){
                // Passage au joueur suivant
                symbolejoueur = 1;
                // Affectation du symbole de l'IA à la variable symbolp
                symbolp = Joueur.p2symbol;
                // Appel de la méthode IA() pour jouer le coup de l'IA
                IA();
            }
            // Appel de la méthode afficherGrill() pour afficher le plateau de jeu
            afficherGrill();
        }   
       
        afficherGrill();
        
        Case.affichergrill();
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


public static void game1v1() throws IOException {
        
    // Effacer tous les contacts
    clearAllContact();
    // Ajouter les joueurs 1 et 2
    Joueur.ajoutplayer1v1();
    // Afficher le plateau de jeu
    afficherGrill();
    // Initialiser le symbole du joueur à 1
    int symbolejoueur = 1 ;
        
    // Initialiser une variable pour faire tourner la boucle infinie
    int infini = 1;

    // Boucle infinie pour le jeu
    while(infini == 1){
        // Si c'est le tour du joueur 1
        if(symbolejoueur == 1){
            // Passer au tour du joueur 2
            symbolejoueur = 2;
            // Initialiser le symbole du joueur 1
            symbolp = Joueur.p1symbol;
            // Afficher un message indiquant au joueur 1 de choisir une colonne
            autour = "Joueur\t"+Joueur.player1+" choisissez une colonne";
            // Si la couleur du joueur 1 est 'j' (jaune), initialiser la couleur à jaune
            if (Joueur.p1color.equals("j")){
                couleurp = "\u001B[33m";
            }else{
                // Sinon, initialiser la couleur à rouge
                couleurp = "\u001B[31m";
            }
            // Placer un jeton sur le plateau de jeu pour le joueur 1
            placerCoin();

        }
        // Afficher le plateau de jeu
        afficherGrill();
        // Si c'est le tour du joueur 2
        if(symbolejoueur == 2){
            // Passer au tour du joueur 1
            symbolejoueur = 1; 
            // Initialiser le symbole du joueur 2
            symbolp = Joueur.p2symbol; 
            // Afficher un message indiquant au joueur 1 de choisir une colonne
            autour = "Joueur\t"+Joueur.player2+" choisissez une colonne"; 
            // Si la couleur du joueur 2 est 'j' (jaune), initialiser la couleur à jaune
            if (Joueur.p2color.equals("j")){
                couleurp = "\u001B[33m";
            }else{
                // Sinon, initialiser la couleur à rouge
                couleurp = "\u001B[31m";
            }
            // Placer un jeton sur le plateau de jeu pour le joueur 2
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
    //--------------------------------------------------------------------------------------------------------
                                        // afficherGrill()
    // Cette fonction a pour but d'afficher un plateau de jeu en utilisant
    //  un tableau de données. Elle initialise les lignes d'indice et de jeu avec des tirets "_" pour représenter
    //   des cases vides. Elle ajoute ensuite ces lignes au tableau de jeu et affiche le plateau de jeu en utilisant
    //    les données stockées dans le tableau.
    //--------------------------------------------------------------------------------------------------------

    public static void afficherGrill(){
        // Initialiser les lignes d'indice et de jeu
ligneIndex.add(" 1 2 3 4 5 6 7");
for(int i=0; i<7;i++){
    ligne1.add("_");
    ligne2.add("_");
    ligne3.add("_");
    ligne4.add("_");
    ligne5.add("_");
    ligne6.add("_");
}

    // Ajouter les lignes au tableau de jeu
    test.add(ligneIndex);
    test.add(ligne1);
    test.add(ligne2);
    test.add(ligne3);
    test.add(ligne4);
    test.add(ligne5);
    test.add(ligne6);

// Afficher le plateau de jeu en utilisant les données stockées dans le tableau
        System.out.println(test.get(0).get(0));
        System.out.println("|" + test.get(1).get(0) + "|"+ test.get(1).get(1) + "|"+ test.get(1).get(2) + "|"+ test.get(1).get(3) + "|"+ test.get(1).get(4) + "|"+ test.get(1).get(5) + "|"+ test.get(1).get(6) + "|");
        System.out.println("|" + test.get(2).get(0) + "|"+ test.get(2).get(1) + "|"+ test.get(2).get(2) + "|"+ test.get(2).get(3) + "|"+ test.get(2).get(4) + "|"+ test.get(2).get(5) + "|"+ test.get(2).get(6) + "|");
        System.out.println("|" + test.get(3).get(0) + "|"+ test.get(3).get(1) + "|"+ test.get(3).get(2) + "|"+ test.get(3).get(3) + "|"+ test.get(3).get(4) + "|"+ test.get(3).get(5) + "|"+ test.get(3).get(6) + "|");
        System.out.println("|" + test.get(4).get(0) + "|"+ test.get(4).get(1) + "|"+ test.get(4).get(2) + "|"+ test.get(4).get(3) + "|"+ test.get(4).get(4) + "|"+ test.get(4).get(5) + "|"+ test.get(4).get(6) + "|");
        System.out.println("|" + test.get(5).get(0) + "|"+ test.get(5).get(1) + "|"+ test.get(5).get(2) + "|"+ test.get(5).get(3) + "|"+ test.get(5).get(4) + "|"+ test.get(5).get(5) + "|"+ test.get(5).get(6) + "|");
        System.out.println("|" + test.get(6).get(0) + "|"+ test.get(6).get(1) + "|"+ test.get(6).get(2) + "|"+ test.get(6).get(3) + "|"+ test.get(6).get(4) + "|"+ test.get(6).get(5) + "|"+ test.get(6).get(6) + "|");
    }
/**
//--------------------------------------------------------------------------------------------------------
                                    clearGrille()
clearGrille() est une méthode qui permet de nettoyer la grille de jeu en cours.
Elle vide les listes de lignes (ligne1, ligne2, ...) et la liste contenant toutes les lignes (test)
Puis elle réinitialise la grille en ajoutant à nouveau les lignes vides dans la liste test.
//--------------------------------------------------------------------------------------------------------
*/
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
//--------------------------------------------------------------------------------------------------------
                        //verifiyEgalite()
// Ce code crée 8 listes distinctes, chacune représentant une colonne dans un tableau à deux dimensions.
// Il parcoure ensuite chaque colonne en utilisant une boucle for et vérifie si elle ne contient pas de "".
// Si aucune colonne ne contient de "", la variable vc est définie comme étant vraie.
// La méthode retourne finalement la valeur de vc.
//--------------------------------------------------------------------------------------------------------
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
//--------------------------------------------------------------------------------------------------------
                                                //verify()
    // Ce code définit une méthode appelée "verify", qui retourne une valeur booléenne. Il définit d'abord la variable "vv" à "false".
// Il utilise ensuite une structure de contrôle "try-catch" pour capturer une exception potentielle de dépassement de limite d'index.
// Il utilise ensuite une boucle "for" pour parcourir les lignes de 2 à 6 et une autre boucle "for" pour parcourir les colonnes de 0 à 6.
// Il vérifie ensuite si la valeur à l'emplacement actuel est "@" ou "=", puis vérifie si les valeurs adjacentes correspondent également à "@" ou "=" respectivement.
// Si c'est le cas pour les 4 valeurs consécutives, il définit vv à true, sinon il reste false.
// Il retourne finalement la valeur de vv.
// La ligne catch (IndexOutOfBoundsException e) est une instruction qui est utilisée pour gérer les exceptions qui peuvent survenir lorsque l'on accède à un index qui n'existe pas dans la liste.
//--------------------------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------------------------------
                                            //placerCoin()
    // La méthode demande à l'utilisateur de choisir une colonne en affichant "autour", puis vérifie que la colonne 
    // choisie est valide (entre 1 et 8). Ensuite, il utilise une boucle "while" pour trouver la première case vide
    //  (indiquée par "_") dans la colonne choisie, en partant de la ligne 1 et en augmentant l'index jusqu'à ce qu'il
    //   atteigne la dernière ligne. En cas d'erreur "IndexOutOfBoundsException", il ne fait rien. Enfin, il vérifie que
    //    la case choisie est bien vide, et place la pièce en utilisant les variables "couleurp" et "symbolp". S'il y a
    //     déjà une pièce dans cette case, il affiche "Deja pris".
    //--------------------------------------------------------------------------------------------------------

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
    //--------------------------------------------------------------------------------------------------------
                                                //topscore()
    // Ce code définit la méthode privée statique "topscore" qui affiche les 10 meilleurs scores en utilisant les informations
//  de la classe Joueur. Il crée d'abord une liste de joueurs en utilisant la méthode statique "lister" de la classe Joueur.
//   Ensuite, il trie la liste par ordre croissant en fonction du nombre de coups de chaque joueur. Enfin, Il utilise une
//    boucle "for" pour parcourir la liste des joueurs et affiche le pseudo et le nombre de coups de chaque joueur si i est
//     inférieur à 10, et quitte la boucle sinon.
    //--------------------------------------------------------------------------------------------------------

    private static void topscore() throws IOException {
            // Initialise la variable i à 0
            int i =0;
            //Crée une liste des joueurs en utilisant la méthode statique "lister" de la classe Joueur
            ArrayList<Joueur> liste = Joueur.lister();
            // Trie la liste par ordre croissant en fonction du nombre de coups de chaque joueur
            Collections.sort(liste, (c1, c2) -> Integer.parseInt(c1.getNb_coups()) - Integer.parseInt(c2.getNb_coups()));
            // Parcours la liste des joueurs
            for (Joueur joueur : liste) {
                // Si i est inférieur à 10, affiche le pseudo et le nombre de coups du joueur
                if(i<10) {
                System.out.println(joueur.getPseudo() + " a fait " + joueur.getNb_coups()+ " coups");
                i++;
                }
                //sinon quitte la boucle
                else{
                    break;
                }
                
            }

    }
    //--------------------------------------------------------------------------------------------------------
                                                //IA()
    // Ce code définit une méthode statique "IA" qui simule un tour de jeu pour un joueur automatique (IA) dans
    //  un jeu de Puissance 4. Il génère un nombre aléatoire entre 0 et 6, qui correspond à la colonne où la pièce
    //   sera placée. Il utilise ensuite une boucle pour trouver la première case vide dans cette colonne en utilisant
    //    l'index, qui est initialisé à 1 et incrémenté jusqu'à ce qu'il atteigne la dernière ligne. Il vérifie ensuite si
    // la case choisie est bien vide, et placela pièce en utilisant les variables "couleurp" et "Joueur.p2symbol", qui
    // dépendent de la couleur
    //--------------------------------------------------------------------------------------------------------
    public static void IA(){
        // Initialise la variable z à false
        boolean z = false;
        // Boucle tant que z est égal à false
        do{
            // Génère un nombre aléatoire entre 0 et 6
            int r = (int)(Math.random() * 7);
            //Initialise l'index à 1
            int index = 1;
            // Boucle tant que la case correspondante à l'index et la colonne r est vide et que l'index est inférieur à 6
            while(test.get(index).get(r) == "_" && index < 6){                        
                // Incrémente l'index
                index++;
            }
            try {
                // Boucle tant que la case correspondante à l'index et la colonne r n'est pas vide
                while(test.get(index).get(r) != "_"){
                    // Décrémente l'index
                    index--;
                }
            } catch (IndexOutOfBoundsException e) {
               
            }
            // Si la couleur du joueur 2 est égale à "j"
            if (Joueur.p2color.equals("j")){
            // alors la couleur de la pièce est jaune
            couleurp = "\u001B[33m";
            }else{
            // sinon la couleur de la pièce est rouge
            couleurp = "\u001B[31m";
            }
            // si la case correspondante à l'index et la colonne r est vide
            if(test.get(1).get(r) == "_"){
                // alors place la pièce à cette case en utilisant les variables couleurp et Joueur.p2symbol
                test.get(index).set(r,couleurp+Joueur.p2symbol+"\u001B[0m");
                // et change la valeur de z à true
                z = true;
            } else{
                // sinon change la valeur de z à false
                z = false;
            }
        } while(z ==false);
    }


}
 