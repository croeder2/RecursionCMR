import java.util.*;
import java.io.*;
//imports

/**
 * This class models the dynamic way to calculate a Catalan Number
 * @author claireroeder
 *
 */
public class CatalanDynamic {

	/**
	 * INstance variables
	 */
	private static int n;
	private static int nValue;
	private static Scanner scan;
	private static int numerator;
	private static int denominator1;
	private static int[] valueNum;
	private static int[] valueDenominator1;
	private static int[] value;
	private static int catalan;
	private static long startTime;
	private static long endTime;
	private static long time;
	private static boolean more;
	private static String answer;
	
	/**
	 * Main method that does computation
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[]args) throws FileNotFoundException {
		
		/**
		 * PrintStream set up so that data can be stored in a file
		 */
		PrintStream cdynamic = new PrintStream(new File("CD.txt"));
		PrintStream console = System.out;
		
		do {
		/**
		 * Prompts user to enter a value for n
		 */
		System.out.println("Please enter a value for n:");
		n = scan.nextInt();
		nValue = n;
		
		/**
		 * Marks starting time for computation
		 */
		startTime = System.nanoTime();
		
		/**
		 * Finds values for numerator and denominator
		 */
		numerator = 2 * n;
		denominator1 = n + 1;
		
		/**
		 * Sets up values to 1 so that they can be multiplied in the for loop
		 */
		int value1 = 1;
		int value2 = 1;
		int value3 = 1;
		
		/**
		 * Arrays that hold each value in each of the elements
		 */
		valueNum = new int[numerator];
		valueDenominator1 = new int[denominator1];
		value = new int[n];
		
		/**
		 * For loops that assign each value to an element in the array and are all multipled together
		 */
		for(int i = 0; i < numerator; i++) {
			numerator = valueNum[i];
			numerator--;
			i++;
			
			value1 = value1 * valueNum[i]; //multiplies each value
			
		}
		
		for(int j = 0; j < denominator1; j++) {
			denominator1 = valueDenominator1[j];
			denominator1--;
			j++;
			
			value2 = value2 * valueDenominator1[j]; //multiplies each value
			
		}
		
		for(int k = 0; k < n; k++) {
			n = value[k];
			n--;
			k++;
			
			value3 = value3 * value[k]; //multiplies each value
		}
		
		/**
		 * Calculates the catalan number using each value found
		 */
		catalan = value1 / (value2 * value3);
		
		/**
		 * Marks end time for program and converts to seonnds,
		 * changes any time less than a second to 1 second
		 */
		endTime = System.nanoTime();
		time = (endTime - startTime)/1000000000;
		if(time < 1) {
			time = 1;
		}
		
		/**
		 * Prints results to file
		 */
		System.setOut(cdynamic);
		System.out.println(n + ", " + catalan + ", " + time);
		
		/**
		 * Prints results to console
		 */
		System.setOut(console);
		System.out.println("C(" + nValue + ") = " + catalan);
		
		/**
		 * asks user if they wish to run the program again
		 */
		System.out.println("Would you like to try again? Y/N");
		answer = scan.next();
		if(answer.equals('y')) {
			more = true;
		}
		else {
			more = false;
		}
		
		}while(more == true);
		
	}//end main
}//end class
