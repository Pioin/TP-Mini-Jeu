public class Characters{

    private int health;
    private boolean isAlive = true;


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
    public void attack(Characters target, int attackValue) // Méthode permettant a un personnage d'en attaquer un autre
    {
        if((target.health - attackValue) < 0)
        {
            target.health = 0;
        }
        else
        {
            target.health = target.health - attackValue;
        }
    }
}
