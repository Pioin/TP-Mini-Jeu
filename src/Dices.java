import java.util.Random;
public class Dices 
{
    private int diceMax;
    public void setDiceMax(int max)
    {
        this.diceMax = max;
    }
    public int throwDice() 
    {
        Random rand = new Random();
        int int_random = rand.nextInt(diceMax) + 1;
        return int_random;
    }
}
