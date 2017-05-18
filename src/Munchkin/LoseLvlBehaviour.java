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
public class LoseLvlBehaviour implements BadStuff{
    int vida;

    public LoseLvlBehaviour(int vida) {
        this.vida = vida;
    }
    
    //COISA RUIM DO MONSTRO
    @Override
    public void badStuff() {
        doDamageToPlayer();
        System.out.println("AHA! O monstro tirou "+vida+ " levels do Player: "+Game.getINSTANCE().getPlayer());        
        
    }
    
    public void doDamageToPlayer(){
        Game.getINSTANCE().getPlayer().loseLevel(vida);
    }

    
    @Override
    public String toString() {
        return "MAKE O LOOSE " + vida + " LEVELS";
    }
    
    
    
}
