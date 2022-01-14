import java.util.Random;
public class Dices {
    public static int throwDice(int diceMax) {
        Random rand = new Random();
        int int_random = rand.nextInt(diceMax) + 1;
        return int_random;
    }
}
