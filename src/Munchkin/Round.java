package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Round {
    Dungeon dungeon;
    Game game;

    public Round(Game game) {
        this.game = game;
        createDungeon();
    }
    
    
    
    void createDungeon(){
       int chance = (int)(Math.random()*2+1);
       if(chance == 1){
           this.dungeon = game.monsterList.get(0);
       }else{
           this.dungeon = game.itemList.get(0);
       }
      theRound();
    }
    
    
    void theRound(){
        if (isMonster()){
            System.out.println(this.dungeon.getName());
        }
        if (isItem()){
            System.out.println(this.dungeon.getName());
        }
    }
    
    
    boolean isMonster(){
        return (this.dungeon instanceof Monster) ? true : false;
    }
    boolean isItem(){
        return (this.dungeon instanceof Item) ? true : false;
    }
    
    void addRound(){
        
    }
}
