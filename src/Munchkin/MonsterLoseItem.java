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
public class MonsterLoseItem extends Monster{

    public MonsterLoseItem(int id, String name,int level) {
        super(id,name,level);
        this.bd = new LoseItemBehaviour();
        
    }
    
}
