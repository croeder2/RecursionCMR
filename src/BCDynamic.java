import java.util.*;
import java.io.*;
//imports

/**
 * This class models a dynamic way to find the binomial coefficient
 * @author claireroeder
 *
 */
public class BCDynamic {

	/**
	 * Instance variables
	 */
	private static long n;
	private static long k;
	private static long diff;
	private static long numSets;
	private static long numItems;
	private static long nValue;
	private static long kValue;
	private static long diffValue;
	private static long[] valuesN;
	private static long[] valuesK;
	private static long[] valuesDiff;
	private static long binomial;
	private static Scanner scan;
	private static long startTime;
	private static long endTime;
	private static long time;
	private static boolean more;
	private static String answer;
	
	
	/**
	 *
	 * Main method where program is executed
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		//Printstream so that data can be stored in the file as well
		
		PrintStream bcdynamic = new PrintStream(new File("BCD.txt"));
		PrintStream console = System.out;
		
	do {
	/**
	 * This code prompts the user to enter values for n and k
	 */
	System.out.println("Please enter a value for n:");
	n = scan.nextLong();
	numItems = n;
	System.out.println("Please enter a value for k:");
	k = scan.nextLong();
	numSets = k;
	
	startTime = System.nanoTime();
	/**
	 * This finds the difference between n and k for one of the values in the denominator
	 */
	diff = n - k;
	
	/**
	 * This sets up arrays for the size of n, k and n - k respectively so that values can be stored in them
	 */
		valuesN = new long[(int) n];
		valuesK = new long[(int) k];
		valuesDiff = new long[(int) diff];
		
		/**
		 * This sets up a number 1 so that it can be multiplied in the loop
		 */
		nValue = 1;
		kValue = 1;
		diffValue = 1;
		
		/**
		 * Three for loops for n, k and n-k where each value and every number below it is stored in an array and
		 * the factorial is found through value * value[i]
		 */
	for(int i = 0; i < n; i++) {
		n = valuesN[i]; //The value of n is stored in the array, and then n is subtracted by 1 to store all values of n -1
		n--;
		i++;
		
		nValue = nValue * valuesN[i]; //This represents the factorial
	}
	
	for(int j = 0; j < k; j++) {
		k = valuesK[j]; //The value for k is stored and then k is subtracted by 1 to store preceding values
		k--;
		j++;
		
		kValue = kValue * valuesK[j]; //Factorial
	}
	
	for(int a = 0; a < diff; a++) {
		diff = valuesDiff[a];
		diff--;
		a++;
		
		diffValue = diffValue * valuesDiff[a]; //Factorial
	}
	
	binomial = nValue / (kValue * diffValue);
	
	/**
	 * Records end time and converts to seconds, making it 1 second if computing time is less than a second
	 */
	endTime = System.nanoTime();
	time = (endTime - startTime)/1000000000;
	if(time < 1) {
		time = 1;
	}
	/**
	 * Prints to file
	 */
	System.setOut(bcdynamic);
	System.out.println(numItems + ", " + numSets + ", " + binomial + ", " + time);
	/**
	 * Prints to console itself
	 */
	System.setOut(console);
	System.out.println("There are" + binomial + "ways to choose " + numSets + "subsets from " + numItems + "items" );
	
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
