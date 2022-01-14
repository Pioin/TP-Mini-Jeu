import java.util.Random;
public class Dungeons {
    Random rand = new Random();
    private int actualFloor = 1;
    private int maxFloors;
    public void setMaxFloors(String difficulte)
    {        
        switch (difficulte) {
            case "facile":      
                maxFloors = 10;
                break;
            case "moyen":
                maxFloors = 20;
                break;
            case "difficile":
                maxFloors = 30;
                break;
            default:
                maxFloors = 40;
                break;
        }
    }
    public int getMaxFloors()
    {
        return maxFloors;
    } 
    public void generateFloor(Players adventurer)
    {
        Dices myDice = new Dices();
        myDice.setDiceMax(6);
        int floorDice;
        System.out.print("Vous arrivez à l'étage n° ." + this.actualFloor + "\r\n");
        floorDice = myDice.throwDice();
        if(floorDice > 1 && floorDice < 6)
        {
            System.out.println("Au milieu de la pièce se trouve une bète elle vous a déja repéré impossible de s'échapper");
            NormalMonsters myNormalMonster = new NormalMonsters();
            while(adventurer.getHealth() > 0 || myNormalMonster.getHealth() > 0)
            {

            }
        }
        else if(floorDice == 6)
        {
            System.out.println("Au milieu de la pièce se trouve une bète plus grande que la moyenne elle vous a déja repéré impossible de s'échapper");
            EliteMonsters myEliteMonster = new EliteMonsters();
            while(adventurer.getHealth() > 0 || myEliteMonster.getHealth() > 0)
            {
                
            }
        }
        else if(floorDice == 1)
        {
            System.out.println("Une pièce vide, vous marchez vers le prochain étage.");
        }
    }
}
