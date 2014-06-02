/**
 * 
 * @author Joseph Pickering
 * Student Number: 120181483
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ListDirectory implements Directory
{
	// Global variables
	public static LinkedList<String> linkedListEntries = new LinkedList<String>();
	public static ListDirectory test = new ListDirectory();
	
	public static String surname;
	public static String initials;
	public static String telephoneExtension;
	public static String entry;
	
	public static boolean b = true;
	public static int index;
	
	// Method to add an entry to the directory
	public void addEntry()
	{
		// Create scanner for user input
		Scanner add = new Scanner(System.in);
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = add.nextLine();
		
		// User input for the intitals
		while(b = true)
		{
			System.out.println("Enter initials:");
			initials = add.nextLine();
			
			// Check to see if the initials inputted are 2 characters long
			if(initials.length() > 2)
			{
				System.out.println("Initials can only be 2 characters long");
			}
			else
			{
				break;
			}
		}
		
		// User input for the telephone extension
		while(b = true)
		{
			System.out.println("Enter telephone extension:");
			telephoneExtension = add.nextLine();
			
			try
			{
				// If the telephoneExtension string parses, it's a valid number
				@SuppressWarnings("unused")
				int parse = Integer.parseInt(telephoneExtension);
				
				// Check to see if the telephone extension inputted is 4 characters long and if it isn't a number
				if(telephoneExtension.length() != 4)
				{
					System.out.println("Extension number must be 4 characters long");
				}
				else
				{
					break;
				}
			}
			// If the input isn't a number
			catch(NumberFormatException e)
			{
				System.out.println("Telephone Extension must be a number");
			}
		}
		
		// Change entry string to the input values, ready to be inputted into the array
		entry = (surname + "\t" + initials + "\t" + telephoneExtension);
		
		// Adding the entry to the list and then sorting it
		linkedListEntries.add(entry);
		Collections.sort(linkedListEntries);

		System.out.println("Entry added!");
	}
	
	// Method to delete an entry from the directory
	public void deleteEntry()
	{
		// Create scanner for user input
		Scanner remove = new Scanner(System.in);
		String n;
		
		// User input for them to choose to delete an entry with a name or a telephone extension
		System.out.println("Would you like to delete an entry by name or number?");
		n = remove.nextLine();
		
		// If the user inputted "name"
		if(n.toLowerCase().equals("name"))
		{
			// User input for the surname
			System.out.println("Enter surname:");
			surname = remove.nextLine();
			
			for(int i = 0; i < linkedListEntries.size(); i++)
			{
				// Iterate through the list until the surname is found
				if(linkedListEntries.listIterator(i).next().contains(surname))
				{
					// Remove the entry, sort the list and add it to the linked list
					linkedListEntries.remove(i);
					Collections.sort(linkedListEntries);
					
					System.out.println("Entry deleted!");
					return;
				}
			}
		}
		// Else if the user inputted "number"
		else if(n.toLowerCase().equals("number"))
		{
			// User input for the extension number
			System.out.println("Enter extension number:");
			telephoneExtension = remove.nextLine();
			
			for(int i = 0; i < linkedListEntries.size(); i++)
			{
				// Iterate through the list until the telephone extension is found
				if(linkedListEntries.listIterator(i).next().contains(telephoneExtension))
				{
					// Remove the entry, sort the list and add it to the linked list
					linkedListEntries.remove(i);
					Collections.sort(linkedListEntries);
					
					System.out.println("Entry deleted!");
					return;
				}
			}
		}
		// If input is not name/number or if surname or number is not found
		System.out.println("Invalid entry!");	
	}
	
	// Method to lookup an entry in the directory
	public void lookupEntry() 
	{
		// Create scanner for user input
		Scanner lookup = new Scanner(System.in);
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = lookup.nextLine();
		
		for(int i = 0; i < linkedListEntries.size(); i++)
		{
			// Iterate through the list until the surname is found
			if(linkedListEntries.listIterator(i).next().contains(surname))
			{
				// Split up the directory for that entry and print it 
				String[] splitArray = linkedListEntries.get(i).split("\\t+");
				System.out.println("Extension number for " + splitArray[0]  + " is: " + splitArray[2]);
				return;
			}
		}
		// If the surname inputted is not found
		System.out.println("Invalid surname!");
	}
	
	// Method to change the extension number of an entry in the directory
	public void changeEntryNumber() 
	{
		// Create scanner for user input
		Scanner change = new Scanner(System.in);
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = change.nextLine();
		
		for(int i = 0; i < linkedListEntries.size(); i++)
		{
			// Iterate through the list until the surname is found
			if(linkedListEntries.listIterator(i).next().contains(surname))
			{
				// Split the entry into three parts: surname, initials and telephone extension
				String[] splitArray = linkedListEntries.get(i).split("\\t+");
				
				// To show the user what the telephone extension is currently for that entry
				System.out.println("Extension number for " + splitArray[0]  + " is: " + splitArray[2]);
				System.out.println("What would you like to change it to?");
				
				// User input for new extension number
				telephoneExtension = change.nextLine();
				
				try
				{
					// If the telephoneExtension string parses, it's a valid number
					@SuppressWarnings("unused")
					int parse = Integer.parseInt(telephoneExtension);
					
					// If the telephone extension inputted is not 4 characters long
					if(telephoneExtension.length() != 4)
					{
						System.out.println("Extension number must be 4 characters long");
					}
					// Else if the telephone extension is a number and is 4 characters long
					else if(telephoneExtension.length() == 4)
					{
						// Change entry string to the new entry, ready to be inputted into the linked list
						entry = (splitArray[0] + "\t" + splitArray[1] + "\t" + telephoneExtension);
						
						// Changing the old entry with the new one and then sorting it
						linkedListEntries.set(i, entry);
						Collections.sort(linkedListEntries);
						
						System.out.println("Extension number changed!");
						return;
					}
				}
				// Catch for if the input wasn't a number
				catch(NumberFormatException e)
				{
					System.out.println("Telephone Extension must be a number");
				}
			}
		}
		// If the surname inputted is not found
		System.out.println("Invalid surname!");
	}
	
	// Telephone directory in a neatly tabulated fashion
	public String toString()
	{
		String s = "\n--------- Directory ---------\nSurname\t\tInitials\tExtension Number\n";
		
		for(int i = 0; i < linkedListEntries.size(); i++)
		{
			String[] splitArray = linkedListEntries.get(i).split("\\t+");
			
			for(int j = 0; j < 1; j++)
			{
				s += splitArray[0] + "\t\t" + splitArray[1] + "\t\t" + splitArray[2] +"\n";
			}
		}
		return s;
	}
	
	// Menu so that the user to choose what to do
	public void menu() throws InputMismatchException
	{
		Scanner input = new Scanner(System.in);
		
		// Menu
		System.out.println("--------- MENU ---------");
		System.out.println("1." + "\t" + "Insert new entry");
		System.out.println("2." + "\t" + "Delete an entry");
		System.out.println("3." + "\t" + "Lookup an extension number");
		System.out.println("4." + "\t" + "Change a telephone number");
		System.out.println("5." + "\t" + "Print the directory");
		System.out.println("0." + "\t" + "Quit");
		
		do
		{
			System.out.println("\nEnter a number from the menu:");
			int z;
			
			try
			{
				z = input.nextInt();
				
				if(z == 1)
				{
					test.addEntry();
				}
				else if(z == 2)
				{
					test.deleteEntry();
				}
				else if(z == 3)
				{
					test.lookupEntry();
				}
				else if(z == 4)
				{
					test.changeEntryNumber();
				}
				else if(z == 5)
				{
					System.out.println(test.toString());
				}
				else if(z == 0)
				{
					System.out.println("Thank you for using the Directory!");
					System.exit(0);
				}
				else
				{
					System.out.println("Invalid entry!");

				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid entry!");
				input.nextLine();
			}
		} while(b = true);
	}

	public static void main(String[] args) throws FileNotFoundException
	{	
		// File reader to read the text file with the entries
		FileReader inData = new FileReader("H:\\Directory.txt");
		Scanner inFile = new Scanner(inData);
		
		try
		{
			// Reading the entries into a list
			while(inFile.hasNextLine())
			{
				String entry = inFile.nextLine();
				linkedListEntries.add(entry);
				Collections.sort(linkedListEntries);
			}
			inFile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Calling the menu() method
		test.menu();
	}
}
