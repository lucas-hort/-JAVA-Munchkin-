package Munchkin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Hort
 */
public class GameController {

    public static String log = "";

    public static void main(String[] args) throws IOException {

        Game.getINSTANCE().readGameId();
        Game.getINSTANCE().writeGameId();

        FileWriter file = new FileWriter("games/GAME " + Game.getINSTANCE().getNumberOfGame() + ".txt");
        PrintWriter fileWriter = new PrintWriter(file);

        //INICIO DO GAME      
        Scanner entrada = new Scanner(System.in);
        System.out.println("DIGITE O NICK DO PLAYER: ");
        String nome = entrada.nextLine();
        Player p = new Player(nome);

        //SETTANDO O GAME
        System.out.println("\n--------------- ** MUNCHKIN ** -------------");
        System.out.println("--------------- SETTANDO O GAME ------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("----------------- BEM - VINDO --------------");
        System.out.println("----------------- " + nome + " --------------\n");

        //INICIALIZANDO CARTAS DE ITEM E MONSTROS
        ItemsReader r = new ItemsReader();
        MonstersReader m = new MonstersReader();
        //INSTACIA O PLAYER
        Game.getINSTANCE().setPlayer(p);

        //TESTANDO O PLAYER
        System.out.println("\n---------------- STATUS INICIAL DO PLAYER! -------------\n");
        inicialItems();                                              //ITEMS INICIAIS DO PLAYER                     
        Game.getINSTANCE().getPlayer().updateCombatLevel();          //SETANDO O NIVEL DE COMBAT TO PLAYER
        System.out.println(Game.getINSTANCE().getPlayer());   //PRINTANDO OS STATUS DO PLAYER

        //*--------------- WRITER ----------*
        log += "---------------- STATUS INICIAL DO PLAYER! -------------\r\n\r\n";
        log += "" + Game.getINSTANCE().getPlayer();
        //*--------------- WRITER ----------*

        /* -------------- WANNA PLAY KIDO?! --------------*/
        System.out.println("\nPRESS A BUTTON TO START: ");
        String inicio = entrada.nextLine();
        /* -------------- WANNA PLAY KIDO?! --------------*/

        //INICIO DOS ROUNDS
        System.out.println("\n>---------------- LET'S START =] -------------<");

        //*--------------- WRITER ----------*
        log += "\r\n\r\n>---------------- LET'S START =] -------------<\r\n\r\n";
        //*--------------- WRITER ----------*

        while (true) {
            boolean roundsLimit = Game.getINSTANCE().createRound();

            //CONDIÇÃO DE FIM DO JOGO , 10 RODADAS OU LVL 10
            if (roundsLimit) {
                //FIM DO JOGO
                endGame();
                fileWriter.print(log);
                fileWriter.close();
                break;
            } else {
                //NEXT ROUND
                round();
            }
        }

    }

    public static void endGame() {
        if (Game.getINSTANCE().getNumberOfRounds() >= 20) {
            System.out.println("\nFIM DO JOGO - SE PASSARAM 20 ROUNDS!!!!!!!!");
            System.out.println(Game.getINSTANCE().getPlayer());

            //*--------------- WRITER ----------*
            log += "\r\n\r\nFIM DO JOGO - SE PASSARAM 20 ROUNDS!!!!!!!!\r\n";
            log += "" + Game.getINSTANCE().getPlayer();
            //*--------------- WRITER ----------*

        } else {
            System.out.println("\nPARABÉNS VOCÊ ATINGIU O LEVEL 10!!!!!!!!");
            System.out.println(Game.getINSTANCE().getPlayer());

            //*--------------- WRITER ----------*
            log += "\r\n\r\nPARABÉNS VOCÊ ATINGIU O LEVEL 10!!!!!!!!\r\n";
            log += "" + Game.getINSTANCE().getPlayer();
            //*--------------- WRITER ----------*

        }
    }

    public static void round() {
        String option;
        System.out.println("\n\n*-----------------------------------------*");
        System.out.println("*---------- NUMERO DO ROUND : " + Game.getINSTANCE().getNumberOfRounds() + " ----------*");
        System.out.println("*-----------------------------------------*");

        //*--------------- WRITER ----------*
        log += "\r\n\r\n*-----------------------------------------*\r\n";
        log += "*---------- NUMERO DO ROUND : " + Game.getINSTANCE().getNumberOfRounds() + " ----------*\r\n";
        log += "*-----------------------------------------*\r\n";
        //*--------------- WRITER ----------*        

        //PEGA UMA CARTA ALEATORIA DA DUNGEON
        Game.getINSTANCE().getRound().getARandomCard();

        //SE FOR UM MONSTRO
        if (Game.getINSTANCE().getRound().isMonster()) {
            System.out.println("\nFIGHT WITH A MONSTER");

            //*--------------- WRITER ----------*
            log += "\r\nFIGHT WITH A MONSTER\r\n";
            //*--------------- WRITER ----------* 

            System.out.println(Game.getINSTANCE().getRound().getMonster());

            //*--------------- WRITER ----------*
            log += Game.getINSTANCE().getRound().getMonster() + "\r\n";
            //*--------------- WRITER ----------* 

            //WANT TO RUN BABY??
            while (true) {
                Scanner read = new Scanner(System.in);
                System.out.println("\nWANT TO RUN? [YES(Y) OR NO(N)]: ");
                option = read.nextLine().toUpperCase();
                if (option.equals("YES") || option.equals("Y") || option.equals("NO") || option.equals("N")) {
                    break;
                } else {
                    System.out.println("OPÇÃO INVALIDA! DIGITE YES(Y) OR NO(N): ");
                }
            }

            if (option.equals("YES") || option.equals("Y")) {
                wantToRun();
            } else {
                fight();
            }

            pressAButton();

        }
        //SE FOR UM ITEM
        if (Game.getINSTANCE().getRound().isItem()) {
            System.out.println("\nYOU GOT AN ITEM!");
            addItem(Game.getINSTANCE().getRound().getItem());
            System.out.println("");
            System.out.println(Game.getINSTANCE().getPlayer());

            pressAButton();
        }
    }

    public static void wantToRun() {
        System.out.println(Game.getINSTANCE().getPlayer() + " WHANT TO RUN!");

        //*--------------- WRITER ----------*
        log += Game.getINSTANCE().getPlayer() + " WHANT TO RUN!\r\n";
        //*--------------- WRITER ----------* 

        boolean didRun = Game.getINSTANCE().getPlayer().runAway();

        //HE DID RUN
        if (didRun) {
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " CONSEGUIU CORRER!\n");
            System.out.println(Game.getINSTANCE().getPlayer());

            //*--------------- WRITER ----------*
            log += Game.getINSTANCE().getPlayer().getName() + " CONSEGUIU CORRER!\r\n\r\n";
            log += Game.getINSTANCE().getPlayer() + "\r\n";
            //*--------------- WRITER ----------* 

        } //HE FAILED TO RUN
        else {
            System.out.println("\nINFELIZMENTE " + Game.getINSTANCE().getPlayer().getName() + " TERÁ QUE LUTAR COM O MONSTRO!");

            //*--------------- WRITER ----------*
            log += "\r\nINFELIZMENTE " + Game.getINSTANCE().getPlayer().getName() + " TERÁ QUE LUTAR COM O MONSTRO!\r\n";
            //*--------------- WRITER ----------* 

            fight();
        }
    }

