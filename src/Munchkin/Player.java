package Munchkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lucas Hort
 */
public class Player {

    private Dice d;
    private String name;
    private int level;
    private int combatLevel;
    private List<Item> listCards;

    //GEARS
    private Item ONEHAND;
    private Item TWOHANDS;
    private Item HEADGEAR;
    private Item FOOTGEAR;
    private Item BIG;

    public Player(String name) {
        this.level = 0;
        this.name = name;
        this.d = new Dice();
        this.listCards = new ArrayList<>();
    }

    //LUTA COM O MONSTRO
    boolean fight(Monster monster) {
        if (this.combatLevel > monster.getLevel()) {
            return true;
        } else {
            return false;
        }
    }

    //CORRE DO MONSTRO
    boolean runAway() {
        int numberDice = d.rollDice();
        if (numberDice >= 3) {
            return true;
        } else {
            return false;
        }
    }

    //PERDE LEVEL
    void loseLevel(int dmg) {
        if (this.level != 0) {
            this.level -= dmg;
            updateCombatLevel();
        }
    }

    //ADD LEVEL
    void addLevel() {
        this.level += 1;
        updateCombatLevel();
    }

    //PERDE UM ITEM
    void removeItems(int numItems) {
        // numItems = NUMERO DE CARTAS QUE O MONSTRO TIRA DO PLAYER
        // -1 = TIRAR TODAS AS CARTAS

        if (numItems == -1) {
            this.listCards = new ArrayList<>();
        } else {
            for (int i = 0; i < numItems; i++) {
                if (listCards.size() > 0) {
                    this.listCards.remove(i);
                }
            }
        }
        //RECALCULA O COMBATLEVEL DO PLAYER
        updateCombatLevel();        
    }

    //RECEBE UM ITEM
    void addItem(Item item) {
        setListCards(item);
        updateCombatLevel();
    }
    
    //CALCULA O COMBAT LEVEL
    public void updateCombatLevel() {
        this.combatLevel = 0;
        for (Item e : listCards) {
            this.combatLevel += e.getBonus();
        }
        this.combatLevel += level;
    }

    /*----------------------- GETTERS ----------------*/
    public List<Item> getListCards() {
        return listCards;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    /*----------------------- SETTERS ----------------*/
    public void setListCards(Item item) {
        System.out.println(" \nITEM RECEBIDO: "+item);
        Scanner entrada = new Scanner(System.in);
        int sizeOfArray = listCards.size();
        boolean hasItem = false;
        if(listCards.isEmpty()){
              this.listCards.add(item);          
        }else{ 
            for (int i = 0; i < sizeOfArray; i++) {                
                //SE O TIPO DO ITEM FOR IGUAL AO JA EXISTENTE NO INVENTARIO
                
                //SE FOR IGUAL
                if(listCards.get(i).getType().equals(item.getType())){
                    System.out.println("VOCÊ JA TEM UM ITEM DO TIPO "+listCards.get(i).getType());
                    System.out.println("DESEJA ALTERAR O ITEM: "+listCards.get(i)+ " [YES / NO]?");
                    String choice = entrada.nextLine().toUpperCase();
                    if(choice.equals("YES") || choice.equals("Y")){
                        listCards.remove(listCards.get(i));
                        listCards.add(item);
                        hasItem = true;
                        break;
                    } 
                }                                   
            }
            if(!hasItem)
                this.listCards.add(item);
        }
        
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + "\nLevel = " + this.level + "\nCombat level = " + combatLevel + "\nList of Items [" + listCards.size() + "] = " + listCards;
    }

}
