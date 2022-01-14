public class Characters {
    String name;
    int health;
    static boolean isAlive = false;
    
    public static boolean isItAlive() {
        return isAlive;
    }
    
    public static void attack(Characters target, int maxAttack) {
        target.health = target.health - Dices.throwDice(maxAttack);
    }
}
