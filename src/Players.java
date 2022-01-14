public class Players extends Characters {
    private String gender;
    private String name;
    private int monsterSlain;
    private String inventory[];
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
    public void damagePlayer(int damage)
    {
        this.health -= damage;
    }
    public void healPlayer(int heal)
    {
        this.health += heal;
    }
    public int getHealth()
    {
        return this.health;
    }


}
