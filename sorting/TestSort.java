
/*************************************************/
/*** Simple test class for Sort class          ***/
/*** You should add your own test code in here ***/
/***                                           ***/
/*** Author: Joseph Pickering 28/10/13         ***/
/*************************************************/

public class TestSort
{
      public static void main(String[] args) 
      {   
    	  /** Sorting for text1.txt **/
    	  // Displaying the unsorted array
          Sort insertionTest1 = new Sort(15);
          insertionTest1.readIn("test1.txt");
          insertionTest1.display(10, "Array of Integers from text1.txt:");
          
          // Insertion sort for text1.txt, displaying the sorted array and the comparison counter
          insertionTest1.insertionSort();
          insertionTest1.display(10, "\nInsertion Sort for test1.txt:");
          System.out.println("\n\nInsertion Sort comparison counter: " + insertionTest1.compIS);
          
          // Quicksort for text1.txt, displaying the sorted array and the comparison counter
          Sort quickTest1 = new Sort(15);
          quickTest1.readIn("test1.txt");
          quickTest1.quickSort();
          quickTest1.display(10, "QuickSort for text1.txt:");
          System.out.println("\n\nQuickSort comparison counter: " + quickTest1.compQS);
          
    	  /** Sorting for text2.txt **/
          // Displaying the unsorted array
          Sort insertionTest2 = new Sort(15);
          insertionTest2.readIn("test2.txt");
          insertionTest2.display(10, "Array of Integers from text2.txt:");
          
          // Insertion sort for text2.txt, displaying the sorted array and the comparison counter
          insertionTest2.insertionSort();
          insertionTest2.display(10, "\nInsertion Sort for test2.txt:");
          System.out.println("\n\nInsertion Sort comparison counter: " + insertionTest2.compIS);
          
          // Quicksort for text2.txt, displaying the sorted array and the comparison counter
          Sort quickTest2 = new Sort(15);
          quickTest2.readIn("test2.txt");
          quickTest2.quickSort();
          quickTest2.display(10, "QuickSort for text2.txt:");
          System.out.println("\n\nQuickSort comparison counter: " + quickTest2.compQS);
          
    	  /** Sorting for text3.txt **/
          // Displaying the unsorted array
          Sort insertionTest3 = new Sort(100);
          insertionTest3.readIn("test3.txt");
          insertionTest3.display(10, "Array of Integers from text3.txt:");
          
          // Insertion sort for text3.txt, displaying the sorted array and the comparison counter
          insertionTest3.insertionSort();
          insertionTest3.display(10, "\nInsertion Sort for test3.txt:");
          System.out.println("\n\nInsertion sort comparison counter: " + insertionTest3.compIS);
          
          // Quicksort for text3.txt, displaying the sorted array and the comparison counter
          Sort quickTest3 = new Sort(100);
          quickTest3.readIn("test3.txt");
          quickTest3.quickSort();
          quickTest3.display(10, "QuickSort for text3.txt:");
          System.out.println("\n\nQuickSort comparison counter: " + quickTest3.compQS);
          
    	  /** Sorting for text4.txt **/
          // Displaying the unsorted array
          Sort insertionTest4 = new Sort(100);
          insertionTest4.readIn("test4.txt");
          insertionTest4.display(10, "Array of Integers from text4.txt:");
          
          // Insertion sort for text4.txt, displaying the sorted array and the comparison counter
          insertionTest4.insertionSort();
          insertionTest4.display(10, "\nInsertion Sort for test4.txt:");
          System.out.println("\n\nInsertion Sort comparison counter: " + insertionTest4.compIS);
          
          // Quicksort for text4.txt, displaying the sorted array and the comparison counter
          Sort quickTest4 = new Sort(100);
          quickTest4.readIn("test4.txt");
          quickTest4.quickSort();
          quickTest4.display(10, "QuickSort for text4.txt:");
          System.out.println("\n\nQuickSort comparison counter: " + quickTest4.compQS);
          
          /** Refined Quicksort for text3.txt **/
          // Display the unsorted array
          Sort test5 = new Sort(100);
          test5.readIn("test3.txt");
          test5.display(10, "Array of Integers from text3.txt:");
          
          // Refined Quicksort, followed by Insertion sort
          // for text3.txt, displaying the sorted array and the comparison counter
          test5.newQuicksort();
          test5.insertionSort();
          test5.display(10, "\nRefined QuickSort for text3.txt:");
          System.out.println("\n\nRefined QuickSort comparison counter: " + test5.compQS);
          System.out.println("\nInsertion Sort comparison counter: " + test5.compIS);
          int total = test5.compQS + test5.compIS;
          System.out.println("\nTotal comparison counter: " + total);
      }
    
} /** End of Test class **/