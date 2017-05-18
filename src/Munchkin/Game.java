/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Munchkin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Hort
 */
public class Game {    
    private static Game INSTANCE;  //INSTANCIA DA CLASSE GAME
    
    public List<Item> itemList;
    public List<Monster> monsterList;
    
    private Round round;
    private Player player;
    
    public Game(){
        
    }
    public Game(Player player, ArrayList<Item> itemList, ArrayList<Monster> monsterList) {
        //INSTANCIA O SINGLETON DA CLASSE
        this.INSTANCE = this;
        
        //INSTANCIA O PLAYER
        this.player = player;
        
        //CRIA O ROUND   
        createRound();
        
        //INICIA OS ITEMS DO PLAYER
        inicialItems();
    }   
    
    
    //ITEMS INICIAIS DO PLAYER
    void inicialItems(){
        
    }
    
    //CRIA OS ROUNDS DO GAME
    void createRound(){
        this.round = new Round();
    }
    
    
    
    /* -------------------- GETTERS -------------------*/
    //PEGA A INSTANCIA DO SINGLETON
    public static synchronized Game getINSTANCE() {
        return INSTANCE;
    }    
    
    public Player getPlayer() {
        return player;
    }
    
    
}
