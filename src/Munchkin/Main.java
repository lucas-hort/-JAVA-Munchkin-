package Munchkin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Hort
 */
public class Main {
    public static void main(String[] args) {
        
        List<Item> itemList = new ArrayList<>();
        List<Monster> monsterList = new ArrayList<>();
        Item item1 = new Item(0, "Item1", 3, "Mão");
        Item item2 = new Item(1, "Item2", 1, "Braço");
        Item item3 = new Item(2, "Item3", 2, "Perna");
        Item item4 = new Item(3, "Item4", 3, "Peito");
        Item item5 = new Item(4, "Item5", 1, "Cabeça");
        Item item6 = new Item(5, "Item6", 2, "Pé");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        
        
        Monster monster1 = new MonsterLoseLvl(0, "Pé de feijão", 10,3);
        Monster monster2 = new MonsterLoseLvl(1, "Matador de galinha", 5,3);
        Monster monster3 = new MonsterLoseLvl(2, "Animal de 3 olhos", 9,3);
        Monster monster4 = new MonsterLoseItem(3, "Calculo 4", 20);
        Monster monster5 = new MonsterLoseItem(3, "Calculo 5", 30);
        Monster monster6 = new MonsterLoseItem(3, "Calculo 6", 40);
        monsterList.add(monster1);
        monsterList.add(monster2);
        monsterList.add(monster3);    
        monsterList.add(monster4);
        monsterList.add(monster5);
        monsterList.add(monster6);    
        
        Player p = new Player("Lucas Hort");
        
        //SETTANDO O GAME
        Game.getINSTANCE().setItemList(itemList);
        Game.getINSTANCE().setMonsterList(monsterList);
        Game.getINSTANCE().setPlayer(p);
            
        //TESTANDO O PLAYER
        System.out.println("\n---------------- STATUS INICIAL DO PLAYER! -------------");
        Game.getINSTANCE().inicialItems();
        Game.getINSTANCE().getPlayer().setCombatLevel();
        System.out.println(Game.getINSTANCE().getPlayer());
        
        
        System.out.println("\n---------------- TESTANDO ROUNDS -------------");
        //TESTANDO RODADA
        Game.getINSTANCE().createRound();
        
    }
}
