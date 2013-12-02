/*
Name - Braeden Christensen & Steele Anderson
Assignment: A10- Team Project
*/

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class SmackAMon
{
	//pre-game initialization stuff
	//So much static variables. This needs to be fixed, but considering that I can't access anything in the battle
	//method without doing this, it makes things difficult.
	//This is the first thing to refactor!
	//Critter initialization

	static Critters critter0 = new Critters("Null", "Null", 10, 30);
	static Critters critter1 = new Critters("Unoze", "Card Flip", 5, 20);
	static Critters critter2 = new Critters("Doce", "DoubleShot", 10, 40);
	static Critters critter3 = new Critters("Blob", "Glob", 4, 20);
	static Critters critter4 = new Critters("Rat", "Bite", 2, 10);
	static Critters critter5 = new Critters("Golem", "Stone Crush", 10, 50);
	static Critters critter6 = new Critters("Treant", "Branch Smash", 20, 10);
	static Critters critter7 = new Critters("Samhain", "Ghoul Face", 10, 12);
	
	//Arrays to hold the critters available.
	static ArrayList<Critters> myCritters = new ArrayList(0);
	static ArrayList<Critters> sleepingCritters = new ArrayList(0);
	
	//Room initialization
	static Rooms north = new Rooms("North", critter3);
	static Rooms west = new Rooms ("West", critter4);
	static Rooms south = new Rooms("South", critter5);
	static Rooms east = new Rooms("East", critter6);
	static Rooms central = new Rooms("Cental", critter7);
	
	//Assign us to the starting location.
	static Rooms location = central;
	
	//Some Global Variables needed to establish a lose condition
	static boolean win = false;
	static boolean lose = false;
	
	static Random rand = new Random();
	
	public static void main(String[] args)
	{	
		
		//fields 
		//Player Information 
		String name;	
		
		//Method-only Accessible Fields
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		String selection;
		
		//introductory stuff
		System.out.println("Welcome to SmackAMon, the most adorable monster abuse simulator in\nalpha version EVER!\n");
		System.out.print("And what is your name?: ");
		
		name = input.next();
		
		System.out.printf("Oh! So your name is %s?\n", name);
		System.out.println("We are going to start you with two critters! An Unoze, and a Doche. Have fun!\n\nDon't die!\n\n");
		myCritters.add(critter1);
		myCritters.add(critter2);
		//Intro done
		
		//This is the parser. Takes in input, and runs it through a selection,
		//after being forced to lowercase. This helps reduce the amount of false
		//rejections for a logically sensible command.
		
		do 
		{
			System.out.printf("You are currently in the %s section.%n%n", location.getDirection());
			System.out.println("Make your selection! Type 'help' for aid:");
			selection = input.next();
			selection = selection.toLowerCase();

			switch(selection)
			{
				case "help": System.out.print("Type a cardinal direction such as 'north' direction to navigate to that area!\nType in search to find something to abuse!\nType 'quit' to end!\n");
							 break;
				case "search": System.out.print("Locating something to abuse...!!\n\n");
							   if ((rand.nextInt(25) + 1) >= 11)
							   {
								   System.out.printf("Found a %s!%n", location.getCritter().getName());
								   doBattle();  
							   }
							   else
							   {
								   System.out.print("Huh. Nothing here. Try again!\n");
							   }
							   break;
				case "north" : System.out.println("You head north, entering a grassy plain! What do you do?");
							   location = north;
							   break;
				
				case "south": System.out.println("You head south, entering the beach! What now?");
							  location = south;
							  break;
							  
				case "east" : System.out.println("You head east, entering the city! What now?");
							  location = east;
							  break;
							  
				case "west" : System.out.println("You head west, into the sweltering desert! What now?");
							  location = west;
							  break;
							  
				case "central" : System.out.println("You head to the beginning! What now?");
								 location = central;
								 break;
				case "quit": System.out.print("Goodbye!\n");
							 break;

				default: System.out.print("That is not a valid selection. Please type help for aid!\n\n");
						 break;
			}			

		}
		while(!selection.equals("quit") && !selection.equals("exit"));
	}
	
	
	public static void doBattle()
	{
		//fields
		//Non static fields needed for method to work
		Scanner input = new Scanner(System.in);	
		Critters critterSelected = critter0;

		String selection;
		
		//Critter Initialization for battle
		//Template critter is initialized for use as a placeholder so that we can compile.
		//This assigns the critter we are going to fight.
		Critters critterInRoom = location.getCritter();
		
		//The below tells the player what critters they have available.
		System.out.println("Select a critter to fight for you! Select using a number!");
		System.out.println("You have: ");
	
		for(int i = 0; i < myCritters.size(); i++)
		{
			System.out.printf("%s: %s%n%n", i + 1, myCritters.get(i).getName());
		}
		
		selection = input.next();
		selection = selection.toLowerCase();
		
		//perform critter assignment
		switch(selection)
		{
			case "1": 
					if(critter1.getCurrentHealth() > 0)
					{
						critterSelected = critter1;
						System.out.printf("Go %s!%n", critterSelected.getName());
						break;
					}
							
			case "2": if(critter2.getCurrentHealth() > 0)
					{
					  critterSelected = critter2;
					  System.out.printf("Go %s!%n", critterSelected.getName());
					  break;
					}
					else
					{ 	
						critterSelected = critter1;
						System.out.printf("Go %s!%n", critterSelected.getName());
					}
					
			default: 
			System.out.println("Select one that is in the list.\n");
			break;
		}	
		
		//Code displays some status, such as health and options.
		do
		{
			System.out.printf("%s has %d health.\n", critterSelected.getName(), critterSelected.getCurrentHealth());
			System.out.println("What will you do?\n");
			System.out.printf("%s%10s%n%s%n", "Attack!", "Rest!", "Run!\n" );
			selection = input.next();
			selection = selection.toLowerCase();

	        switch(selection) 
	        {
				case "attack": 
				//when the command attack is invoke, do damage, and recieve damage.
				
				System.out.printf("%s used %s and did %d damage!%n", critterSelected.getName(), critterSelected.getAttackName(), critterSelected.getAttackDamage());
				critterInRoom.recieveDamage(critterSelected.getAttackDamage());
				System.out.printf("%s used %s and did %d damage!%n", critterInRoom.getName(), critterInRoom.getAttackName(), critterInRoom.getAttackDamage());
				critterSelected.recieveDamage(critterInRoom.getAttackDamage());
				
				if(critterInRoom.getCurrentHealth() < 1 && critterSelected.getCurrentHealth() > 1)
				{
					System.out.println("You won!\n");
					win = true;
					critterInRoom.resetCritter();
					break;
				}
				//start to compare the after effect. is everyone still alive?
				//if not, send out the other guy, and remove him from the game.
				else if (critterSelected.getCurrentHealth() < 1)
				{
					System.out.println("You lost! Sending out the other one if we can!\n");
					sleepingCritters.add(critterSelected);
					myCritters.remove(critterSelected);
					
					//if there is no more, you lose. The program closes.
					if (myCritters.size() < 1)
					{
						System.out.println("There's no more critters to send out!\nYou lost! Totally!\nGame Over!\n");
						lose = true;
						System.exit(0);
					}
					//but if you do have more, swap the other one into place.
					else if (critterSelected.getName() == "Unoze")
					{
						critterSelected = critter2;
					}
					
					else
					{ 
						critterSelected = critter1;
					}
				}
				break;
				
				//Just add hp to your currently selected monster.
				case "rest":
				if (critterSelected.getCurrentHealth() < critterSelected.getTotalHealth())
				{
					System.out.printf("%s rested, and regained %d health!\n", critterSelected.getName(), rand.nextInt(9));
					critterSelected.restHeal();
					
					//and if we accidentally heal beyond the maximum hp of the critter.
					if (critterSelected.getCurrentHealth() > critterSelected.getTotalHealth())
					{
						critterSelected.resetCritter();
					}		
				}
				
				else
				{
					System.out.printf("%s already has maximum health! Can't be healed anymore!\n", critterSelected.getName());
				}
				
				break;
				
				//just exit battle. 
				case "run":
				System.out.print("You ran!\n");
				break;
				
				default:
				System.out.print("Please make a valid selection!\n");
				break;
			}
		}
		//This should only run if we make it true. If we run, lose, or win, it kills the loop.
		while(!selection.equals("run") && win == false && lose == false);
		
		//reset victory/game over conditions for next fight!
		win = false;
		lose = false;
	}
}
