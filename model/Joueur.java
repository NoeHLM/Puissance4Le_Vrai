package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Joueur {
    private static Scanner scan = new Scanner(System.in);
    private String pseudo;
    private String nb_coups;
    private String color;
    private String symbol;
    public static String player1 = null;
    public static String player2 = null;
    public static String p1color = null;
    public static String p2color= null;
    public static String p1symbol = null;
    public static String p2symbol= null;
    public static String couleurp = "";
    public static String pions = null;
    public static String couleurp1 = "";
    public static String couleurp2 = "";


    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getNb_coups() {
        return nb_coups;
    }
    public void setNb_coups(String nb_coups) {
        this.nb_coups = nb_coups;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) throws ParseException {
        Pattern pat = Pattern.compile("j");
        Pattern pat2 = Pattern.compile("r");
        Matcher test = pat.matcher(color);
        Matcher test2 = pat2.matcher(color);
        if (test.matches()) {
            this.color = color;
        }
        else if(test2.matches()){
            this.color = color;

        } else {
            throw new ParseException("la couleur est incorrect.", 0);
        }

    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) throws ParseException {
        Pattern pat = Pattern.compile("@");
        Pattern pat2 = Pattern.compile("=");
        Matcher test = pat.matcher(symbol);
        Matcher test2 = pat2.matcher(symbol);
        if (test.matches()) {
            this.symbol = symbol;
        }
        else if(test2.matches()){
            this.symbol = symbol;

        } else {
            throw new ParseException("le symbole est incorrect.", 0);
        }
        
    }
    //-----------------------------------------------------------------------------------
                                        //lister()
    // La fonction lister() permet de lister les joueurs enregistr??s dans un fichier CSV nomm?? "joueur.csv". Elle d??clare
    //  une liste list de type Joueur et un objet buf de type BufferedReader qui lit le fichier "joueur.csv". Elle utilise
    //   une boucle try-catch-finally pour lire les lignes du fichier et les ajouter ?? la liste. Chaque ligne est s??par??e
    //    en utilisant le s??parateur d??fini dans la variable SEPARATEUR, puis convertie en objet Joueur. Les informations
    //     sont extraites de chaque ligne pour remplir les propri??t??s pseudo et nb_coups de cet objet. Enfin, le contenu 
    //     de la liste est retourn?? et le flux de fichier est ferm??.
    //-----------------------------------------------------------------------------------
    public static ArrayList<Joueur> lister() throws IOException, ParseException {
        
        ArrayList<Joueur> list = new ArrayList<>();
        String SEPARATEUR = ";";
        BufferedReader buf = new BufferedReader(new FileReader("joueur.csv"));
        try {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueur j = new Joueur();
                j.setPseudo(tab[0]);
                j.setNb_coups(tab[1]);
                
                list.add(j);
                ligne = buf.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            buf.close();
        }
        return list;

    }
    //-----------------------------------------------------------------------------------
                                        // ajoutplayer()
    // La fonction ajoutplayer() permet d'ajouter des joueurs au jeu de P4. Elle cr??e un objet Joueur, initialise les variables
    //  red et symb1 puis utilise une boucle while pour ajouter les joueurs 1 et 2. Si le nom du joueur 1 n'est pas d??fini, elle
    //   demande ?? l'utilisateur de saisir le nom du joueur 1 et utilise la saisie pour d??finir la propri??t?? player1 de l'objet
    //   Joueur. Elle demande ??galement ?? l'utilisateur de saisir la couleur et le symbole de jeton souhait??, et utilise ces 
    //   saisies pour d??finir les propri??t??s p1color et p1symbol de l'objet Joueur. Si le nom du joueur 2 n'est pas d??fini, elle 
    //   demande ?? l'utilisateur de saisir le nom du joueur 2 et utilise la saisie pour d??finir la propri??t?? player2 de l'objet
    //    Joueur. Elle d??finit ??galement la couleur et le symbole du joueur 2 en fonction des choix du joueur 1. Enfin, elle affiche
    //     les noms, couleurs et symboles des deux joueurs 
    //-----------------------------------------------------------------------------------

    public static void ajoutplayer() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null || player2 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);

                
            }
            if (player2 == null){
                System.out.println("Saisir le nom du joueur 2");
                j.setPseudo(scan.nextLine());
                player2 = j.getPseudo();  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }

            System.out.println(player1);
            System.out.println(player2);
            System.out.println(p1color);
            System.out.println("la couleur du joueur 2 est "+""+p2color);
            System.out.println(p1symbol);
            System.out.println(p2symbol);
        }

    }

    

//-----------------------------------------------------------------------------------
                                    // ecrire()
