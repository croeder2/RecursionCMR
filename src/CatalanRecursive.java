import java.io.*;
import java.util.*;
//imports

/**
 * This class models the recursive way to find a catalan number
 * @author claireroeder
 *
 */

public class CatalanRecursive {
	
	/**
	 * Instance variables
	 */
		private static long n; //user input
		private static Scanner scan; //scanner
		private static long value1; //stores value for factorial of numerator
		private static long value2; //stores value for factorial of n +1
		private static long value3; //stores value for favtorial or n
		private static long catalan; //stores actual catalan number
		private static long startTime; //starting point for run time
		private static long endTime; //ending point for run time
		private static long time; //actual run time
		private static boolean more;
		private static String answer;
		
		/**
		 * This acts as a recursive function where a number is repeatedly multiplied by the one below it and subtracts one
		 * @param n
		 * @return
		 */
		static long factorial(long n) {
			if(n == 1) {
				return 1;
			}
			else {
				return (n * factorial(n-1));
			}
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			
			/**
			 * Print stream to store data in file
			 */
			PrintStream crecursive = new PrintStream(new File("CR.txt"));
			PrintStream console = System.out;
			/**
			 * Do while loop so that the user can run again if they wish
			 */
			do {
				/**
				 * Prompts user to enter a value for n
				 */
			System.out.println("Please enter a value for n: ");
			n = scan.nextLong();
			
			/**
			 * Records time at start of program
			 */
			startTime = System.nanoTime();
			
			/**
			 * Finds factorial for 2n, n+1, and n
			 */
			value1 = factorial(n * 2);
			value2 = factorial(n + 1);
			value3 = factorial(n);
			
			/**
			 * Calculates the catalan value
			 */
			catalan = value1 / (value2 * value3);
			
			
			/**
			 * Records ending time and converts it to seconds, making value 1 if it takes less than 1 second to compute
			 */
			endTime = System.nanoTime();
			time = (endTime - startTime)/1000000000;
				if(time < 1) {
					time = 1;
				}
				
				/**
				 * Prints data to file
				 */
			System.setOut(crecursive);	
			System.out.println(n + ", " + catalan + ", " + time);
			
			/**
			 * Prints data to actual console
			 */
			System.setOut(console);
			System.out.println("C(" + n + ") = " + catalan);
			
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
