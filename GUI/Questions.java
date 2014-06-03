/**
 * 
 * @author Joseph Pickering
 * Questions
 * Exercise: http://programmingbydoing.com/a/twenty-questions.html
 *
 */

import java.awt.*;
import javax.swing.*;

public class Questions
{
	public static void main(String[] args) 
	{
		String answer = null;
		
		System.out.println("TWO QUESTIONS!");
		System.out.println("Think of an object, and I'll try to guess it");
		
		String question1 = JOptionPane.showInputDialog("Question 1) Is it an animal, a vegetable, or mineral");
		
		String question2 = JOptionPane.showInputDialog("Question 2) Is it bigger than a breadbox? [Yes/No]");
		
		if(question1.toLowerCase().equals("animal"))
		{
			if(question2.toLowerCase().equals("yes"))
			{
				answer = "lion";
			}
			else if(question2.toLowerCase().equals("no"))
			{
				answer = "mouse";
			}
			else
			{
				//JOptionPane.showMessageDialog(f, "Invalid answer", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(question1.toLowerCase().equals("vegetable"))
		{
			if(question2.toLowerCase().equals("yes"))
			{
				answer = "pumpkin";
			}
			else if(question2.toLowerCase().equals("no"))
			{
				answer = "carrot";
			}
			else
			{
				//JOptionPane.showMessageDialog(f, "Invalid answer", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(question1.toLowerCase().equals("mineral"));
		{
			if(question2.toLowerCase().equals("yes"))
			{
				answer = "truck";
			}
			else if(question2.toLowerCase().equals("no"))
			{
				answer = "pen";
			}
			else
			{
				//JOptionPane.showMessageDialog(f, "Invalid answer", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		System.out.println("\nMy guess is that you are thinking of a " + answer + ".");
		System.out.println("I would ask you if I'm right, but I don't actually care.");
	}

}
