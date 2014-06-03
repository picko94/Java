/**
 * 
 * @author Joseph Pickering
 * Three Card Monte
 * Exercise: http://programmingbydoing.com/a/three-card-monte.html
 *
 */

import java.util.*;

public class ThreeCardMonte 
{
	public static ThreeCardMonte t = new ThreeCardMonte();
	public static Scanner scan = new Scanner(System.in); 
	public static String startInput = null;
	public static int answerInput;
	
	public static int ace;
	
	public static void rulesMessage()
	{
		System.out.println("The Rules:");
		System.out.println("------------------------------------------------------------");
		System.out.println("This is the original 'ball and cups' game where you try to find out which" +
							"\ncup has the ball under it. You may play with three cups and a ball," +
							"\nthree cards (two jacks and an ace), or three doors and a car. Basically, " +
							"\nrandomly select a cup to hide the 'ball'. Let the player guess which " +
							"\ncup hides the ball. The player wins if they guess correctly ");
		System.out.println("------------------------------------------------------------");
	}
	
	public static void startMessage()
	{
		System.out.println("------------------------------------------------------------");
		System.out.println("You slife up to Fast Eddie's card table and plop down your cash." +
							"\nHe glances at you out of the corner of his eye and starts shuffling." +
							"\nHe lays down three cards. " +
							"\n\nWhich one is the ace?\n");
	}
	
	public static void deal()
	{
		Random generator = new Random();
		int[] numbers = {1, 2, 3};
		ace = numbers[generator.nextInt(3)];
	}
	
	public static void displayDeal()
	{
		System.out.println("\t## ## ##\n\t## ## ##\n\t1  2  3");
	}
	
	public static void displayAnswer()
	{
		if(ace == 1)
		{
			System.out.println("\tAA ## ##\n\tAA ## ##\n\t1  2  3");
		}
		else if(ace == 2)
		{
			System.out.println("\t## AA ##\n\t## AA ##\n\t1  2  3");
		}
		else if(ace == 3)
		{
			System.out.println("\t## ## AA\n\t## ## AA\n\t1  2  3");
		}
	}
	
	public static void main(String[] args) 
	{
		// Welcome message
		System.out.println("\t\tWelcome to Three Card Monte!");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Enter 'RULES' for the rules of the game");
		System.out.println("Enter 'START' to begin the game");
		
		startInput = scan.nextLine();
		
		if(startInput.toLowerCase().equals("rules"))
		{
			t.rulesMessage();
		}
		else if(startInput.toLowerCase().equals("start"))
		{
			t.startMessage();
		}
		
		t.deal();
		t.displayDeal();
		
		System.out.print(">");
		answerInput = scan.nextInt();
		
		if(answerInput == ace)
		{
			System.out.println("\nYou nailed it! Fast Eddie reluctantly hands over your winnings!\n");
			t.displayAnswer();
		}
		else if(answerInput != ace)
		{
			System.out.println("\nHa! Fast Eddie wins again! The ace was card number " + ace + "\n");
			t.displayAnswer();
		}
	}
}
