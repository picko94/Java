/**
 * 
 * @author Joseph Pickering
 * Black Jack
 *
 */

import java.io.*;
import java.util.*;

public class BlackJack 
{	
	// Scanner used for input
	public static Scanner intro = new Scanner(System.in);
	// String to store keyboard input
	public static String input;
	
	// Store cards
	public static Map<String, Integer> cards = new HashMap<String, Integer>();
	
	// Random generator, to randomly generate a card
	public static Random generator = new Random();
	// Object array to store the values in the cards hashmap
	public static Object[] values;
	// ArrayLists to store the cards that each player is dealt
	public static ArrayList<String> storeYourCard = new ArrayList<String>();
	public static ArrayList<String> storeDealerCard = new ArrayList<String>();
	
	// Boolean to check if game is still ongoing
	public static boolean b = true;
	// int used to check a player's score
	public static int check;
	// int used to store the value of the Ace card
	public static int ace;
	
	//public static FileReader balance = new FileReader("C:\\balance.txt");
	
	// A method to display the rules of Black Jack to the user
	public static void rules() 
	{
		System.out.println("The Rules:");
		System.out.println("------------------------------------------------------------");
		System.out.println("Your objective is to get the value of you hand closer to 21 than the dealer's hand. " +
							"\nHowever, if you exceed 21 you go bust and lose automatically.\n\nYou will be dealt two cards " +
							"and from there you can decide whether to 'STICK' which\nmeans that you stick with the value that " +
							"you have or 'HIT' if you would like to\nreceive another card.");
		System.out.println("------------------------------------------------------------");
	}
	
	// A method to deal the cards to the players
	public static void dealCards()
	{
		System.out.println("-------------------------------------------------------------");
		System.out.println("The Dealer is dealt the following cards");
		
		// Dealer cards
		for(int i = 0; i < 2; i++)
		{
			// Assign a random card from the object array to a string
			String randomCard = (String) values[generator.nextInt(values.length)];
			for(int x = 0; x < 1; x++)
			{
				// If the card is an Ace, ace = 1
				if(randomCard.equals("Ace"))
				{
					ace = 1;
				}
				
				// Add the dealt card to the Dealer's array list
				storeDealerCard.add(randomCard);
			}
			
			// Display the Dealers card to the user
			if(i == 0)
			{
				System.out.print(randomCard + " ");	
			}
			else if(i == 1)
			{
				// Only one Dealer card is shown to the user
				System.out.println( "??" );
			}
		}
		
		System.out.println("\n" + "You are dealt the following cards:");
		
		// Your cards
		for(int i = 0; i < 2; i++)
		{
			// Assign a random card from the object array to a string
			String randomCard = (String) values[generator.nextInt(values.length)];
			for(int x = 0; x < 1; x++)
			{
				// Add the dealt card to the player's array list
				storeYourCard.add(randomCard);
			}
			
			// Display the player's cards
			System.out.print(randomCard + " ");
		}
		
		for(int i = 0; i < storeYourCard.size(); i++)
		{
			// If one of the player's cards is an Ace, then let them choose 1 or 11 as the value for Ace
			if(storeYourCard.get(i).equals("Ace"))
			{
				System.out.println("\n" + "Ace: input 1 or 11");
				input = intro.nextLine();
				
				if(input.equals(1))
				{
					ace = 1;
				}
				else if(input.equals(11))
				{
					ace = 11;
				}
			}
		}
		
		// Display the current score for the player
		System.out.println("\n" + "You have the following score: " + checkYourScoreReturn());
	}
	
	// A method used to deal a card to the player
	public static void hit()
	{
		System.out.println("\n" + "You now have these cards:");
		// Assign a random card from the object array to a string
		String randomCard = (String) values[generator.nextInt(values.length)];
		for(int x = 0; x < 1; x++)
		{
			// Add the dealt card to the player's array list
			storeYourCard.add(randomCard);
		}
		
		// Display the player's hand to the user
		for(int y = 0; y < storeYourCard.size(); y++)
		{
			System.out.print(storeYourCard.get(y) + " ");
		}
		
		for(int i = 0; i < storeYourCard.size(); i++)
		{
			// If the dealt card is an Ace, then let them choose 1 or 11 as the value for Ace
			if(storeYourCard.get(i).equals("Ace"))
			{
				System.out.println("\n" + "Ace: input 1 or 11");
				input = intro.nextLine();
				
				if(input.equals(1))
				{
					ace = 1;
				}
				else if(input.equals(11))
				{
					ace = 11;
				}
			}
		}
		
		System.out.println("\n" + "You have the following score: " + checkYourScoreReturn());
	}
	
	// A method used to deal a card to the dealer
	public static void dealerHit()
	{
		System.out.println("\n" + "The Dealer now has these cards:");
		// Assign a random card from the object array to a string
		String randomCard = (String) values[generator.nextInt(values.length)];
		// If the dealt card is an Ace, ace = 1
		if(randomCard.equals("Ace"))
		{
			ace = 1;
		}
		
		// Add the dealt card to the Dealer's array list
		for(int x = 0; x < 1; x++ )
		{
			storeDealerCard.add(randomCard);
		}
		
		// Display the Dealer's cards to the user
		for(int y = 0; y < storeDealerCard.size(); y++)
		{
			System.out.print(storeDealerCard.get(y) + " ");
		}
		
		// Display the Dealer's score to the user
		System.out.println("\n" + "The Dealer has the following score: " + checkDealerScoreReturn());
	}
	
