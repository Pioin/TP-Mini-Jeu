public class EliteMonsters extends Characters {

    private Dices myEliteMonsterDice = new Dices(6); 
    private Dices myMagicSpellDice = new Dices(6);

    public EliteMonsters() // Constructeur personnalisé de la classe EliteMonsters
    {
        this.setHealth((myEliteMonsterDice.throwDice() + myEliteMonsterDice.throwDice()));
    }
    public int throwEliteMonsterDice() // Méthode permettant de jeter un dé
    {
        return this.myEliteMonsterDice.throwDice();
    }
    public int throwMagicSpellDicee() // Méthode permettant de jeter un dé
    {
        return this.myMagicSpellDice.throwDice();

    }
}
