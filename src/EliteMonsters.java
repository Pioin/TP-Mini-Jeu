public class EliteMonsters extends Characters {
    Dices myEliteMonsterDice = new Dices(); 
    Dices myMagicSpellDice = new Dices();
    public void EliteMonsters()
    {
        myEliteMonsterDice.setDiceMax(6);
        myMagicSpellDice.setDiceMax(6);
        generateNormalMonster();
    }

    public void generateNormalMonster()
    {
        this.health = myEliteMonsterDice.throwDice();
    }

    public int getHealth()
    {
        return this.health;
    }
    public static void throwMagicSpell()
    {
        
    }
}
