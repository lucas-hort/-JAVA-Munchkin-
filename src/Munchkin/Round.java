package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Round {
    Monster monster;
    Item item;
    Game game;

    public Round() {
        createDungeon();
    }
    
    
    
    void createDungeon(){
       //int chance = (int)(Math.random()*2+1);
       int chance = 1;
       if(chance == 1){
           this.monster = Game.getINSTANCE().monsterList.get(0);
       }else{
           this.item = Game.getINSTANCE().itemList.get(0);
       }
      theRound();
    }
    
    
    void theRound(){
        if (isMonster()){
            System.out.println(this.monster.toString());
            this.monster.performBadStuff();
        }
        if (isItem()){
            System.out.println(this.item.getName());
        }
    }
    
    
    boolean isMonster(){
        return (this.monster instanceof Monster) ? true : false;
    }
    boolean isItem(){
        return (this.item instanceof Item) ? true : false;
    }
    
    void addRound(){
        
    }
}
