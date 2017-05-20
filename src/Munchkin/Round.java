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
        
        /*
        //PEGA 1 CARTA
        createDungeon();

        //COMEÇA A INTERAÇÃO 
        theCombat(); */
    }
    
    

    //PEGA UMA CARTA ALEATORIO DO DUNGEON
    void getARandomCard() {
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
    
    //LUTAR COM O MONSTRO
    boolean fightWithMonster(){
        boolean winFight = Game.getINSTANCE().getPlayer().fight(this.monster);
            //SE NÃO GANHOU
            if (winFight) {
                return true;                
            } else {
                return false;                
            }
    }    
    
    //SE PEGAR UMA CARTA ALEATORIA DO DECK DE ITEM
    void gotAnItem() {
        Game.getINSTANCE().getPlayer().addItem(this.item);        
    }

    boolean isMonster() {
        return (this.monster == null) ? false : true;
    }

    boolean isItem() {
        return (this.item == null) ? false : true;
    }


    
    /* -------------------- GETTERS -------------------*/
    
    public Monster getMonster() {
        return monster;
    }

    public Item getItem() {
        return item;
    }
    
    

    
    
}
