package Munchkin;

import java.util.ArrayList;
import java.util.List;

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
        int numberDice = rollDice();
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
            setCombatLevel();
        }
    }

    //ADD LEVEL
    void addLevel() {
        this.level += 1;
        setCombatLevel();
    }

    //ROLA O DADO(1 A 6)
    int rollDice() {
        return d.rollDice();
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
        setCombatLevel();
    }

    //RECEBE UM ITEM
    void addItem(Item item) {
        this.listCards.add(item);
        setCombatLevel();
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
    //CALCULA O COMBAT LEVEL
    public void setCombatLevel() {
        this.combatLevel = 0;
        for (Item e : listCards) {
            this.combatLevel += e.getBonus();
        }
        this.combatLevel += level;
    }

    public void setListCards(Item item) {
        this.listCards.add(item);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + "\nLevel = " + this.level + "\nCombat level = " + combatLevel + "\nList of Items ["+listCards.size()+"] = " + listCards;
    }

}