    public static void fight() {
        boolean fight = Game.getINSTANCE().getRound().fightWithMonster();

        //IF HAS KILLED THE MONSTER
        if (fight) {
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " MATOU O " + Game.getINSTANCE().getRound().getMonster());
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " GANHOU 1 LEVEL, LEVEL ATUAL = " + (Game.getINSTANCE().getPlayer().getLevel() + 1)
                    + ", COMBAT LEVEL ATUAL = " + (Game.getINSTANCE().getPlayer().getCombatLevel() + 1));
            Game.getINSTANCE().getPlayer().addLevel();

            //*--------------- WRITER ----------*
            log += Game.getINSTANCE().getPlayer().getName() + " MATOU O " + Game.getINSTANCE().getRound().getMonster() + "\r\n";
            log += Game.getINSTANCE().getPlayer().getName() + " GANHOU 1 LEVEL, LEVEL ATUAL = " + (Game.getINSTANCE().getPlayer().getLevel() + 1)
                    + ", COMBAT LEVEL ATUAL = " + (Game.getINSTANCE().getPlayer().getCombatLevel() + 1) + "\r\n";
            //*--------------- WRITER ----------* 

        } //IF HAS DIED TO MONSTER
        else {
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " PERDEU PARA " + Game.getINSTANCE().getRound().getMonster());
            Game.getINSTANCE().getRound().getMonster().performBadStuff();

            //*--------------- WRITER ----------*
            log += Game.getINSTANCE().getPlayer().getName() + " PERDEU PARA " + Game.getINSTANCE().getRound().getMonster() + "\r\n";
            //*--------------- WRITER ----------* 

        }
    }

    //GERA 3 ITEMS ALEATORIOS INICIAIS DO PLAYER
    public static void inicialItems() {
        int random;
        for (int i = 0; i < 3; i++) {
            random = (int) Math.floor(Math.random() * Game.getINSTANCE().getItemList().size());
            addItem(Game.getINSTANCE().getItemList().remove(random));
        }
    }

    //ADICIONA ITEMS
    public static void addItem(Item item) {
        System.out.println(" \nITEM RECEBIDO: " + item);

        //*--------------- WRITER ----------*
        log += "\r\nITEM RECEBIDO: " + item + "\r\n";
        //*--------------- WRITER ----------* 

        Scanner entrada = new Scanner(System.in);
        int sizeOfArray = Game.getINSTANCE().getPlayer().getListCards().size();
        boolean hasItem = false;
        Item inventoryItem = Game.getINSTANCE().getPlayer().hasItem(item);

        if (Game.getINSTANCE().getPlayer().getListCards().isEmpty()) {
            Game.getINSTANCE().getPlayer().addItem(item);
        } else {
            for (int i = 0; i < sizeOfArray; i++) {
                if (inventoryItem != null) {
                    System.out.println("VOCÊ JA TEM UM ITEM DO TIPO " + inventoryItem.getType());
                    System.out.println("DESEJA ALTERAR O SEU ITEM: " + inventoryItem + " PELO ITEM RECEBIDO? [YES / NO]?");
                    String choice = entrada.nextLine().toUpperCase();
                    if (choice.equals("YES") || choice.equals("Y")) {
                        System.out.println(Game.getINSTANCE().getPlayer().getName() + " TROCOU O ITEM " + inventoryItem);

                        //*--------------- WRITER ----------*
                        log += Game.getINSTANCE().getPlayer().getName() + " TROCOU O ITEM " + inventoryItem + "\r\n";
                        //*--------------- WRITER ----------*                        

                        Game.getINSTANCE().getPlayer().removeAnItem(inventoryItem);
                        Game.getINSTANCE().getPlayer().addItem(item);

                    }
                    hasItem = true;
                    break;
                }
            }
            if (!hasItem) {
                Game.getINSTANCE().getPlayer().addItem(item);
            }
        }

    }

    public static void pressAButton() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nPRESS A BUTTON TO CONTINUE: ");
        String nextRound = entrada.nextLine();
    }
}
