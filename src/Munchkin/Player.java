package Munchkin;

import java.util.List;

/**
 *
 * @author Lucas Hort
 */
public class Player {
    Dice d;
    String name;
    int level;
    int combatLevel;
    List<Item> listCards;

    public Player() {
        this.d = new Dice();
    }
    
    
    
    void fight(){
        
    }
    
    void rollDice(){
        System.out.println(d.rollDice());
    }
    
    void runAway(){
        
    }
}
