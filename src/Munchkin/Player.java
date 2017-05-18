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
    void fight(){
        
    }
    
    //CORRE DO MONSTRO
    void runAway(){
        
    } 
    
    void loseLevel(int x){
        this.level -= x;
    }
    
    //ROLA O DADO(1 A 6)
    void rollDice(){
        System.out.println(d.rollDice());
    }
    
       

    public void setListCards(Item item) {
        this.listCards.add(item);
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
    public void setCombatLevel(int x) {
        this.combatLevel = level + x;
    }
    
    
    @Override
    public String toString() {
        return "Player{" + " name=" + this.name + ", level=" + this.level + ", combatLevel=" + combatLevel + ", listCards=" + listCards + '}';
    }
    
    
}