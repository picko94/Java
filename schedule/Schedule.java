/**
 * 
 * @author Joseph Pickering
 * Schedule
 * Exercise: http://programmingbydoing.com/a/your-schedule.html
 *
 */

import java.util.*;

public class Schedule 
{
	public static <TextTable> void main(String[] args) 
	{
		// Declare array list for courses and add courses to it
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Chemistry");
		courses.add("Medicine");
		courses.add("English Literature");
		courses.add("English Language");
		courses.add("Law");
		courses.add("Mathematics");
		courses.add("Modern Languages");
		
		// Declare array list for teachers and add teachers to it
		ArrayList<String> teachers = new ArrayList<String>();
		teachers.add("Mr. Adams");
		teachers.add("Mrs. Brown");
		teachers.add("Miss. Dove");
		teachers.add("Ms. Smith");
		teachers.add("Mr. Bean");
		teachers.add("Dr. Watson");
		teachers.add("Prof. Hawkins");
		teachers.add("Mr. Davies");
		
		// Print table
		System.out.println("+-----------------------------------------------------+");
		
		for(int i = 0; i < courses.size(); i++)
		{
			// To format the table
			System.out.format("%5s%30s%20s", "| " + (i+1) + " |", courses.get(i) + " | ", teachers.get(i) + " |\n"); 
		}
		
		System.out.println("+-----------------------------------------------------+");
	}
}
