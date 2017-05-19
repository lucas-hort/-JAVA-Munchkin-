package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public abstract class Monster extends Dungeon {
    private int level;
    
    BadStuff bd;

    public Monster(int id, String name,int level) {
        super(id,name);
        this.level = level;
    }
    
    void setBadStuff(BadStuff bd){
        this.bd = bd;
    }
    
    void performBadStuff(){
        this.bd.badStuff();
    }

    public int getLevel() {
        return level;
    }
    
    

    @Override
    public String toString() {
        return "MONSTRO: " +this.getName() + " ,Level = " + level + ", BadStuff = " + bd + '}';
    }
    
}
