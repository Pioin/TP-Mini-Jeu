import java.util.*;

public class Players extends Characters {
    private String gender;
    private String name;
    private int monstersSlain;     
    private List<String> myInventory = new ArrayList<String>();
    private Dices myPlayerDice = new Dices(6);
    private Items myItems = new Items();

    public Players()
    {
        this.setHealth(100);
    }
    public void setName(String name) // Setter de la variable name
    {
        this.name = name;
    }
    public void setGender(String gender) // Getter de la variable gender
    {
        this.gender = gender;
    }
    public String getName() // Getter de la variable name
    {
        return name;
    }
    public String getGender() // Getter de la variable Gender
    {
        return gender;
    }
    public int throwPlayerDice() // Méthode permettant de jeter un dé
    {
        lastDice = this.myPlayerDice.throwDice();
        return lastDice;
    }
    public void slayAMonster() // Méthode permettant de compter le nombre de monstres tués
    {
        this.monstersSlain += 1;
    }
    public int getMonstersSlain() // Méthode retournant le nombre de monstres tués
    {
        return monstersSlain;
    }
    public void healCharacter(int heal) // Méthode permettant de rendre des pv a un personnage
    {
        if((this.getHealth() + heal) > 100)
        {
            this.setHealth(100);
        }
        else
        {
            this.setHealth(this.getHealth() + heal);
        }
    }
    public void addItem() // Méthode permettant de générer puis d'ajouter un objet a un personnage
    {
        String itemDrop = myItems.generateItemName();
        System.out.println("Le monstre laisse tomber quelque chose !");
        System.out.println("Une étiquette est fort heureusement collée sur l'objet : \" " + itemDrop +" \" !");
        System.out.println("Vous mettez ce bijoux dans votre sac a objets.");
        this.myInventory.add(itemDrop);
    }
    public void listItems() // Méthode permettant de lister les objets dans l'inventaire d'un joueur
    {
        System.out.println("Voila la liste des objets obtenus durant votre aventure");
        for(String item:myInventory)
        {
            System.out.println("- " + item);
        }
    }
    public boolean ismyInventoryEmpty() // Méthode renvoyant un booléen "true" so l'inventaire du joueur est vide
    {
        return this.myInventory.isEmpty();
    }
}
