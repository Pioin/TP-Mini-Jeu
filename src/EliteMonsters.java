public class EliteMonsters extends Characters {
    Dices myEliteMonsterDice = new Dices(); 
    Dices myMagicSpellDice = new Dices();
    public EliteMonsters()
    {
        myEliteMonsterDice.setDiceMax(6);
        myMagicSpellDice.setDiceMax(6);
        this.setHealth(myEliteMonsterDice.throwDice() + myEliteMonsterDice.throwDice());
    }
}
