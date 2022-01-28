public class EliteMonsters extends Characters {

    private Dices myEliteMonsterDice = new Dices(6); 
    private Dices myMagicSpellDice = new Dices(6);
    private int lastMagicDice;
    private int magicMultiplier = 3;

    public EliteMonsters() // Constructeur personnalisé de la classe EliteMonsters
    {
        this.setHealth((myEliteMonsterDice.throwDice() + myEliteMonsterDice.throwDice()));
    }
    public int throwEliteMonsterDice() // Méthode permettant de jeter un dé
    {
        lastDice = this.myEliteMonsterDice.throwDice();
        return lastDice;
    }
    public int throwMagicSpellDice() // Méthode permettant de jeter un dé
    {
        lastMagicDice = this.myMagicSpellDice.throwDice();
        return lastMagicDice;
    }
    public int getLastMagicDice()
    {
        return this.lastMagicDice;
    }
    public void magicAttack(Characters receiver)
    {
        int blastvalue = this.lastMagicDice * magicMultiplier;
        receiver.damage(blastvalue);
    }
}
