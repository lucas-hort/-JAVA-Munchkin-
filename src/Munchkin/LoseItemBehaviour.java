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
public class LoseItemBehaviour implements BadStuff {

    private int numItems;

    public LoseItemBehaviour(int numItems) {
        this.numItems = numItems;
    }

    @Override
    public void badStuff() {
        takeOneItem();
        if (numItems == -1) {
            System.out.println("VIXE! O MONSTRO TIROU TODOS ITEMS DO " + Game.getINSTANCE().getPlayer());
        } else {
            System.out.println("VIXE! O MONSTRO TIROU " + this.numItems + " ITEMS DO " + Game.getINSTANCE().getPlayer());
        }
    }

    public void takeOneItem() {
        Game.getINSTANCE().getPlayer().removeItems(this.numItems);
    }

    @Override
    public String toString() {
        if (numItems == -1) {
            return "YOU LOOSE ALL ITEMS";
        } else {
            return "YOU LOOSE " + this.numItems + " ITEMS";
        }
    }

}
