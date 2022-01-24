import java.util.Random;
public class Items {
    Dices myItemDice = new Dices(7);
    public static String generateItemName()
    {
        String itemname = "Zbibou";
        Random rand = new Random();
        int int_random = rand.nextInt(13);
        switch (int_random) {
            case 1:  
                itemname = "Epée Crocodur";  
                return itemname;
            case 2:
                itemname = "Gants du Manchot";     
                return itemname;
            case 3:  
                itemname = "Baton mou";      
                return itemname;
            case 4:      
                itemname = "Armure en Carton";
                return itemname;
            case 5:
                itemname = "Bonnet de Nuit";    
                return itemname;
            case 6:
                itemname = "Bottes trouées";    
                return itemname;
            case 7:
                itemname = "Trousse vide"; 
                return itemname;
            default:
                return itemname;
        }
    }
    
}