// La fonction ecrire(ArrayList<Joueur> liste) permet d'enregistrer les informations des joueurs dans un fichier
//  CSV nomm?? "joueur.csv". Elle prend en param??tre une liste de type Joueur nomm??e liste. Elle d??clare un objet
//   writer de type BufferedWriter qui ??crit dans le fichier "joueur.csv". Elle utilise une boucle for pour parcourir
//    chaque objet Joueur de la liste et ??crire les propri??t??s pseudo, nb_coups, color et symbol de chaque objet dans
//     le fichier. Elle utilise un try-finally pour g??rer les erreurs d'??criture et ferme le flux de fichier lorsque
//      l'??criture est termin??e.
//-----------------------------------------------------------------------------------
public static void ecrire(ArrayList<Joueur> liste) throws IOException {
    // Ouvrez le fichier en utilisant un BufferedWriter
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("joueur.csv"));
        for (Joueur contact : liste) {
            try {
                writer.write(contact.getPseudo() + ";" + contact.getNb_coups() + ";" + contact.getColor() + ";"
                        + contact.getSymbol() + "\n");
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    } finally {
        if (writer != null) {
            writer.close();
        }
    }
 }
 /*                                     top10()
 La fonction top10(ArrayList<Joueur> liste) permet de lire les 10 premiers joueurs enregistr??s dans le fichier 
 CSV "Joueur.csv" et de les ajouter dans une liste de type Joueur nomm??e liste. Elle prend en param??tre une liste de 
 type Joueur nomm??e liste. Elle d??clare un objet buf de type BufferedReader qui lit le fichier "Joueur.csv". Elle 
 utilise une boucle for pour lire les 10 premi??res lignes du fichier et utilise un s??parateur ";" pour s??parer les
  propri??t??s des joueurs. Elle instancie des objets Joueur pour chaque ligne lue et les ajoute ?? la liste liste. Elle
   utilise un try-finally pour g??rer les erreurs de lecture et ferme le flux de fichier lorsque la lecture est termin??e.
    Enfin, elle renvoie la liste des joueurs qui ont ??t?? lus. */


 public static ArrayList<Joueur> top10(ArrayList<Joueur> liste) throws IOException{
    BufferedReader buf = new BufferedReader(new FileReader("Joueur.csv"));
    String SEPARATEUR = ";";
        try {
            String ligne = buf.readLine();
            for (int i = 0; i < 10 ; i++) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueur c = new Joueur();
                c.setPseudo(tab[0]);
                c.setNb_coups(tab[1]);
                liste.add(c);
                ligne = buf.readLine();
                System.out.println(ligne);
            }
        
        } catch (IOException e) {
            System.out.println("Erreur de lecture sur le fichier");
        } finally {
            buf.close();
        }
        return liste;
 }

