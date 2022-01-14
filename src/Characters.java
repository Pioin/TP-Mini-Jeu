public class Characters {
    int health = 100;
    static boolean isAlive = false;
    
    public static boolean isItAlive() {
        return isAlive;
    }
    
    public static void attack(Characters target, int maxAttack) {
        Dices attackDice = new Dices();
        target.health = target.health - attackDice.throwDice();
    }
}
