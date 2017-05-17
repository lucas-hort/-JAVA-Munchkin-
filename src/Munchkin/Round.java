/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Round {
    Dungeon dungeon;
    
    void createDungeon(){
       int chance = (int)(Math.random()*2+1);
       /*
       if(chance == 1){
           //dungeon = new Monster()
       }else
           //dungeon = new Item()
        */
    }
    
    boolean isMonster(){
        
        return true;
    }
    boolean isItem(){
        
        return true;
    }
    
    void addRound(){
        
    }
}
