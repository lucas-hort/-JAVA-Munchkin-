package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Round {
    Monster monster;
    Item item;

    
    //INICIO DO ROUND
    public Round() {
        createDungeon();
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
        this.monster.performBadStuff();
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
