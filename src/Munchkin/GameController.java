package Munchkin;

import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException{
        
        FileWriter file = new FileWriter("games/GAME "+Game.getINSTANCE().getNumberOfGame()+".txt");
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
        System.out.println("\n" + Game.getINSTANCE().getPlayer());   //PRINTANDO OS STATUS DO PLAYER
        
        
        //*--------------- WRITER ----------*
        fileWriter.println("---------------- STATUS INICIAL DO PLAYER! -------------\r\n");
        fileWriter.println(""+Game.getINSTANCE().getPlayer());
        file.close();
        //*--------------- WRITER ----------*
        
        
        /* -------------- WANNA PLAY KIDO?! --------------*/
        System.out.println("\nPRESS A BUTTON TO START: ");
        String inicio = entrada.nextLine();
        /* -------------- WANNA PLAY KIDO?! --------------*/

        //INICIO DOS ROUNDS
        System.out.println("\n>---------------- LET'S START =] -------------<");

        while (true) {
            boolean roundsLimit = Game.getINSTANCE().createRound();

            //CONDIÇÃO DE FIM DO JOGO , 10 RODADAS OU LVL 10
            if (roundsLimit) {
                //FIM DO JOGO
                endGame();
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
        } else {
            System.out.println("\nPARABÉNS VOCÊ ATINGIU O LEVEL 4!!!!!!!!");
            System.out.println(Game.getINSTANCE().getPlayer());
        }
    }

    public static void round() {
        String option;
        System.out.println("\n\n*-----------------------------------------*");
        System.out.println("*---------- NUMERO DO ROUND : " + Game.getINSTANCE().getNumberOfRounds() + " ----------*");
        System.out.println("*-----------------------------------------*");

        //PEGA UMA CARTA ALEATORIA DA DUNGEON
        Game.getINSTANCE().getRound().getARandomCard();

        //SE FOR UM MONSTRO
        if (Game.getINSTANCE().getRound().isMonster()) {
            System.out.println("\nFIGHT WITH A MONSTER");
            System.out.println(Game.getINSTANCE().getRound().getMonster());

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
        boolean didRun = Game.getINSTANCE().getPlayer().runAway();

        //HE DID RUN
        if (didRun) {
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " CONSEGUIU CORRER!\n");
            System.out.println(Game.getINSTANCE().getPlayer());
        } //HE FAILED TO RUN
        else {
            System.out.println("\nINFELIZMENTE " + Game.getINSTANCE().getPlayer().getName() + " TERÁ QUE LUTAR COM O MONSTRO!");
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
        } //IF HAS DIED TO MONSTER
        else {
            System.out.println(Game.getINSTANCE().getPlayer().getName() + " PERDEU PARA " + Game.getINSTANCE().getRound().getMonster());
            Game.getINSTANCE().getRound().getMonster().performBadStuff();
        }
    }

    //GERA 3 ITEMS ALEATORIOS INICIAIS DO PLAYER
    public static void inicialItems() {
        int random; 
        for (int i = 0; i < 3; i++) {
            random = (int)Math.floor(Math.random() * Game.getINSTANCE().getItemList().size());
            addItem(Game.getINSTANCE().getItemList().remove(random));
        }
    }

    //ADICIONA ITEMS
    public static void addItem(Item item) {        
        System.out.println(" \nITEM RECEBIDO: " + item);
        Scanner entrada = new Scanner(System.in);
        int sizeOfArray = Game.getINSTANCE().getPlayer().getListCards().size();
        boolean hasItem = false;
        Item inventoryItem = Game.getINSTANCE().getPlayer().hasItem(item);

        if (Game.getINSTANCE().getPlayer().getListCards().isEmpty()) {
            Game.getINSTANCE().getPlayer().addItem(item);
        } else {
            for (int i = 0; i < sizeOfArray; i++) {
                if (inventoryItem != null) {
                    System.out.println("VOCÊ JA TEM UM ITEM DO TIPO "+inventoryItem.getType());
                    System.out.println("DESEJA ALTERAR O SEU ITEM: "+inventoryItem+ " PELO ITEM RECEBIDO? [YES / NO]?");
                    String choice = entrada.nextLine().toUpperCase();
                    if(choice.equals("YES") || choice.equals("Y")){
                        Game.getINSTANCE().getPlayer().removeAnItem(inventoryItem);
                        Game.getINSTANCE().getPlayer().addItem(item);                        
                    }
                    hasItem = true;
                    break;
                }
            }
            if(!hasItem)
                Game.getINSTANCE().getPlayer().addItem(item);
        }

    }

    public static void pressAButton() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nPRESS A BUTTON TO CONTINUE: ");
        String nextRound = entrada.nextLine();
    }
}
