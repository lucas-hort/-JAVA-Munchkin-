package Munchkin;

import java.util.List;

/**
 *
 * @author Lucas Hort
 */
public class Player {
    private Dice d;
    private String name;
    private static int level;
    private int combatLevel;
    private List<Item> listCards;

    public Player(String name) {
        this.level = 0;
        this.name = name;
        this.d = new Dice();
    }  

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int x) {
        this.combatLevel = level + x;
    }
    
    
    void fight(){
        
    }
    
    void rollDice(){
        System.out.println(d.rollDice());
    }
    
    void runAway(){
        
    }

    public List<Item> getListCards() {
        return listCards;
    }

    public void setListCards(List<Item> listCards) {
        this.listCards = listCards;
    }
    
    @Override
    public String toString() {
        return "Player{" + ", name=" + name + ", level=" + level + ", combatLevel=" + combatLevel + ", listCards=" + listCards + '}';
    }
    
    
}