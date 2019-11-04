import java.util.*;
import java.io.*;
//imports
/**
 * This class models a recursive function for finding binomial coefficients
 * @author claireroeder
 * Recursive Project
 * Fall 2019
 *
 */
public class BCRecursive {

		/*
		 * Instance variables
		 */
		private static long n;
		private static long k;
		private static long a;
		private static long b;
		private static long c;
		private static long difference;
		private static long numWays;
		private static long numSets;
		private static long numItems;
		private static long startTime;
		private static long endTime;
		private static long time;
		private static String answer;
		private static boolean more;
		
		/*
		 * Main method where program is executed
		 */
		public static void main(String[]args) throws FileNotFoundException{
			
			PrintStream bcrecursive = new PrintStream(new File("BCR.txt"));
			PrintStream console = System.out;
		/*
		 * Do while loop so that the user can decide whether or not they want to run program again
		 */
		do {	
			//scanner
		Scanner scan = new Scanner(System.in);
		/*
		 * This code prompts the user to enter values for n and k and stores the original value in a new int
		 */
		System.out.println("Please enter a value for n: ");
		n = scan.nextInt();
		numItems = n;
		System.out.println("Please enter a value for k: ");
		k = scan.nextInt();
		numSets = k;

		
	/*
	 * calculation code
	 */
			
			startTime = System.nanoTime();
			
			if(n < 1 || n == k || k < 1) {
				numWays = 0;
				System.out.println("There are 0 ways to choose" + k + "subsets from " + n + "items");
				endTime = System.nanoTime();
				time = (endTime - startTime)/1000000000;
					if(time < 1) {
						time = 1;
					}
					
					System.setOut(bcrecursive);
					System.out.println(numItems + ", " + numSets + ", " + numWays + ", " + time);
					
					System.setOut(console);
					System.out.println("Calculation time: " + time + "s");
			}
			else {
				long a = n * (n-1);
				n = n-2;
				difference = n - k;
				long b = difference * (difference - 1);
				difference = difference - 2;
				long c = k * k-1;
				k = k-2;
				
				numWays = a / b * c;
				
				
				endTime = System.nanoTime();
				time = (endTime - startTime)/1000000000;
					if(time < 1) {
						time = 1;
					}
					
				System.out.println("Calculation time: " + time + "s");
				
				System.setOut(bcrecursive);
				System.out.println(numItems + ", " + numSets + ", " + numWays + ", " + time);
				
				System.setOut(console);
				System.out.println("There are " + numWays + "ways to choose" + numSets + "subsets from" + numItems + "items");
			}
		
			/**
			 * Reruns progam if user wishes
			 */
		
		System.out.println("Would you like to restart? ");
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
