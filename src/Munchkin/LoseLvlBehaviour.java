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
public class LoseLvlBehaviour implements BadStuff {
    
    int damage; 

    public LoseLvlBehaviour(int damage) {
        this.damage = damage;
    }

    //COISA RUIM DO MONSTRO
    @Override
    public void badStuff() {
        doDamageToPlayer();
        if (this.damage == -1) {
            System.out.println("AHA! O MONSTRO TIROU TODOS LEVELS DO " + Game.getINSTANCE().getPlayer());
            
            
            //*--------------- WRITER ----------*
            GameController.log += "AHA! O MONSTRO TIROU TODOS LEVELS DO " + Game.getINSTANCE().getPlayer() + "\r\n";
            //*--------------- WRITER ----------*
            
            
        } else {
            System.out.println("AHA! O MONSTRO TIROU " + damage + " LEVELS DO " + Game.getINSTANCE().getPlayer());
            
            
            //*--------------- WRITER ----------*
            GameController.log += "AHA! O MONSTRO TIROU " + damage + " LEVELS DO " + Game.getINSTANCE().getPlayer() + "\r\n";
            //*--------------- WRITER ----------*            
            
        }

    }

    private void doDamageToPlayer() {
        Game.getINSTANCE().getPlayer().loseLevel(damage);
    }

    @Override
    public String toString() {
        if (this.damage == -1) {
            return "MAKE YOU LOOSE ALL LEVELS";
        } else {
            return "MAKE YOU LOOSE " + damage + " LEVELS";
        }
    }

}
