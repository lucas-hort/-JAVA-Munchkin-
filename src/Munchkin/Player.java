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
        this.level = 5;
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
    
    void loseLevel(int dmg){
        this.level -= dmg;
        setCombatLevel();
    }
    
    
    //ROLA O DADO(1 A 6)
    void rollDice(){
        System.out.println(d.rollDice());
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
    public void setCombatLevel() {
        this.combatLevel = 0;
        for(Item e : listCards){
            this.combatLevel += e.getBonus();
        }   
        this.combatLevel += level;
    }
    
    public void setListCards(Item item) {
        this.listCards.add(item);
    }
    
    
    @Override
    public String toString() {
        return "Player:" + this.name + "\nlevel =" + this.level + "\ncombatLevel=" + combatLevel + "\nlistCards=" + listCards;
    }
    
    
}