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
    
    //LUTA COM O MONSTRO
    void fight(){
        
    }
    
    //CORRE DO MONSTRO
    void runAway(){
        
    } 
    
    //ROLA O DADO(1 A 6)
    void rollDice(){
        System.out.println(d.rollDice());
    }
    
       

    public void setListCards(List<Item> listCards) {
        this.listCards = listCards;
    }
    
    /*----------------------- GETTERS ----------------*/
    public List<Item> getListCards() {
        return listCards;
    }
    public int getCombatLevel() {
        return combatLevel;
    }
    
    
    /*----------------------- SETTERS ----------------*/
    public void setCombatLevel(int x) {
        this.combatLevel = level + x;
    }
    
    
    @Override
    public String toString() {
        return "Player{" + ", name=" + name + ", level=" + level + ", combatLevel=" + combatLevel + ", listCards=" + listCards + '}';
    }
    
    
}