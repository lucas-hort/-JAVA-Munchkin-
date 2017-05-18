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
    
    //ITEMS INICIAIS DO PLAYER
    void inicialItems(){
        int random;
        
        //TIRA 3 CARTAS ALEATORIAS DO BARALHO DE ITEM
        for (int i = 0; i < 3; i++) {            
            random = (int)Math.floor(Math.random()*itemList.size());
            this.player.setListCards(itemList.remove(random));
        }        
    }
    
    //CRIA OS ROUNDS DO GAME
    void createRound(){
        if (numberOfRounds >= 2){
            System.out.println("\nFIM DO JOGO!!!!!!!!");
        }else{
            this.numberOfRounds++;
            System.out.println("\nNUMERO DO ROUND : "+numberOfRounds);
            this.round = new Round();            
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
