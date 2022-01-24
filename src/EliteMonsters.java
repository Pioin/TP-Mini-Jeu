public class EliteMonsters extends Characters {

    private Dices myEliteMonsterDice = new Dices(6); 
    private Dices myMagicSpellDice = new Dices(6);

    public EliteMonsters() // 
    {
        this.setHealth((myEliteMonsterDice.throwDice() + myEliteMonsterDice.throwDice()));
    }
    public int throwEliteMonsterDice()
    {
        return this.myEliteMonsterDice.throwDice();
    }
    public int throwMagicSpellDicee()
    {
        return this.myMagicSpellDice.throwDice();

    }
}
