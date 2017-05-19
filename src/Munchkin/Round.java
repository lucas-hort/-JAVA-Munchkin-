package Munchkin;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Hort
 */
public class Round {

    Monster monster;
    Item item;

    //INICIO DO ROUND
    public Round() {
        this.monster = null;
        this.item = null;

        //PEGA 1 CARTA
        createDungeon();

        //COMEÇA A INTERAÇÃO 
        theCombat();
    }

    //PEGA UMA CARTA ALEATORIO DO DUNGEON
    void createDungeon() {
        int random;
        int monsterOrItem = (int) (Math.random() * 2 + 1);
        //1 = MONSTRO
        //2 = ITEM
        if (monsterOrItem == 1) {
            try {
                random = (int) Math.floor(Math.random() * Game.getINSTANCE().getMonsterList().size());
                this.monster = Game.getINSTANCE().monsterList.remove(random);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.println("SEM CARTAS DE MONSTRO");
            }

        } else {
            try {
                random = (int) Math.floor(Math.random() * Game.getINSTANCE().getItemList().size());
                this.item = Game.getINSTANCE().itemList.remove(random);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.println("SEM CARTAS DE ITEM");
            }
        }

    }

    //SE FOR UM MONSTRO OU ITEM
    void theCombat() {
        if (isMonster()) {
            System.out.println("\nFIGHT WITH A MONSTER");
            System.out.println(this.monster);
            gotAMonster();
        }
        if (isItem()) {
            System.out.println("\nYOU GOT AN ITEM!\n");
            System.out.println(this.item);
            gotAItem();
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Round.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Game.getINSTANCE().createRound();
    }

    //SE PEGAR UMA CARTA ALEATORIA DO DECK DE MONSTROS
    void gotAMonster() {
        Scanner read = new Scanner(System.in);
        System.out.println("\nWANT TO RUN? (YES OR NO): ");
        String option = read.nextLine().toUpperCase();

        //OPTOU POR CORRER
        if (option.equals("YES") || option.equals("Y")) {
            System.out.println(Game.getINSTANCE().getPlayer() + " OPTOU POR CORRER!");
            boolean didRun = Game.getINSTANCE().getPlayer().runAway();
            //SE NÃO CONSEGUIU CORRER
            if (!didRun) {
                fightWithMonster();
            }
            
        //OPTOU POR LUTAR
        } else {
            fightWithMonster();
        }
    }
    
    //LUTAR COM O MONSTRO
    void fightWithMonster(){
        boolean winFight = Game.getINSTANCE().getPlayer().fight(this.monster);
            //SE NÃO GANHOU
            if (!winFight) {
                this.monster.performBadStuff();
            } else {
                Game.getINSTANCE().getPlayer().addLevel();
            }
    }    
    
    //SE PEGAR UMA CARTA ALEATORIA DO DECK DE ITEM
    void gotAItem() {
        Game.getINSTANCE().getPlayer().addItem(this.item);
        System.out.println(Game.getINSTANCE().getPlayer() + " PEGOU O ITEM!");
    }

    boolean isMonster() {
        return (this.monster == null) ? false : true;
    }

    boolean isItem() {
        return (this.item == null) ? false : true;
    }

    void addRound() {

    }
}
