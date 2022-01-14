public class NormalMonsters extends Characters
{
    Dices myNormalMonsterDice = new Dices(); 

    public void NormalMonsters()
    {
        myNormalMonsterDice.setDiceMax(6);
        generateNormalMonster();
    }

    public void generateNormalMonster()
    {
        this.health = myNormalMonsterDice.throwDice();
    }

    public int getHealth()
    {
        return this.health;
    }

}
