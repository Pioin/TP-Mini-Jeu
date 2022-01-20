
public class Players extends Characters {
    private String gender;
    private String name;
    private int monstersSlain;
    Dices myPlayerDice = new Dices();

    public Players()   
    {
        myPlayerDice.setDiceMax(6);
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }
    public String getName()
    {
        return name;
    }
    public String getGender()
    {
        return gender;
    }
    public boolean getIsAlive()
    {
        return isAlive;
    }
    public void slayAMonster()
    {
        this.monstersSlain += 1;
    }
    public int getMonstersSlain()
    {
        return monstersSlain;
    }
}
