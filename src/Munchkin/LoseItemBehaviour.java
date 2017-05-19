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
public class LoseItemBehaviour implements BadStuff{
    private int item;

    public LoseItemBehaviour(int item) {
        this.item = item;
    }    
    
    @Override
    public void badStuff() {
        takeOneItem();
        System.out.println("VIXE! O monstro tirou "+this.item+" items do " + Game.getINSTANCE().getPlayer());  
    }

    public void takeOneItem(){
        Game.getINSTANCE().getPlayer().removeItems(this.item);
    }
    
    @Override
    public String toString() {
        return "YOU LOOSE "+this.item+" ITEMS";
    }
    
    
    
}
