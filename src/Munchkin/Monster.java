package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public abstract class Monster {
    private int level;
    private String name;
    BadStuff bd;
    
    
    void setBadStuff(BadStuff bd){
        this.bd = bd;
    }
}
