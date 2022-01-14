import java.util.Random;
public class Items {
    public static String generateItemName(){
        String ItemName = "Zbibou";
        Random rand = new Random();
        int int_random = rand.nextInt(13);
        switch (int_random) {
            case 1:      
                return ItemName;
            default:
                return ItemName;
        }
    }
    
}
