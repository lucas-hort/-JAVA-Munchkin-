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
    private static int numberOfRounds = 0; //NÚMERO DE ROUNDS
    
    public List<Item> itemList;
    public List<Monster> monsterList;
    
    private Round round;
    private Player player;
    
    private Game() {
    }       
    
    //ITEMS INICIAIS DO PLAYER
    void inicialItems(){
        
    }
    
    //CRIA OS ROUNDS DO GAME
    void createRound(){
        this.round = new Round();
        this.numberOfRounds++;
    }
    
    
    
    /* -------------------- GETTERS -------------------*/
    //PEGA A INSTANCIA DO SINGLETON
    public static synchronized Game getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new Game();
        return INSTANCE;
    }    
    
    public Player getPlayer() {
        return player;
    }

    public List<Item> getItemList() {
        return itemList;
    }
    
    public List<Monster> getMonsterList() {
        return monsterList;
    }
    
    public Round getRound() {
        return round;
    }

    
    /* -------------------- SETTERS -------------------*/
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }    

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }    

    public void setRound(Round round) {
        this.round = round;
    }
    
    public void setPlayer(Player p){
        this.player = player;
    }

    @Override
    public String toString() {
        return "Game{" + "itemList=" + itemList + ", monsterList=" + monsterList + ", player=" + player + '}';
    }
    
    
    
    
    
    
    
}
