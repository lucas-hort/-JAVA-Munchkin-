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
    }
}
