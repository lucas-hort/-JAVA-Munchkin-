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
        
        
        Monster monster1 = new MonsterLoseLvl(0, "Leperchaun", 4,1); // 1 level
        Monster monster2 = new MonsterLoseLvl(1, "Squidzilla", 18,3);// 2 levels
        Monster monster3 = new MonsterLoseLvl(2, "Harold Angel", 6,1); // 1 level
        Monster monster4 = new MonsterLoseLvl(3, "Undead Horse", 4,1); // 1 level
        Monster monster5 = new MonsterLoseLvl(4, "Knight of The Living Dead", 11,2); //2 levels
        Monster monster6 = new MonsterLoseItem(5, "The Ether Bunny", 8); // 1 item
        Monster monster7 = new MonsterLoseItem(6, "Duck Holliday", 6);// 1 item
        Monster monster8 = new MonsterLoseItem(7, "Dragonfly ", 10);// 1 item
        Monster monster9 = new MonsterLoseItem(8, "Blue-Eyes White Dragon", 30);// all fucking items
        Monster monster10 = new MonsterLoseItem(9, "A Mimic?!!", 15);// 2 items
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
