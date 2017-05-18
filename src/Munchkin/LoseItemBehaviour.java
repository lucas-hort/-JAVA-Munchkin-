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

    @Override
    public void badStuff() {
        System.out.println("VIXE! O monstro tirou um item do " + Game.getINSTANCE().getPlayer());  
    }

    public void takeOneItem(){
        Game.getINSTANCE().getPlayer().removeItem();
    }
    
    @Override
    public String toString() {
        return "YOU LOOSE A ITEM";
    }
    
    
    
}
