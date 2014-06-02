/**
 * 
 * @author Joseph Pickering
 * Student Number: 120181483
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.Map.Entry;
import java.util.Scanner;

public class HashDirectory implements Directory
{
	// Global variables
	public static Hashtable<String, LinkedList<String>> hashEntries = new Hashtable<String, LinkedList<String>>();
	public static Iterator<Entry<String, LinkedList<String>>> iterator = hashEntries.entrySet().iterator();
	public static HashDirectory test = new HashDirectory();
	
	public static String surname;
	public static String initials;
	public static String telephoneExtension;
	public static String entry;
	
	public static boolean bool = true;
	public static int index;
	public static String letter;
	
	// Method to add an entry to the directory
	public void addEntry()
	{
		// Create scanner for user input
		Scanner add = new Scanner(System.in);
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = add.nextLine();
		
		// User input for the intitals
		while(bool = true)
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
		while(bool = true)
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
		
		String letter = surname.substring(0, 1);
		
		// Adding the entry to the list and then sorting it
		hashEntries.get(letter).add(entry);
		Collections.sort(hashEntries.get(letter));

		System.out.println("Entry added!");
	}
	
	// Method to delete an entry from the directory
	public void deleteEntry()
	{
		// Create scanner for user input
		Scanner remove = new Scanner(System.in);
		String n;
		Enumeration<String> en = hashEntries.keys();
		
		// User input for them to choose to delete an entry with a name or a telephone extension
		System.out.println("Would you like to delete an entry by name or number?");
		n = remove.nextLine();
		
		// If the user inputted "name"
		if(n.toLowerCase().equals("name"))
		{
			// User input for the surname
			System.out.println("Enter surname:");
			surname = remove.nextLine();

			while(en.hasMoreElements())
			{
				letter = en.nextElement().substring(0, 1);
				
				for(int i = 0; i < hashEntries.get(letter).size(); i++)
				{   
					String[] splitArray = hashEntries.get(letter).get(i).split("\\t+");
					
					if(splitArray[0].equals(surname))
					{
						// Obtain the first letter of the surname entered
						letter = surname.substring(0, 1);
						
						// Remove the entry, sort the list and add it to the linked list
						hashEntries.remove(letter);
						
						System.out.println("Entry deleted!");
						return;
					}
				}	
			}
		}
		// Else if the user inputted "number"
		else if(n.toLowerCase().equals("number"))
		{
			// User input for the extension number
			System.out.println("Enter extension number:");
			telephoneExtension = remove.nextLine();
			
			while(en.hasMoreElements())
			{
				letter = en.nextElement().substring(0, 1);
				
				for(int i = 0; i < hashEntries.get(letter).size(); i++)
				{   
					String[] splitArray = hashEntries.get(letter).get(i).split("\\t+");
					
					if(splitArray[2].equals(telephoneExtension))
					{
						// Remove the entry, sort the list and add it to the linked list
						hashEntries.remove(splitArray[0].substring(0, 1));
						
						System.out.println("Entry deleted!");
						return;
					}
				}	
			}
		}
		// If input is not name/number or if surname or number is not found
		System.out.println("Invalid entry!");	
	}
	
	// Method to lookup an entry from the directory
	public void lookupEntry() 
	{
		// Create scanner for user input
		Scanner lookup = new Scanner(System.in);
		
		Enumeration<String> en = hashEntries.keys();
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = lookup.nextLine();

		while(en.hasMoreElements())
		{
			letter = en.nextElement().substring(0, 1);
			
			for(int i = 0; i < hashEntries.get(letter).size(); i++)
			{   
				String[] splitArray = hashEntries.get(letter).get(i).split("\\t+");
				
				if(splitArray[0].equals(surname))
				{
					// Obtain the first letter of the surname entered
					letter = surname.substring(0, 1);
					
					// Split up the directory for that entry and print it 
					System.out.println("Extension number for " + splitArray[0]  + " is: " + splitArray[2]);
					return;
				}
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
		
		Enumeration<String> en = hashEntries.keys();
		
		// User input for the surname
		System.out.println("Enter surname:");
		surname = change.nextLine();
		
		while(en.hasMoreElements())
		{
			letter = en.nextElement().substring(0, 1);
			
			for(int i = 0; i < hashEntries.get(letter).size(); i++)
			{   
				String[] splitArray = hashEntries.get(letter).get(i).split("\\t+");
				
				if(splitArray[0].equals(surname))
				{
					// Obtain the first letter of the surname entered
					letter = surname.substring(0, 1);
					
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
							hashEntries.get(letter).set(i, entry);
							Collections.sort(hashEntries.get(letter));
							
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
		}
		// If the surname inputted is not found
		System.out.println("Invalid surname!");
	}
	
	// Telephone directory in a neatly tabulated fashion
	public String toString()
	{
		String s = "\n--------- Directory ---------\nSurname\t\tInitials\tExtension Number\n";
		
		Enumeration<String> en = hashEntries.keys();
		
		while(en.hasMoreElements())
		{
			letter = en.nextElement().substring(0, 1);
			
			for(int i = 0; i < hashEntries.get(letter).size(); i++)
			{
				String[] splitArray = hashEntries.get(letter).get(i).split("\\t+");
				s += splitArray[0] + "\t\t" + splitArray[1] + "\t\t" + splitArray[2] + "\n";
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
		} while(bool = true);
	}

	public static void main(String[] args) throws FileNotFoundException
	{	
		// Creating all of the linked lists for each letter
		LinkedList<String> a = new LinkedList<String>();
		LinkedList<String> b = new LinkedList<String>();
		LinkedList<String> c = new LinkedList<String>();
		LinkedList<String> d = new LinkedList<String>();
		LinkedList<String> e = new LinkedList<String>();
		LinkedList<String> f = new LinkedList<String>();
		LinkedList<String> g = new LinkedList<String>();
		LinkedList<String> h = new LinkedList<String>();
		LinkedList<String> i = new LinkedList<String>();
		LinkedList<String> j = new LinkedList<String>();
		LinkedList<String> k = new LinkedList<String>();
		LinkedList<String> l = new LinkedList<String>();
		LinkedList<String> m = new LinkedList<String>();
		LinkedList<String> n = new LinkedList<String>();
		LinkedList<String> o = new LinkedList<String>();
		LinkedList<String> p = new LinkedList<String>();
		LinkedList<String> q = new LinkedList<String>();
		LinkedList<String> r = new LinkedList<String>();
		LinkedList<String> s = new LinkedList<String>();
		LinkedList<String> t = new LinkedList<String>();
		LinkedList<String> u = new LinkedList<String>();
		LinkedList<String> v = new LinkedList<String>();
		LinkedList<String> w = new LinkedList<String>();
		LinkedList<String> x = new LinkedList<String>();
		LinkedList<String> y = new LinkedList<String>();
		LinkedList<String> z = new LinkedList<String>();
		
		// Putting the <String> of each letter as the keys and putting the linked lists as the values
		hashEntries.put("A", a);
		hashEntries.put("B", b);
		hashEntries.put("C", c);
		hashEntries.put("D", d);
		hashEntries.put("E", e);
		hashEntries.put("F", f);
		hashEntries.put("G", g);
		hashEntries.put("H", h);
		hashEntries.put("I", i);
		hashEntries.put("J", j);
		hashEntries.put("K", k);
		hashEntries.put("L", l);
		hashEntries.put("M", m);
		hashEntries.put("N", n);
		hashEntries.put("O", o);
		hashEntries.put("P", p);
		hashEntries.put("Q", q);
		hashEntries.put("R", r);
		hashEntries.put("S", s);
		hashEntries.put("T", t);
		hashEntries.put("U", u);
		hashEntries.put("V", v);
		hashEntries.put("W", w);
		hashEntries.put("X", x);
		hashEntries.put("Y", y);
		hashEntries.put("Z", z);
		
		// File reader to read the text file with the entries
		FileReader inData = new FileReader("H:\\Directory.txt");
		Scanner inFile = new Scanner(inData); 
		
		try
		{
			while(inFile.hasNextLine())
			{
				String entry = inFile.nextLine();
				letter = entry.substring(0, 1);
				
				hashEntries.get(letter).add(entry);
				Collections.sort(hashEntries.get(letter));
			}
			inFile.close();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
//		System.out.println(hashEntries.get(letter).get(0));
		
		test.menu();
	}
}
