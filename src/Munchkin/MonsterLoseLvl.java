package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class MonsterLoseLvl extends Monster{

    //dmg == vida que o Player vai perder!
    public MonsterLoseLvl(int id, String name,int level, int dmg) {
        super(id,name,level);
        this.bd = new LoseLvlBehaviour(dmg);
    }
    
}
