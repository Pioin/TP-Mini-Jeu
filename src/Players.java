
public class Players extends Characters {
    private String gender;
    private String name;
    private int monstersSlain;
    Dices myPlayerDice = new Dices();

    public Players()   
    {
        myPlayerDice.setDiceMax(6);
        this.setHealth(100);
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getName()
    {
        return name;
    }
    public String getGender()
    {
        return gender;
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
