import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Players myPlayer = new Players();
        Dungeons myDungeon = new Dungeons();
        System.out.println("Bienvenue aventurier !");
        System.out.println("Quel sera le genre de ton Hero ?");
        myPlayer.setGender(in.next());
        System.out.println("Quel sera le nom de ton Hero ?");
        myPlayer.setName(in.next()); 
        System.out.println("Bienvenue " + myPlayer.getName() + " !");
        System.out.println("Quelle sera la difficulté de ton aventure " + myPlayer.getName() + " ?");
        System.out.println("Attention \"facile\" correspond a 10 étages, \"moyen\" correspond a 20 et enfin \"difficile\" a 30 étages.");
        myDungeon.setMaxFloors(in.next());
        System.out.println("Très bien, ton aventure se fera sur " + myDungeon.getMaxFloors() + " étages");
        System.out.println("Ton aventure commence, bon courage aventurier !");
        myDungeon.manageDungeon(myPlayer);
    }
}
