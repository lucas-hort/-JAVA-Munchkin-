package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Item extends Dungeon{
    private int bonus;
    private String type;
    
    public Item(int id, String name,int bonus, String type) {
        super(id,name);
        this.bonus = bonus;
        this.type = type;
    }
    
    
    /*----------------------- GETTERS ----------------*/
    public int getBonus() {
        return bonus;
    }

    public String getType() {
        return type;
    }

    
    
    @Override
    public String toString() {
        return "{Item: " + this.getName() + " ,Bonus = +" + bonus + " ,Type = " + type + "}";
    }
    
    
}
