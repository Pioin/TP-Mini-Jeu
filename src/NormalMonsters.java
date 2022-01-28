public class NormalMonsters extends Characters
{
    private Dices myNormalMonsterDice = new Dices(6); 

    public NormalMonsters() // Constructeur personnalisé de la classe EliteMonsters
    {
        this.setHealth(myNormalMonsterDice.throwDice());
    }

    public int throwNormalMonsterDice() // Méthode permettant de jeter un dé
    {
        return this.myNormalMonsterDice.throwDice();
    }
}