/*
                                        ajoutplayeria()
     La fonction "ajoutplayeria" est utilis??e pour ajouter les informations du joueur 1 et de l'IA dans le jeu.
      Elle d??clare un objet "j" de la classe Joueur, ainsi que des variables "red" et "symb1" qui sont utilis??es
       pour les couleurs et les symboles des joueurs. Elle utilise une boucle while pour s'assurer que les informations
        du joueur 1 sont saisies correctement. Elle demande ?? l'utilisateur de saisir le nom du joueur 1, puis utilise
         cette entr??e pour d??finir le nom du joueur 1 dans l'objet "j" et dans la variable "player1". Elle demande ??galement
          ?? l'utilisateur de saisir la couleur et le symbole souhait??s pour le joueur 1, en utilisant les entr??es pour d??finir
           la couleur et le symbole dans l'objet "j" et dans les variables "p1color" et "p1symbol". Enfin, elle d??finit le nom 
           du joueur 2 comme "ia" et d??finit les couleurs et symboles pour l'IA
     */

    public static void ajoutplayeria() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                player2 = "ia";
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);   
            }
            if (player2 == "ia"){  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }

    

        }
    }

    
    /*
     La fonction "ajoutplayer1v1()" permet de d??finir les informations des deux joueurs qui vont jouer contre l'un l'autre.
      Elle utilise un objet Joueur "j", une variable String "red" et une variable String "symb1".
La fonction utilise une boucle while qui s'ex??cute tant que les variables "player1" et "player2" sont nulles. Dans cette boucle,
 elle demande d'abord ?? l'utilisateur de saisir le nom du joueur 1, en utilisant un objet Scanner pour lire l'entr??e de l'utilisateur.
  Elle d??finit ensuite la variable "player1" avec la valeur saisie par l'utilisateur. Ensuite, elle demande ?? l'utilisateur de saisir
   la couleur et le symbole pour le joueur 1, en utilisant un objet Scanner pour lire l'entr??e de l'utilisateur.
Ensuite, la fonction demande ?? l'utilisateur de saisir le nom du joueur 2, en utilisant un objet Scanner pour lire l'entr??e de
 l'utilisateur. Elle d??finit ensuite la variable "player2" avec la valeur saisie par l'utilisateur. Enfin, elle d??finit les couleurs
  et symboles pour le joueur 2 en utilisant des conditions if-else qui d??finissent les valeurs en fonction des valeurs saisies pour 
  le joueur 1.
     */
    public static void ajoutplayer1v1() {
        Joueur j = new Joueur();
        String red = "r";
        String symb1 = "@";

        while(player1 == null || player2 == null){
            if (player1 == null){
                System.out.println("Saisir le nom du joueur 1");
                j.setPseudo(scan.nextLine());
                player1 = j.getPseudo();
                do {
                    try {
                    System.out.println("Saisir la couleur: j = jaune r = rouge");
                    j.setColor(scan.nextLine());
                    p1color = j.getColor();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);
                do {
                    try {
                    System.out.println("Saisir le symbole : @ ; =");
                    j.setSymbol(scan.nextLine());
                    p1symbol = j.getSymbol();
                    break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    
                } while (true);

                
            }
            if (player2 == null){
                System.out.println("Saisir le nom du joueur 2");
                j.setPseudo(scan.nextLine());
                player2 = j.getPseudo();  
                if (p1color.equals(red)){
                    p2color = "j";
                }  
                else{
                    p2color = "r";
                }
                
                if (p1symbol.equals(symb1)){
                    p2symbol = "=";
                }  
                else{
                    p2symbol = "@";
                }   
            }
        }

    }
//--------------------------------------------------------------------------------------------------------
                                            //placerCoin()
    // La m??thode demande ?? l'utilisateur de choisir une colonne en affichant "autour", puis v??rifie que la colonne 
    // choisie est valide (entre 1 et 8). Ensuite, il utilise une boucle "while" pour trouver la premi??re case vide
    //  (indiqu??e par "_") dans la colonne choisie, en partant de la ligne 1 et en augmentant l'index jusqu'?? ce qu'il
    //   atteigne la derni??re ligne. Enfin, il v??rifie que
    //    la case choisie est bien vide, et place la pi??ce en utilisant les variables "couleurp" et "symbolp". S'il y a
    //     d??j?? une pi??ce dans cette case, il affiche "Deja pris".
    //--------------------------------------------------------------------------------------------------------

    public static void placerCoin(){ 
        boolean p = false;     
        do {
            int index = 1;
            System.out.println("Choisissez une colonne");
            String rep = scan.nextLine();
            while(1 <= Integer.valueOf(rep) && Integer.valueOf(rep) >= 8){
            System.out.println("Choisissez une autre colonne");
            rep = scan.nextLine();
            }
            while(Case.test.get(index).get(Integer.valueOf(rep)-1) == "_" && index < 6){                        
            index++;
            }
            try {
            while(Case.test.get(index).get(Integer.valueOf(rep)-1) != "_"){
                index--;
            }
            } catch (IndexOutOfBoundsException e) {
            }
            if(Case.test.get(1).get(Integer.valueOf(rep)-1) == "_"){
            Case.test.get(index).set(Integer.valueOf(rep)-1, couleurp + pions + "\u001B[0m");
            p=true;
            } else{
                p = false;
                Case.afficherGrill();
            System.out.println("Deja pris");
            }
        } while (p == false);
        Case.verifyLine(pions, couleurp);
        Case.verifyColumn(pions, couleurp);
        Case.verifyDiagoLeft(pions, couleurp);
        Case.verifyDiagoRight(pions, couleurp);
    }

    //--------------------------------------------------------------------------------------------------------
                                                //IA()
    // Ce code d??finit une m??thode statique "IA" qui simule un tour de jeu pour un joueur automatique (IA) dans
    //  un jeu de Puissance 4. Il g??n??re un nombre al??atoire entre 0 et 6, qui correspond ?? la colonne o?? la pi??ce
    //   sera plac??e. Il utilise ensuite une boucle pour trouver la premi??re case vide dans cette colonne en utilisant
    //    l'index, qui est initialis?? ?? 1 et incr??ment?? jusqu'?? ce qu'il atteigne la derni??re ligne. Il v??rifie ensuite si
    // la case choisie est bien vide, et placela pi??ce en utilisant les variables "couleurp" et "Joueur.p2symbol", qui
    // d??pendent de la couleur
    //--------------------------------------------------------------------------------------------------------

    public static void IA(){
        boolean z = false;
        do{
            int r = (int)(Math.random() * 7);
            int index = 1;
            while(Case.test.get(index).get(r) == "_" && index < 6){                        
                index++;
            }
            try {
                while(Case.test.get(index).get(r) != "_"){
                    index--;
                }
            } catch (IndexOutOfBoundsException e) {
            }
            if(Case.test.get(1).get(r) == "_"){
                Case.test.get(index).set(r,couleurp2+Joueur.p2symbol+"\u001B[0m");
                z = true;
            } else{
                z = false;
            }
        } while(z ==false);
        Case.afficherGrill();
        if(Case.victoire == "0"){

        }else{
            Case.verifyLine(Joueur.p2symbol, couleurp2);
            Case.verifyColumn(Joueur.p2symbol, couleurp2);
            Case.verifyDiagoLeft(Joueur.p2symbol, couleurp2);
            Case.verifyDiagoRight(Joueur.p2symbol, couleurp2);
        }
    }
}

