import java.util.Random;
public class Dices 
{
    private int diceMax;

    public Dices(int max) // Constructeur de la classe Dé
    {
        this.diceMax = max;
    }
    public int throwDice() // Lance un dé dont la valeur sera entre 1 et la valeur max spécifiée a l'instanciation du dé.
    {
        Random rand = new Random();
        int int_random = rand.nextInt(diceMax) + 1;
        return int_random;
    }
}
