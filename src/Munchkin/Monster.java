package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public abstract class Monster extends Dungeon {
    private int level;
    private int vida;
    
    BadStuff bd;

    public Monster(int id, String name,int level, int vida) {
        super(id,name);
        this.level = level;
        this.vida = vida;
    }
    
    void setBadStuff(BadStuff bd){
        this.bd = bd;
    }
    
    void performBadStuff(){
        this.bd.badStuff();
    }

    @Override
    public String toString() {
        return "MONSTRO: " +this.getName() + "level=" + level + ", vida=" + vida + ", bd=" + bd + '}';
    }
    
}
