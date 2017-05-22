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
        for (int i = 0; i < dmg; i++) {
            if (this.level > 0) {
                this.level -= i;
            }
        }
        updateCombatLevel();
    }

    //ADD LEVEL
    void addLevel() {
        this.level += 1;
        updateCombatLevel();
    }

    //PERDE UM ITEM
    void loseItems(int numItems) {
        // numItems = NUMERO DE CARTAS QUE O MONSTRO TIRA DO PLAYER
        // -1 = TIRAR TODAS AS CARTAS

        if (numItems == -1) {
            this.listCards = new ArrayList<>();
        } else {
            for (int i = 0; i < numItems; i++) {
                if (listCards.size() > 0) {
                    this.listCards.remove(0);
                }
            }
        }
        //RECALCULA O COMBATLEVEL DO PLAYER
        updateCombatLevel();
    }

    //RECEBE UM ITEM
    void addItem(Item item) {
        this.listCards.add(item);
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

    public Item hasItem(Item item) {
        for (Item e : listCards) {
            if (e.getType().equals(item.getType())) {
                return e;
            }
        }
        return null;
    }

    public void removeAnItem(Item item) {
        listCards.remove(item);
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + "\r\nLevel = " + this.level + "\r\nCombat level = " + combatLevel + "\r\nList of Items [" + listCards.size() + "] = " + listCards;
    }

}
