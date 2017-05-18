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

    @Override
    public String toString() {
        return "Item{" + "bonus=" + bonus + ", type=" + type + '}';
    }
    
    
}
