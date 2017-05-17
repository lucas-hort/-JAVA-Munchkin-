package Munchkin;

/**
 *
 * @author Lucas Hort
 */
public class Main {
    public static void main(String[] args) {
        Player p = new Player();
        p.rollDice();
        Game game = new Game(p);
    }
}
