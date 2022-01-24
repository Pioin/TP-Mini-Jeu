public class NormalMonsters extends Characters
{
    Dices myNormalMonsterDice = new Dices(6); 

    public NormalMonsters()
    {
        this.setHealth(myNormalMonsterDice.throwDice());
    }

    public int throwNormalMonsterDice()
    {
        return this.myNormalMonsterDice.throwDice();
    }
}
