public class Characters{

    private int health;
    private boolean isAlive = true;
    protected int lastDice;

    public boolean getIsAlive() // Getter retournant le booléen isAlive notifiant si un personnage est mort ou vivant
    {
        return isAlive;
    }
    public void setIsAlive(boolean isAlive) // Setter du booléen isAlive notifiant si un personnage est mort ou vivant
    {
        this.isAlive = isAlive;
    }
    public int getHealth() // Getter de la variable health 
    {
        return this.health;
    }
    public void setHealth(int health) // Setter de la variable Health
    {
        this.health = health;
    }
    public int getLastDice()
    {
        return this.lastDice;
    }
    public void damage(int attackValue)
    {
        if((this.health - attackValue) < 0)
        {
            this.health = 0;
        }
        else
        {
            this.health = this.health - attackValue;
        }
    }
    public void attack(Characters receiver) // Méthode permettant a un personnage d'en attaquer un autre
    {
        int attackValue = this.getLastDice() - receiver.getLastDice();
        receiver.damage(attackValue);
    }
}
