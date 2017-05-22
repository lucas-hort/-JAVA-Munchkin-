/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Munchkin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Hort
 */
public class Dice {
    
    int rollDice(){
        System.out.println("\nRolando o dado....");
        
        //*--------------- WRITER ----------*
        GameController.log += "\r\nRolando o dado...." + "\r\n";
        //*--------------- WRITER ----------* 
        
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dice.class.getName()).log(Level.SEVERE, null, ex);
        }
        int number = (int)(Math.random()*6+1);
        System.out.println("Você tirou "+number+ " no DADO!");
        
        //*--------------- WRITER ----------*
        GameController.log += Game.getINSTANCE().getPlayer().getName() + "tirou "+number+ " no DADO!" + "\r\n";
        //*--------------- WRITER ----------* 
        
        
        return number;        
    }
}
