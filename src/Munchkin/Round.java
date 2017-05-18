package Munchkin;

import java.util.Scanner;

/**
 *
 * @author Lucas Hort
 */
public class Round {
    Monster monster;
    Item item;
    

    
    
    //INICIO DO ROUND
    public Round() {
        this.monster = null;
        this.item = null;
        //PEGA 1 CARTA
        createDungeon();
        //COMEÇA A INTERAÇÃO 
        theCombat();
    }    
    
    
    //PEGA UMA CARTA ALEATORIO DO DUNGEON
    void createDungeon(){
        int random = (int)Math.floor(Math.random()*Game.getINSTANCE().getMonsterList().size());
        this.monster = Game.getINSTANCE().monsterList.get(random);  
        System.out.println(this.monster);
    }
        
    //SE FOR UM MONSTRO OU ITEM
    void theCombat(){
        if (isMonster()){
            gotAMonster();        
        }
        if (isItem()){
            System.out.println(this.item.getName());
        }
    }    
    
    
    //PEGA UMA CARTA ALEATORIA DO DECK DE MONSTROS
    void gotAMonster(){     
        Scanner read = new Scanner(System.in);
        System.out.println("\nWANT TO RUN? (YES OR NO): ");
        String option = read.nextLine().toUpperCase();
        
        //OPTOU POR CORRER
        if (option.equals("YES") || option.equals("Y")){
            System.out.println(Game.getINSTANCE().getPlayer() + " OPTOU POR CORRER!");
            boolean didRun = Game.getINSTANCE().getPlayer().runAway();
            //SE CONSEGUIU CORRER
            if(didRun){
                //FIM
            }
            //SE NAO CONSEGUIU CORRER
            else{
               Game.getINSTANCE().getPlayer().fight(this.monster);  
            }              
            
        //OPTOU POR LUTAR
        }else{
            
            boolean winFight = Game.getINSTANCE().getPlayer().fight(this.monster);
            //SE GANHOU
            if (winFight){
                //FIM
            }else{
                this.monster.performBadStuff();
            }            
        }        
    }
        
    
    boolean isMonster(){
        return (this.monster == null) ? false : true;
    }
    boolean isItem(){
        return (this.item == null) ? false : true;
    }
    
    void addRound(){
        
    }
}
