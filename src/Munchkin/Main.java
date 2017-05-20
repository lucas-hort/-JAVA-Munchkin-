package Munchkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Hort
 */
public class Main {

    public static void main(String[] args) {

        List<Item> itemList = new ArrayList<>();
        List<Monster> monsterList = new ArrayList<>();
        Item item1 = new Item(0, "Boots of Butt-Kicking", 3, "Footgear");
        Item item2 = new Item(1, "Eleven-Foot Pole", 1, "2 Hands");
        Item item3 = new Item(2, "Rapier of Unfairness", 2, "1 Hand");
        Item item4 = new Item(3, "Staff of Napalm", 5, "1 Hand");
        Item item5 = new Item(4, "Dragon Steed", 5, "Big");
        Item item6 = new Item(5, "Birdhouse", 4, "Headgear");
        Item item7 = new Item(6, "Forked Tongue", 2, "Headgear");
        Item item8 = new Item(7, "Your own pancreas", 4, "1 Hand");
        Item item9 = new Item(8, "Sneaky Bastard Sword", 4, "1 or 2 Hands");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);

        Monster monster1 = new MonsterLoseLvl(0, "Leperchaun", 4, 1); // 1 level
        Monster monster2 = new MonsterLoseLvl(1, "Squidzilla", 18, 3);// 2 levels
        Monster monster3 = new MonsterLoseLvl(2, "Harold Angel", 6, 1); // 1 level
        Monster monster4 = new MonsterLoseLvl(3, "Undead Horse", 4, 1); // 1 level
        Monster monster5 = new MonsterLoseLvl(4, "Knight of The Living Dead", 11, 2); //2 levels
        Monster monster6 = new MonsterLoseItem(5, "The Ether Bunny", 8, 1); // 1 item
        Monster monster7 = new MonsterLoseItem(6, "Duck Holliday", 6, 1);// 1 item
        Monster monster8 = new MonsterLoseItem(7, "Dragonfly ", 10, 1);// 1 item
        Monster monster9 = new MonsterLoseItem(8, "Blue-Eyes White Dragon", 30, -1);// all fucking items
        Monster monster10 = new MonsterLoseItem(9, "A Mimic?!!", 15, 2);// 2 items
        monsterList.add(monster1);
        monsterList.add(monster2);
        monsterList.add(monster3);
        monsterList.add(monster4);
        monsterList.add(monster5);
        monsterList.add(monster6);
        monsterList.add(monster7);
        monsterList.add(monster8);
        monsterList.add(monster9);
        monsterList.add(monster10);

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
        System.out.println("----------------- "+nome+" --------------\n");
        
        Game.getINSTANCE().setItemList(itemList);
        Game.getINSTANCE().setMonsterList(monsterList);
        Game.getINSTANCE().setPlayer(p);

        //TESTANDO O PLAYER
        System.out.println("\n---------------- STATUS INICIAL DO PLAYER! -------------");
        Game.getINSTANCE().inicialItems();                      //ITEMS INICIAIS DO PLAYER
        Game.getINSTANCE().getPlayer().setCombatLevel();        //SETANDO O NIVEL DE COMBAT TO PLAYER
        System.out.println(Game.getINSTANCE().getPlayer());     //PRINTANDO OS STATUS DO PLAYER

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
        Scanner entrada = new Scanner(System.in);
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
            Scanner read = new Scanner(System.in);
            System.out.println("\nWANT TO RUN? (YES OR NO): ");
            String option = read.nextLine().toUpperCase();
            
            if (option.equals("YES") || option.equals("Y")){
                wantToRun();
            }else{
                fight();
            }
        }
        //SE FOR UM ITEM
        if (Game.getINSTANCE().getRound().isItem()) {
            System.out.println("\nYOU GOT AN ITEM!\n");
            System.out.println(Game.getINSTANCE().getRound().getItem());
            Game.getINSTANCE().getRound().gotAnItem();
            System.out.println(Game.getINSTANCE().getPlayer() + "\nVOCÊ PEGOU O ITEM!");
            
            System.out.println("\nPRESS A BUTTON TO CONTINUE: ");
            String nextRound = entrada.nextLine();
        }
    }

    public static void wantToRun() {
            System.out.println(Game.getINSTANCE().getPlayer() + " WHANT TO RUN!");
            boolean didRun = Game.getINSTANCE().getPlayer().runAway();

            //HE DID RUN
            if (didRun) {
                System.out.println(Game.getINSTANCE().getPlayer() + " CORREU!");
            } //HE FAILED TO RUN
            else {
                System.out.println("INFELIZMENTE " + Game.getINSTANCE().getPlayer() + " TERÁ QUE LUTAR COM O MONSTRO!");
                fight();
            }
        }
    
    public static void fight(){
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
}