	// A method used when the player decides to stick
	public static void stick()
	{
		// Display the player's score to the user
		System.out.println("You have the following score: " + checkYourScoreReturn() + "\n");
		
		// Display the Dealer's cards to the user
		System.out.println("The Dealer has the following cards: ");
		for(int y = 0; y < storeDealerCard.size(); y++)
		{
			System.out.print(storeDealerCard.get(y) + " ");
		}
		
		// Display the Dealer's score to the user
		System.out.println("\n" + "The Dealer has the following score: " + checkDealerScoreReturn() + "\n");
		
		while(b == true)
		{
			// If the current score for the Dealer is less than 17, then hit
			if(checkDealerScoreReturn() < 17)
			{
				System.out.println("\n" + "Dealer HITS!");
				dealerHit();
				checkDealerScore();
			}
			// Else if the current score for the Dealer is less than or equal to 17, then stick
			else if(checkDealerScoreReturn() >= 17)
			{
				System.out.println("\n" + "Dealer STICKS!");
				b = false;
			}
		}
		
		// Check the final score to see who wins
		checkFinalScore();
	}
	
	// A method used to check the score of the player
	public static void checkScore()
	{
		check = 0;
		
		// For loop to generate the score
		for(int i = 0; i < storeYourCard.size(); i++)
		{
			check += cards.get(storeYourCard.get(i));
		}
		
		if(check < 21)
		{
			// carry on
		}
		else if(check == 21)
		{
			stick();
		}
		else if(check > 21)
		{
			System.out.println("\n" + "You bust!");
			System.out.println("Dealer wins!");
			storeYourCard.clear();
			storeDealerCard.clear();
			game();
		}
	}
	
	// A method used to check the Dealer's score
	public static void checkDealerScore()
	{
		check = 0;
		
		// For loop to generate the Dealer's score
		for(int i = 0; i < storeYourCard.size(); i++)
		{
			check += cards.get(storeYourCard.get(i));
		}
		
		if(check == 21)
		{
			checkFinalScore();
		}
		else if(check > 21)
		{
			System.out.println("\n" + "Dealer bust!");
			System.out.println("You win!");
			storeYourCard.clear();
			storeDealerCard.clear();
			game();
		}
	}
	
	// A method to return the score of the player as an int
	public static int checkYourScoreReturn()
	{
		check = 0;
		
		// For loop to generate the player's score
		for(int i = 0; i < storeYourCard.size(); i++)
		{
			check += cards.get(storeYourCard.get(i));
		}
		
		return check;
	}
	
	// A method to return the score of the Dealer as an int
	public static int checkDealerScoreReturn()
	{
		check = 0;
		
		// For loop to generate the Dealer's score
		for(int i = 0; i < storeDealerCard.size(); i++)
		{
			check += cards.get(storeDealerCard.get(i));
		}
		
		return check;
	}
	
	// A method used to check the final scores for each player to determine who wins
	public static void checkFinalScore()
	{
		if(checkYourScoreReturn() > checkDealerScoreReturn())
		{
			System.out.println("You win!");
		}
		else if(checkDealerScoreReturn() > checkYourScoreReturn())
		{
			System.out.println("Dealer wins!");
		}
		else if (checkDealerScoreReturn() == checkYourScoreReturn())
		{
			System.out.println("Draw!");
		}
		
		storeYourCard.clear();
		storeDealerCard.clear();
		game();
	}
	
	// A method used to control the player's side of the game
	public static void game() 
	{	
		dealCards();
		
		while(b == true)
		{
			System.out.println("\nEnter 'STICK' or 'HIT' ");
			
			input = intro.nextLine();
			
			// HIT, STICK or QUIT
			if(input.equals("HIT"))
			{
				hit();
			}
			else if(input.equals("STICK"))
			{
				stick();
			}
			else if(input.equals("QUIT"))
			{
				System.exit(0);
			}
			
			checkScore();	
		}
	}
	
	
	public static void main(String[] args) 
	{
		// Allocate cards
		cards.put("Ace", ace);
		cards.put("Two", 2);
		cards.put("Three", 3);
		cards.put("Four", 4);
		cards.put("Five", 5);
		cards.put("Six", 6);
		cards.put("Seven", 7);
		cards.put("Eight", 8);
		cards.put("Nine", 9);
		cards.put("Ten", 10);
		cards.put("Jack", 10);
		cards.put("Queen", 10);
		cards.put("King", 10);
		values = cards.keySet().toArray();
		
		// Welcome message
		System.out.println("\t\tWelcome to Black Jack!");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Enter 'RULES' for the rules of the game");
		System.out.println("Enter 'START' to begin the game");
		
		input = intro.nextLine();
		
		if(input.equals("RULES"))
		{
			rules();
		}
		else if(input.equals("START"));
		{
			game();
		}	
	}
}
