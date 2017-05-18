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
    boolean fight(Monster monster){
        if (this.combatLevel > monster.getLevel()){
            System.out.println(this.name + " MATOU O "+ monster);
            return true;
        }else{            
            System.out.println(this.name + " PERDEU PARA "+ monster);
            return true;
        }
    }
    
    //CORRE DO MONSTRO
    boolean runAway(){
        int numberDice = rollDice();
        if (numberDice >= 3) {
            System.out.println(this.name +" CORREU!");
            return true;
        }else{
            System.out.println("INFELIZMENTE "+this.name +" LUTARÁ COM O MONSTRO!");
            return false;
        }
    } 
    
    void loseLevel(int dmg){
        this.level -= dmg;
        setCombatLevel();
    }
    
    
    //ROLA O DADO(1 A 6)
    int rollDice(){
        return d.rollDice();
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