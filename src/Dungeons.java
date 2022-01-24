import java.util.Scanner;
public class Dungeons {
    Scanner in = new Scanner(System.in);
    private int currentFloor = 1;
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
    public void manageDungeon(Players adventurer)
    {
        Dices myDice = new Dices(6);
        int floorDice;
        while(adventurer.getIsAlive() == true && this.currentFloor <= this.maxFloors)
        {
            floorDice = myDice.throwDice();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Vous arrivez à l'étage n° ." + this.currentFloor + "\r\n");
            System.out.println("Vous possédez " + adventurer.getHealth() + " points de vie.");
            while(in.nextLine() == null);
            if(floorDice > 1 && floorDice < 6) // NORMAL MONSTER
            {
                System.out.println("Au milieu de la pièce se trouve une bète elle vous a déja repéré impossible de s'échapper");
                NormalMonsters myNormalMonster = new NormalMonsters();
                while(myNormalMonster.getIsAlive() == true && adventurer.getIsAlive() == true)
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Vous tentez d'attaquer le monstre");
                    System.out.println("Lancer des dés : ");
                    int adventurerThrow = adventurer.myPlayerDice.throwDice();
                    System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                    int normalMonsterThrow = myNormalMonster.myNormalMonsterDice.throwDice();
                    System.out.println("Le monstre lance un : " + normalMonsterThrow + " !");
                    if(adventurerThrow >= normalMonsterThrow)
                    {
                        System.out.println("Vous frappez le monstre il subit " + (adventurerThrow - normalMonsterThrow) + " dégats !");
                        adventurer.attack(myNormalMonster, adventurerThrow - normalMonsterThrow);
                    }
                    else
                    {
                        System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                    }
                    if(myNormalMonster.getHealth() > 0)
                    {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Le monstre tente de vous attaquer");
                        System.out.println("Lancer des dés : ");
                        adventurerThrow = adventurer.myPlayerDice.throwDice();
                        System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                        normalMonsterThrow = myNormalMonster.myNormalMonsterDice.throwDice();
                        System.out.println("Le monstre lance un : " + normalMonsterThrow + " !");
                        if(normalMonsterThrow > adventurerThrow)
                        {
                            
                            if(adventurer.myPlayerDice.throwDice() <= 2)
                            {
                                System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier !");
                                System.out.println("C'est une réussite !");
                                System.out.println("L'attaque du monstre est évitée");
                            }
                            else
                            {
                                System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier !");
                                System.out.println("C'est un échec !");
                                System.out.println("Le monstre vous attaque");
                                System.out.println("Le monstre vous frappe, vous subissez " + (normalMonsterThrow - adventurerThrow) + " dégats !");
                                myNormalMonster.attack(adventurer, normalMonsterThrow - adventurerThrow);
                            }
                            System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                        }
                        else
                        {
                            System.out.println("C'est un échec !");
                        }
                    }
                    if(adventurer.getHealth() == 0)
                    {
                        adventurer.setIsAlive(false);
                        System.out.println(adventurer.getName() + " a péri, c'est la fin de l'aventure.");
                    }
                    if(myNormalMonster.getHealth() == 0)
                    {
                        myNormalMonster.setIsAlive(false);
                        System.out.println("Vous avez éliminé le monstre !");
                        adventurer.slayAMonster();
                        if(myDice.throwDice() == 6)
                        {
                            System.out.println("Le monstre laisse tomber une orbe de vie, vous la consommez pour récupérer quelques points de vie");
                            adventurer.healCharacter(5);
                            System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                        }
                        if(myDice.throwDice() >= 5)
                        {
                            adventurer.addItem();
                        }
                    }
                }
            }
            else if(floorDice == 6) // ELITE MONSTER
            {
                System.out.println("Au milieu de la pièce se trouve une bète plus grande que la moyenne elle vous a déja repéré impossible de s'échapper");
                EliteMonsters myEliteMonster = new EliteMonsters();
                while(myEliteMonster.getIsAlive() == true && adventurer.getIsAlive() == true)
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Vous tentez d'attaquer le monstre gigantesque");
                    System.out.println("Lancer des dés : ");
                    int adventurerThrow = adventurer.myPlayerDice.throwDice();
                    System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                    int eliteMonsterThrow = myEliteMonster.throwEliteMonsterDice();
                    System.out.println("Le monstre gigantesque lance un : " + eliteMonsterThrow + " !");
                    if(adventurerThrow >= eliteMonsterThrow)
                    {
                        System.out.println("Vous frappez le monstre gigantesque il subit " + (adventurerThrow - eliteMonsterThrow) + " dégats !");
                        adventurer.attack(myEliteMonster, adventurerThrow - eliteMonsterThrow);
                        System.out.println("Le monstre gigantesque possède maintenant " + myEliteMonster.getHealth() + " points de vie.");
                    }
                    else
                    {
                        System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                    }
                    if(myEliteMonster.getIsAlive() == true)
                    {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Le monstre  gigantesque tente de vous attaquer");
                        System.out.println("Lancer des dés : ");
                        adventurerThrow = adventurer.myPlayerDice.throwDice();
                        System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                        eliteMonsterThrow = myEliteMonster.throwEliteMonsterDice();
                        System.out.println("Le monstre gigantesque lance un : " + eliteMonsterThrow + " !");
                        int magicAttack = myEliteMonster.throwMagicSpellDicee();
                        if(eliteMonsterThrow > adventurerThrow)
                        {
                            if(adventurer.myPlayerDice.throwDice() <= 2)
                            {
                                System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier !");
                                System.out.println("C'est une réussite !");
                                System.out.println("L'attaque du monstre gigantesque est évitée");
                            }
                            else
                            {
                                System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier !");
                                System.out.println("C'est un échec !");
                                System.out.println("Le monstre gigantesque vous attaque");
                                System.out.println("Le monstre gigantesque vous frappe, vous subissez " + (eliteMonsterThrow - adventurerThrow) + " dégats !");
                                myEliteMonster.attack(adventurer, eliteMonsterThrow - adventurerThrow);
                            }
                            System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                        }
                        else
                        {
                            System.out.println("C'est un échec !");
                        }
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Le monstre gigantesque prépare une attaque magique !");
                        System.out.println("Le monstre gigantesque lance un : " + magicAttack + " !");
                        if(magicAttack < 6 && adventurer.getIsAlive() == true)
                        {
                            System.out.println("Le sort semble être une réussite, préparez vous a l'impact !");
                            if(adventurer.myPlayerDice.throwDice() <= 2)
                            {
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier pour se défendre du sort !");
                                System.out.println("C'est une réussite !");
                                System.out.println("L'attaque du monstre gigantesque est évitée");
                            }
                            else
                            {
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier pour se défendre du sort !");
                                System.out.println("C'est un échec !");
                                System.out.println("Le sort fonce sur vous !");
                                myEliteMonster.attack(adventurer, (magicAttack * 5));
                                System.out.println("Quelle déflagration !");
                                System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                            }
                        }
                        else
                        {
                            System.out.println("Le sort est un échec !");
                        }

                        if(adventurer.getHealth() == 0)
                        {
                            adventurer.setIsAlive(false);
                            System.out.println(adventurer.getName() + " a péri, c'est la fin de l'aventure.");
                        }
                        if(myEliteMonster.getHealth() == 0)
                        {
                            myEliteMonster.setIsAlive(false);
                            System.out.println("Vous avez éliminé le monstre !");
                            adventurer.slayAMonster();
                            if(myDice.throwDice() == 6)
                            {
                                System.out.println("Le monstre laisse tomber une orbe de vie, vous la consommez pour récupérer quelques points de vie");
                                adventurer.healCharacter(5);
                            }
                            if(myDice.throwDice() >= 5)
                            {
                                adventurer.addItem();
                            }
                        }
                    }
                }
            }
            else 
            {
                System.out.println("Vous entrez dans une pièce vide, seule de la moisissure sur les murs est visible, vous avancez vers le prochain étage");
            }
            this.currentFloor += 1;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("L'aventure est finie pour vous, vous avez bien combattu.");
        if(adventurer.getIsAlive() == false)
        {
            System.out.println(adventurer.getName() + " est mort à l'étage n° " + this.currentFloor);
        }
        if(adventurer.ismyInventoryEmpty() == false)
        {
            adventurer.listItems();
        }
        System.out.println(adventurer.getName() + " a élliminé " + adventurer.getMonstersSlain() + " monstres.");
    }
}
