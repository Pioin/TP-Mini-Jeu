
public class Dungeons {
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
        Dices myDice = new Dices();
        myDice.setDiceMax(6);
        int floorDice;
        while(adventurer.isAlive || this.currentFloor < this.maxFloors)
        {
            floorDice = myDice.throwDice();
            System.out.print("Vous arrivez à l'étage n° ." + this.currentFloor + "\r\n");
            if(floorDice > 1 && floorDice < 6) // NORMAL MONSTER
            {
                System.out.println("Au milieu de la pièce se trouve une bète elle vous a déja repéré impossible de s'échapper");
                NormalMonsters myNormalMonster = new NormalMonsters();
                while(adventurer.isAlive && myNormalMonster.getHealth() > 0)
                {
                    System.out.println("Lancer des dés : ");
                    int adventurerThrow = adventurer.myPlayerDice.throwDice();
                    System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                    int normalMonsterThrow = myNormalMonster.myNormalMonsterDice.throwDice();
                    System.out.println("Le monstre lance un : " + normalMonsterThrow + " !");
                    if(adventurerThrow >= normalMonsterThrow)
                    {
                        System.out.println("Vous frappez le monstre il subit " + (adventurerThrow - normalMonsterThrow) + "dégats !");
                        adventurer.attack(myNormalMonster, adventurerThrow - normalMonsterThrow);
                        System.out.println("Le monstre possède maintenant " + myNormalMonster.getHealth() + " points de vie.");
                    }
                    else
                    {
                        System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                        System.out.println("Le monstre vous attaque");
                    }
                    if(myNormalMonster.getHealth() > 0)
                    {
                        if(adventurerThrow >= normalMonsterThrow)
                        {
                            System.out.println("Le monstre vous frappe, vous subissez " + (normalMonsterThrow - adventurerThrow) + "dégats !");

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
                                myNormalMonster.attack(adventurer, normalMonsterThrow - adventurerThrow);
                            }
                            System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                        }
                    }
                    if(adventurer.getHealth() == 0)
                    {
                        adventurer.setIsAlive(false);
                        System.out.println(adventurer.getName() + " a péri, c'est la fin de l'aventure.");
                    }
                }
                if (adventurer.getHealth() > 0)
                {
                    adventurer.slayAMonster();
                }
            }
            else if(floorDice == 6) // ELITE MONSTER
            {
                System.out.println("Au milieu de la pièce se trouve une bète plus grande que la moyenne elle vous a déja repéré impossible de s'échapper");
                EliteMonsters myEliteMonster = new EliteMonsters();
                while(adventurer.isAlive && myEliteMonster.getHealth() > 0)
                {
                    System.out.println("Lancer des dés : ");
                    int adventurerThrow = adventurer.myPlayerDice.throwDice();
                    System.out.println("L'aventurier lance un : " + adventurerThrow + " !");
                    int eliteMonsterThrow = myEliteMonster.myEliteMonsterDice.throwDice();
                    System.out.println("Le monstre lance un : " + eliteMonsterThrow + " !");
                    int magicAttack = myEliteMonster.myMagicSpellDice.throwDice();
                    if(adventurerThrow >= eliteMonsterThrow)
                    {
                        System.out.println("Vous frappez le monstre il subit " + (adventurerThrow - eliteMonsterThrow) + "dégats !");
                        adventurer.attack(myEliteMonster, adventurerThrow - eliteMonsterThrow);
                        System.out.println("Le monstre possède maintenant " + myEliteMonster.getHealth() + " points de vie.");
                    }
                    else
                    {
                        System.out.println("Malheureusement votre lancer n'est pas assez bon !");
                        System.out.println("Le monstre vous attaque");
                    }
                    if(myEliteMonster.getHealth() > 0)
                    {
                        if(adventurerThrow >= eliteMonsterThrow)
                        {
                            System.out.println("Le monstre vous frappe, vous subissez " + (eliteMonsterThrow - adventurerThrow) + "dégats !");

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
                                myEliteMonster.attack(adventurer, eliteMonsterThrow - adventurerThrow);
                            }
                            System.out.println("Vous possédez maintenant " + adventurer.getHealth() + " points de vie.");
                        }
                        System.out.println("Le monstre prépare une attaque magique !");
                        if(magicAttack < 6)
                        {
                            System.out.println("Le sort semble être une réussite, préparez vous a l'impact !");
                            if(adventurer.myPlayerDice.throwDice() <= 2)
                            {
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier pour se défendre du sort !");
                                System.out.println("C'est une réussite !");
                                System.out.println("L'attaque du monstre est évitée");
                            }
                            else
                            {
                                System.out.println(adventurer.getName() + " tente d'utiliser son bouclier pour se défendre du sort !");
                                System.out.println("C'est un échec !");
                                System.out.println("Le sort fonce sur vous !");
                                myEliteMonster.attack(adventurer, (magicAttack * 5));
                                System.out.println("Quelle déflagration !");
                            }
                        }
                        if(adventurer.getHealth() == 0)
                        {
                            adventurer.setIsAlive(false);
                            System.out.println(adventurer.getName() + " a péri, c'est la fin de l'aventure.");
                        }
                    }
                }
                if (adventurer.getHealth() > 0)
                {
                    adventurer.slayAMonster();
                }
            }
            else if(floorDice == 1)
            {
                System.out.println("Une pièce vide, vous marchez vers le prochain étage.");
            }
            this.currentFloor += 1;
        }
        System.out.println("L'aventure est finie pour vous, malgré tout vous avez bien combattu.");
        if(!adventurer.isAlive)
        {
            System.out.println(adventurer.getName() + " est mort à l'étage n° " + this.currentFloor);
        }
        System.out.println(adventurer.getName() + " a élliminé " + adventurer.getMonstersSlain() + " monstres.");
    }
}
