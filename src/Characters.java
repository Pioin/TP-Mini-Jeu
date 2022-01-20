public class Characters{
    int health = 100;
    boolean isAlive = false;
    public boolean isItAlive() {
        return isAlive;
    }
    public void damageCharacter(int damage)
    {
        this.health = this.health - damage;
    }
    public void healCharacter(int heal)
    {
        this.health += heal;
    }
    public int getHealth()
    {
        return this.health;
    }
    public void attack(Characters target, int attackValue) 
    {
        target.damageCharacter(attackValue);  
    }
}
