public class Dungeons {
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
        
    }
}
