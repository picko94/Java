/************************************************/
/*** Sort class which will contain a range    ***/
/*** of sorting methods.                      ***/
/*** Initially contains methods for reading   ***/
/*** and displaying an array of integers.     ***/
/***                                          ***/
/*** Initial Author: Jason Steggles 20/09/13  ***/
/*** Extended by: Joseph Pickering  28/10/13  ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort 
{
	/** Size of array **/
	private static int size;

	/** Number of used elements in array **/
	private static int usedSize;

	/** Array of integers **/
	private static int[] A;

	/** Global comparison count for Insertion Sort **/
	public int compIS;
	/** Global comparison count for Quicksort **/
	public static int compQS;
	
	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) 
	{
		/** Initialiase global count variables **/
		compIS = 0;
		compQS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file)
	{
		try 
		{
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) 
			{
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} 
		catch (IOException e) 
		{
			System.out.println("Error processing file " + file);
		}
	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) 
	{
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) 
		{
			/** Check if new line is needed **/
			if (i % line == 0) 
			{
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}
	
	/** Insertion Sort **/
	public void insertionSort()
	{
		int j = 0;
		int key = 0;
		
		for(int i = 1; i < usedSize; i++)
		{
			// Store next value to insert
			key = A[i];
			j = i;
			compIS++; // Add one to comparison counter
			
			// While loop to find the correct position of the key
			while(j > 0 && key < A[j-1])
			{
				A[j] = A[j-1]; // Push space left
				j = j-1;
				
				compIS++; // Add one to comparison counter
			}
			// Insert key
			A[j] = key;
		}
	}
	
	/** Quicksort **/
	// Method to call the actual quickSort method with the correct parameters
	public void quickSort()
	{
		quickSort(0, usedSize-1);
	}
	
	public void quickSort(int L, int R)
	{
		int pivot;
		
		// Stop if there is only one value left
		if(R > L)
		{
			pivot = partition(L ,R); 	// Split array in two
			quickSort(L, pivot-1);		// Sort left half
			quickSort(pivot+1, R);		// Sort right half
		}
	}
	
	public static int partition(int left, int right)
	{
		int pivot = A[right];	// Select pivot
		int pL = left;		
		int pR = right;
		
		// Repeat until scanning pointers cross
		while(pL < pR)
		{
			// Move pL
			while(A[pL] < pivot)
			{
				pL++;
				compQS++;	// Add one to comparison counter
			}
			compQS++;	// Add one to comparison counter, if while loop not entered
			
			// Move pR
			while(A[pR] >= pivot && pR > left)
			{
				pR--;
				compQS++;	// Add one to comparison counter
			}
			compQS++;	// Add one to comparison counter, if while loop not entered
			
			// Don't swap on last iteration
			if(pL < pR)
			{
				swap(pL, pR);
			}
		}
		// Put pivot in correct position
		swap(pL, right);
		
		return pL;
	}
	
	// Swap method to swap the two necassary integers
	public static void swap(int x, int y)
	{
		// Variable to hold value
		int z = A[x];
		
		A[x] = A[y];	// Change A[x] to A[y]
		A[y] = z;		// Change A[y] to A[x] using z variable
	}
	
	/** Refined version of Quicksort **/
	// Method to call the actual newQuickSort method with the correct parameters
	public void newQuicksort()
	{
		newQuicksort(0, usedSize-1);
	}
	
	public void newQuicksort(int L, int R)
	{
		// Index of pivot after partition
		int pivot;
		
		// Stop when the array is nearly sorted
		if((R - L) > 12)
		{
			pivot = partition(L ,R); 	// Split array in two
			newQuicksort(L, pivot-1);	// Sort left half
			newQuicksort(pivot+1, R);	// Sort right half
		}
	}
}
/** End of Sort Class **/
