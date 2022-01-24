public class Characters{
    int health;
    boolean isAlive = true;

    public boolean getIsAlive() 
    {
        return isAlive;
    }
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }
    public void damageCharacter(int damage)
    {
        if((this.health - damage) < 0)
        {
            this.health = 0;
        }
        else
        {
            this.health = this.health - damage;
        }
    }
    public void healCharacter(int heal)
    {
        if((this.health + heal) > 100)
        {
            this.health = 100;
        }
        else
        {
            this.health = this.health + heal;
        }
    }
    public int getHealth()
    {
        return this.health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public void attack(Characters target, int attackValue) 
    {
        target.damageCharacter(attackValue);
    }
}
