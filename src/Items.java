public class Items {
    private Dices myItemDice = new Dices(10);

    public String generateItemName()
    {
        String itemname = "Zbibou";
        switch (myItemDice.throwDice()) {
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
            case 8:
                itemname = "Sac de poils";
                return itemname;
            case 9:
                itemname = "Lave vitre";
                return itemname;
            case 10:
                itemname = "Baton de berger";
                return itemname;
            case 11:
                itemname = "Cape en béton";
                return itemname;
            default:
                return itemname;
        }
    }
    
}
