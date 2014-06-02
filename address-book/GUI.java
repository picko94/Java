/**
 * 
 * @author Joseph Pickering
 * Student Number: 120181483
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*;

public class GUI extends ListDirectory
{
	// Global variables
	static JFrame frame;
	static Container content;
	static JButton addEntryMenu, addEntry, deleteEntryMenu, deleteEntryName, deleteEntryNumber, lookupEntryMenu, lookupEntry, 
								changeEntryNumberMenu, changeEntryNumber, printDirectoryMenu, quit, name, number, menu, refresh;
	static JLabel title, message, gap, surname, initials, telephoneExtension, question;
	static JTextArea directory;
	static JTextField surnameInput, initialsInput, telephoneExtensionInput;
	
	public static ListDirectory test = new ListDirectory();
	
    private static void createAndShowGUI() 
    {
    	/** Main aspects of the page **/
    	
		// Create the frame
		frame = new JFrame ("Directory");
		frame.setVisible(true);
		frame.setSize (400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create container
		content = frame.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.WHITE);
		
		
		
		/** Menu section **/
		
		// Welcome message
		message = new JLabel("Welcome to the Directory!");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(message);
		
		// Gap between the welcome message and the title 'MENU'
		gap = new JLabel(" ");
		frame.add(gap);
		
		// Title 'MENU'
		title = new JLabel("------------------------ MENU ------------------------");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(title);
		
		// Menu button
		menu = new JButton("Menu");
		menu.setMaximumSize(new Dimension(200, 30));
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		/** Insert an entry section **/
		
		// Insert an entry menu button
		addEntryMenu = new JButton("Insert new entry");
		addEntryMenu.setMaximumSize(new Dimension(200, 30));
		addEntryMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(addEntryMenu);
		
		// Surname label
		surname = new JLabel("Surname: ");
		surname.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Surname text field
		surnameInput = new JTextField(10);
		surnameInput.setMaximumSize(new Dimension(200, 30) );
		surnameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Initials label
		initials = new JLabel("Initials: ");
		initials.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Initials text field
		initialsInput = new JTextField(2);
		initialsInput.setMaximumSize(new Dimension(200, 30) );
		initialsInput.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Telephone extension label
		telephoneExtension = new JLabel("Extension number: ");
		telephoneExtension.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Telephone extension text field
		telephoneExtensionInput = new JTextField(4);
		telephoneExtensionInput.setMaximumSize(new Dimension(200, 30) );
		telephoneExtensionInput.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Insert an entry button, submits to information
		addEntry = new JButton("Add entry");
		addEntry.setMaximumSize(new Dimension(200,30));
		addEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Action Listener for the addEntryMenu button
		addEntryMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everthing on the menu page
				addEntryMenu.setVisible(false);
				deleteEntryMenu.setVisible(false);
				lookupEntryMenu.setVisible(false);
				changeEntryNumberMenu.setVisible(false);
				printDirectoryMenu.setVisible(false);
				quit.setVisible(false);
				frame.remove(title);
				frame.remove(addEntryMenu);
				frame.remove(deleteEntryMenu);
				frame.remove(lookupEntryMenu);
				frame.remove(changeEntryNumberMenu);
				frame.remove(printDirectoryMenu);
				frame.remove(quit);
				
				// Add the new elements to the page
				frame.add(surname);
				frame.add(surnameInput);
				frame.add(initials);
				frame.add(initialsInput);
				frame.add(telephoneExtension);
				frame.add(telephoneExtensionInput);
				frame.add(addEntry);
				frame.add(menu);
				
				addEntry.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Checks to see if the user inputs are valid
						if(surnameInput.getText().length() > 10)
						{
							JOptionPane.showMessageDialog( addEntry, "Surname must be between 1 and 8 characters", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else if(initialsInput.getText().length() != 2)
						{
							JOptionPane.showMessageDialog( addEntry, "Initials must be 2 characters long", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else if(telephoneExtensionInput.getText().length() != 4)
						{
							JOptionPane.showMessageDialog( addEntry, "Extension number must be 4 characters long", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							// Change entry string to the input values, ready to be inputted into the array
							entry = (surnameInput.getText() + "\t" + initialsInput.getText() + "\t" + telephoneExtensionInput.getText());
							
							// Adding the entry to the list and then sorting it
							linkedListEntries.add(entry);
							Collections.sort(linkedListEntries);
							
							// Message to tell the user that the entry was added
							JOptionPane.showMessageDialog( addEntry, "Entry added!", "Info", JOptionPane.INFORMATION_MESSAGE );
						}
					}
				});
				
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the page
						addEntry.setVisible(false);
						surname.setVisible(false);
						surnameInput.setVisible(false);
						initials.setVisible(false);
						initialsInput.setVisible(false);
						telephoneExtension.setVisible(false);
						telephoneExtensionInput.setVisible(false);
						menu.setVisible(false);
						frame.remove(addEntry);
						frame.remove(surname);
						frame.remove(surnameInput);
						frame.remove(initials);
						frame.remove(initialsInput);
						frame.remove(telephoneExtension);
						frame.remove(telephoneExtensionInput);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);					
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
		    }
		});
		
		
		
		/** Delete an entry section **/
		
		// Delete an entry button on the menu
		deleteEntryMenu = new JButton("Delete an entry");
		deleteEntryMenu.setMaximumSize(new Dimension(200, 30));
		deleteEntryMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(deleteEntryMenu);
		
		// Question label
		question = new JLabel("Would you like to delete by name or number?");
		question.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Name button
		name = new JButton("Name");
		name.setMaximumSize(new Dimension(200, 30));
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Number button
		number = new JButton("Number");
		number.setMaximumSize(new Dimension(200, 30));
		number.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Delete an entry by name, submits the information
		deleteEntryName = new JButton("Delete entry");
		deleteEntryName.setMaximumSize(new Dimension(200,30));
		deleteEntryName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Delete an entry by extension number, submits the information
		deleteEntryNumber = new JButton("Delete entry");
		deleteEntryNumber.setMaximumSize(new Dimension(200,30));
		deleteEntryNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Action Listener for the deleteEntryMenu button
		deleteEntryMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everthing on the menu page
				addEntryMenu.setVisible(false);
				deleteEntryMenu.setVisible(false);
				lookupEntryMenu.setVisible(false);
				changeEntryNumberMenu.setVisible(false);
				printDirectoryMenu.setVisible(false);
				quit.setVisible(false);				
				frame.remove(title);
				frame.remove(addEntryMenu);
				frame.remove(deleteEntryMenu);
				frame.remove(lookupEntryMenu);
				frame.remove(changeEntryNumberMenu);
				frame.remove(printDirectoryMenu);
				frame.remove(quit);
				
				// Add the new elements to the page
				frame.add(question);
				frame.add(name);
				frame.add(number);
				frame.add(menu);
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the page
						question.setVisible(false);
						name.setVisible(false);
						number.setVisible(false);
						menu.setVisible(false);
						frame.remove(question);
						frame.remove(name);
						frame.remove(number);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);					
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
		
		// Action Listener for the name button
		name.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everything from the delete entry page
				question.setVisible(false);
				name.setVisible(false);
				number.setVisible(false);
				menu.setVisible(false);			
				frame.remove(question);
				frame.remove(name);
				frame.remove(number);
				frame.remove(menu);
				
				// Add the new elements to the page
				frame.add(surname);
				frame.add(surnameInput);
				frame.add(deleteEntryName);
				menu.setVisible(true);
				frame.add(menu);
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the page
						surname.setVisible(false);
						surnameInput.setVisible(false);
						deleteEntryName.setVisible(false);
						menu.setVisible(false);
						frame.remove(surname);
						frame.remove(surnameInput);
						frame.remove(deleteEntryName);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);				
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
				
		// Action Listener for the number button
		number.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everything on the page
				question.setVisible(false);
				name.setVisible(false);
				number.setVisible(false);
				menu.setVisible(false);	
				frame.remove(question);
				frame.remove(name);
				frame.remove(number);
				frame.remove(menu);
				
				// Add the new elements to the page
				frame.add(telephoneExtension);
				frame.add(telephoneExtensionInput);
				frame.add(deleteEntryNumber);
				menu.setVisible(true);
				frame.add(menu);
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the page
						telephoneExtension.setVisible(false);
						telephoneExtensionInput.setVisible(false);
						deleteEntryNumber.setVisible(false);
						menu.setVisible(false);
						frame.remove(telephoneExtension);
						frame.remove(telephoneExtensionInput);
						frame.remove(deleteEntryNumber);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);			
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
		
		// Action Listener for the deleteEntryName button
		deleteEntryName.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				for(int i = 0; i < linkedListEntries.size(); i++)
				{
					String[] splitArray = linkedListEntries.get(i).split("\\t+");
					
					// Iterate through the list until the surname is found
					if(splitArray[0].equals(surnameInput.getText()))
					{
						// Remove the entry, sort the list and add it to the linked list
						linkedListEntries.remove(i);
						Collections.sort(linkedListEntries);
						
						// Message to tell the user that the entry has been deleted
						JOptionPane.showMessageDialog( addEntry, "Entry deleted!", "Info", JOptionPane.INFORMATION_MESSAGE );
						return;
					}
				}
				
				// Message to tell the user that the surname inputted was not found
				JOptionPane.showMessageDialog( addEntry, "Surname not found", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// Action Listener for the deleteEntryNumber button
		deleteEntryNumber.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				for(int i = 0; i < linkedListEntries.size(); i++)
				{
					String[] splitArray = linkedListEntries.get(i).split("\\t+");
					
					// Iterate through the list until the surname is found
					if(splitArray[2].equals(telephoneExtensionInput.getText()))
					{
						// Remove the entry, sort the list and add it to the linked list
						linkedListEntries.remove(i);
						Collections.sort(linkedListEntries);
					
						// Message to tell the user that the entry has been deleted
						JOptionPane.showMessageDialog( addEntry, "Entry deleted!", "Info", JOptionPane.INFORMATION_MESSAGE );
						return;
					}
				}
				
				// Message to tell the user that the extension number was not found
				JOptionPane.showMessageDialog( addEntry, "Extension number not found", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		
		/** Lookup an entry section **/

		// Lookup an entry button on the menu
		lookupEntryMenu = new JButton("Lookup an extension number");
		lookupEntryMenu.setMaximumSize(new Dimension(200, 30));
		lookupEntryMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(lookupEntryMenu);
		
		// Lookup an entry button, finds the information
		lookupEntry = new JButton("Lookup entry");
		lookupEntry.setMaximumSize(new Dimension(200, 30));
		lookupEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Action Listener for the lookupEntryMenu button
		lookupEntryMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everthing on the menu page
				addEntryMenu.setVisible(false);
				deleteEntryMenu.setVisible(false);
				lookupEntryMenu.setVisible(false);
				changeEntryNumberMenu.setVisible(false);
				printDirectoryMenu.setVisible(false);
				quit.setVisible(false);			
				frame.remove(title);
				frame.remove(addEntryMenu);
				frame.remove(deleteEntryMenu);
				frame.remove(lookupEntryMenu);
				frame.remove(changeEntryNumberMenu);
				frame.remove(printDirectoryMenu);
				frame.remove(quit);
				
				// Add the new elements to the page
				frame.add(surname);
				frame.add(surnameInput);
				frame.add(lookupEntry);
				frame.add(menu);
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the menu page
						surname.setVisible(false);
						surnameInput.setVisible(false);
						lookupEntry.setVisible(false);
						menu.setVisible(false);
						frame.remove(surname);
						frame.remove(surnameInput);
						frame.remove(lookupEntry);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
		
		// Action Listener for the lookupEntry button
		lookupEntry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				for(int i = 0; i < linkedListEntries.size(); i++)
				{
					// Split up the directory for that entry and print it 
					String[] splitArray = linkedListEntries.get(i).split("\\t+");
					
					// Iterate through the list until the surname is found
					if(splitArray[0].equals(surnameInput.getText()))
					{
						// Message to tell the user the extension number for that entry
						JOptionPane.showMessageDialog( addEntry, "Extension number for " + splitArray[0] + " is: " + splitArray[2],
																									"Info", JOptionPane.INFORMATION_MESSAGE );
						return;
					}
				}
				// Message to tell the user that the surname was not found
				JOptionPane.showMessageDialog( addEntry, "Surname not found", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		
		/** Changing an entry extention number section **/
		
		// Change a telephone extension button on the menu
		changeEntryNumberMenu = new JButton("Change a telephone number");
		changeEntryNumberMenu.setMaximumSize(new Dimension(200, 30));
		changeEntryNumberMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(changeEntryNumberMenu);
		
		// Change a telephone extension button, submits the information
		changeEntryNumber = new JButton("Change extension number");
		changeEntryNumber.setMaximumSize(new Dimension(200, 30));
		changeEntryNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Label to ask the user what they would like to change the extension number to
		question = new JLabel("What would you like to change it to?");
		question.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Action Listener for the changeEntryNumberMenu button
		changeEntryNumberMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everthing on the menu page
				addEntryMenu.setVisible(false);
				deleteEntryMenu.setVisible(false);
				lookupEntryMenu.setVisible(false);
				changeEntryNumberMenu.setVisible(false);
				printDirectoryMenu.setVisible(false);
				quit.setVisible(false);		
				frame.remove(title);
				frame.remove(addEntryMenu);
				frame.remove(deleteEntryMenu);
				frame.remove(lookupEntryMenu);
				frame.remove(changeEntryNumberMenu);
				frame.remove(printDirectoryMenu);
				frame.remove(quit);
				
				// Add the new elements to the page
				frame.add(surname);
				frame.add(surnameInput);
				frame.add(question);
				frame.add(telephoneExtensionInput);
				frame.add(changeEntryNumber);
				frame.add(menu);
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the page
						surname.setVisible(false);
						surnameInput.setVisible(false);
						changeEntryNumber.setVisible(false);
						menu.setVisible(false);
						frame.remove(surname);
						frame.remove(surnameInput);
						frame.remove(changeEntryNumber);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);			
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
		
		// Action Listener for the changeEntryNumber button
		changeEntryNumber.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{	
				for(int i = 0; i < linkedListEntries.size(); i++)
				{
					String[] splitArray = linkedListEntries.get(i).split("\\t+");
					
					// Iterate through the list until the surname is found
					if(splitArray[0].equals(surnameInput.getText()))
					{	
						if(telephoneExtensionInput.getText().length() != 4)
						{
							// Message to tell the user that the extension number inputted must be 4 characters long
							JOptionPane.showMessageDialog( addEntry, "Telephone extension must be 4 characters long", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							// Change entry string to the new entry, ready to be inputted into the linked list
							entry = (splitArray[0] + "\t" + splitArray[1] + "\t" + telephoneExtensionInput.getText());
								
							// Changing the old entry with the new one and then sorting it
							linkedListEntries.set(i, entry);
							Collections.sort(linkedListEntries);
							
							// Message to tell the user that the extension number has been changed
							JOptionPane.showMessageDialog( addEntry, "Extension number changed!", "Info", JOptionPane.INFORMATION_MESSAGE );
							return;
						}
						
						// Action Listener for the menu button
						menu.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent event) 
							{
								// Remove everthing on the page
								surname.setVisible(false);
								surnameInput.setVisible(false);
								question.setVisible(false);
								telephoneExtensionInput.setVisible(false);
								menu.setVisible(false);
								frame.remove(surname);
								frame.remove(surnameInput);
								frame.remove(question);
								frame.remove(telephoneExtensionInput);
								frame.remove(menu);
								
								// Add menu
								addEntryMenu.setVisible(true);
								deleteEntryMenu.setVisible(true);
								lookupEntryMenu.setVisible(true);
								changeEntryNumberMenu.setVisible(true);
								printDirectoryMenu.setVisible(true);
								quit.setVisible(true);							
								frame.add(title);
								frame.add(addEntryMenu);
								frame.add(deleteEntryMenu);
								frame.add(lookupEntryMenu);
								frame.add(changeEntryNumberMenu);
								frame.add(printDirectoryMenu);
								frame.add(quit);
							}
						});
					}
				}
				
				JOptionPane.showMessageDialog( addEntry, "Surname not found", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		
		/** Printing the directory section **/
		
		// Show directory button on the menu
		printDirectoryMenu = new JButton("Show directory");
		printDirectoryMenu.setMaximumSize(new Dimension(200, 30));
		printDirectoryMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(printDirectoryMenu);
		
		// Directory test area
		directory = new JTextArea(String.format(test.toString()));
		directory.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Refresh button
		refresh = new JButton("Refresh");
		refresh.setMaximumSize(new Dimension(200, 30));
		refresh.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Action Listener for the printDirectoryMenu button
		printDirectoryMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				// Remove everthing on the menu page
				addEntryMenu.setVisible(false);
				deleteEntryMenu.setVisible(false);
				lookupEntryMenu.setVisible(false);
				changeEntryNumberMenu.setVisible(false);
				printDirectoryMenu.setVisible(false);
				quit.setVisible(false);
				menu.setVisible(false);	
				frame.remove(title);
				frame.remove(addEntryMenu);
				frame.remove(deleteEntryMenu);
				frame.remove(lookupEntryMenu);
				frame.remove(changeEntryNumberMenu);
				frame.remove(printDirectoryMenu);
				frame.remove(quit);
				
				// Add the new elements to the page
				frame.add(directory);
				frame.add(refresh);
				menu.setVisible(true);
				frame.add(menu);
				
				// Action Listener for the refresh button
				refresh.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						directory.setText(String.format(test.toString()));
					}
				});
				
				// Action Listener for the menu button
				menu.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Remove everthing on the menu page
						directory.setVisible(false);
						refresh.setVisible(false);
						menu.setVisible(false);
						frame.remove(directory);
						frame.remove(refresh);
						frame.remove(menu);
						
						// Add menu
						addEntryMenu.setVisible(true);
						deleteEntryMenu.setVisible(true);
						lookupEntryMenu.setVisible(true);
						changeEntryNumberMenu.setVisible(true);
						printDirectoryMenu.setVisible(true);
						quit.setVisible(true);			
						frame.add(title);
						frame.add(addEntryMenu);
						frame.add(deleteEntryMenu);
						frame.add(lookupEntryMenu);
						frame.add(changeEntryNumberMenu);
						frame.add(printDirectoryMenu);
						frame.add(quit);
					}
				});
			}
		});
		
		// Quit button
		quit = new JButton("Quit");
		quit.setMaximumSize(new Dimension(200, 30));
		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(quit);
		
		// Action Listener for the quit button
		quit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{		
				System.exit(0);
			}
		});
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
		
		// Calling the createAndShowGUI() method
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}
