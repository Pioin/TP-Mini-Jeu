public class NormalMonsters extends Characters
{
    Dices myNormalMonsterDice = new Dices(); 

    public NormalMonsters()
    {
        myNormalMonsterDice.setDiceMax(6);
        this.health = myNormalMonsterDice.throwDice();
    }
}
