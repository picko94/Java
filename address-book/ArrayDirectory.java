/**
 * 
 * @author Joseph Pickering
 * Student Number: 120181483
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayDirectory implements Directory
{
	// Global variables
	public static ArrayList<String> listEntries = new ArrayList<String>();
	public static String[] directory;
	public static ArrayDirectory test = new ArrayDirectory();
	
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
		
		// User input for the initials
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
		listEntries.add(entry);
		Collections.sort(listEntries);
		
		// Adding the list to the array
		directory = listEntries.toArray(new String[listEntries.size()]);

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
		
		// If the input eqauls "name"
		if(n.toLowerCase().equals("name"))
		{
			// User input to enter the surname
			System.out.println("Enter surname:");
			surname = remove.nextLine();
			
			for(int i = 0; i < directory.length; i++)
			{
				String[] splitArray = directory[i].split("\\t+");
				
				// If the surname enter matches one in the directory
				if(splitArray[0].equals(surname))
				{
					// Remove the entry, sort the list and add it to the directory array
					listEntries.remove(i);
					Collections.sort(listEntries);
					directory = listEntries.toArray(new String[listEntries.size()]);
					
					System.out.println("Entry deleted!");
					return;
				}
			}
		}
		// Else if the input equals "number"
		else if(n.toLowerCase().equals("number"))
		{
			// User input to enter the telephone extension
			System.out.println("Enter extension number:");
			telephoneExtension = remove.nextLine();
			
			for(int i = 0; i < directory.length; i++)
			{
				String[] splitArray = directory[i].split("\\t+");
				
				// If the telephone extension matches one in the directory
				if(splitArray[2].equals(telephoneExtension))
				{
					// Remove the entry, sort the list and add it to the directory array
					listEntries.remove(i);
					Collections.sort(listEntries);
					directory = listEntries.toArray(new String[listEntries.size()]);
					
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
		
		// User input to enter the surname
		System.out.println("Enter surname:");
		surname = lookup.nextLine();
		
		// Search for the surname inputted using binary search
		index = Arrays.binarySearch(directory, surname) * -1;
		
		// If the integer returned is less than the size of the directory, means that it was found
		if(index <= directory.length) 
		{
			// Split up the directory for that entry and print it 
			String[] splitArray = directory[index - 1].split("\\t+");
			System.out.println("Extension number for " + splitArray[0]  + " is: " + splitArray[2]);
		}
		// Else the integer returned is not less than the size of the directory, means that it wasn't found
		else
		{
			System.out.println("Invalid surname!");
		}
	}
	
	// Method to change the extension number of an entry
	public void changeEntryNumber() 
	{
		// Create scanner for user input
		Scanner change = new Scanner(System.in);
		
		// User input to enter the surname
		System.out.println("Enter surname:");
		surname = change.nextLine();
	
		// Serach for the surname inputted using binary search
		index = Arrays.binarySearch(directory, surname) * -1;
		
		// If the integer returned if less than the size of the directory, means that it was found
		if(index <= directory.length)
		{
			// Split the entry into three parts: surname, initials and telephone extension
			String[] splitArray = directory[index - 1].split("\\t+");
			
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
					// Change entry string to the new entry, ready to be inputted into the array
					entry = (splitArray[0] + "\t" + splitArray[1] + "\t" + telephoneExtension);
					
					// Changing the old entry with the new one and then sorting it
					listEntries.set(index - 1, entry);
					Collections.sort(listEntries);
					
					// Adding the list to the array
					directory = listEntries.toArray(new String[listEntries.size()]);
					
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
		// Else the integer returned is not less than the size of the directory, means that it wasn't found
		else
		{
			System.out.println("Invalid surname!");
		}
	}
	
	// To print the directory in a neat and tabulated fashion
	public String toString()
	{
		String s = "\n--------- Directory ---------\nSurname\t\tInitials\tExtension Number\n";
		
		for(int i = 0; i < directory.length; i++)
		{
			String[] splitArray = directory[i].split("\\t+");
			
			for(int j = 0; j < 1; j++)
			{
				s += splitArray[0] + "\t\t" + splitArray[1] + "\t\t" + splitArray[2] +"\n";
			}
		}
		return s;
	}
	
	// Menu method so that the user can choose what to do
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
				listEntries.add(entry);
				Collections.sort(listEntries);
			}
			inFile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Adding all of the entries in the list to the directory array
		directory = listEntries.toArray(new String[listEntries.size()]);
		
		// Calling the menu() method
		test.menu();
	}
}
