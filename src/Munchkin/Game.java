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
    
    //BARALHO DE ITEMS E MONSTROS
    public List<Item> itemList;
    public List<Monster> monsterList;    
    
    private Round round;
    private Player player;
    
    private Game() {
    } 
    
    //CRIA OS ROUNDS DO GAME, SE O PLAYER ATINGIR LVL 10 OU NUMERO DE ROUNDS EXCEDER 20 PARTIDAS ACABA O GAME
    boolean createRound(){        
        //END OF THE GAME
        if (this.numberOfRounds >= 20 || this.player.getLevel() >= 10){
            return true;
        //NEXT ROUND
        }else{
            this.numberOfRounds++;
            //CRIA UMA RODADA
            this.round = new Round();
            return false;
        }        
    }
    
    
    
    /* -------------------- GETTERS -------------------*/
    //PEGA A INSTANCIA DO SINGLETON
    public static synchronized Game getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new Game();
        return INSTANCE;
    }    
    
    public Player getPlayer() {
        return this.player;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }
    
    public List<Monster> getMonsterList() {
        return this.monsterList;
    }
    
    public Round getRound() {
        return this.round;
    }

    public static int getNumberOfRounds() {
        return numberOfRounds;
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
        this.player = p;
    }

    @Override
    public String toString() {
        return "Game{" + "itemList=" + itemList + ", monsterList=" + monsterList + ", player=" + player + '}';
    }
    
    
    
    
    
    
    
}
