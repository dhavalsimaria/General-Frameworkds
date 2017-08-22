/**
 * 
 */
package com.dhaval.general;

import java.util.Scanner;

/**
 * @author a611021
 *
 */
public class PatternSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	      System.out.print("Enter an integer and I will display a pattern for you: ");
	      int n = input.nextInt();

	      displayPattern(n);
	}
	
	public static void displayPattern(int n)
	   {
	      final int MAX_ROWS = n;
	      int maxIndent = 0;

	      for (int row = 1; row <= MAX_ROWS; row++)
	      { 
	         /*for (int space = (n - 1); space >= row; space--)
	         {
	            System.out.print(" ");
	         }*/
	    	 maxIndent = (-2*(row-MAX_ROWS));
	    	 //int space=((3*row)-1);
	    	 for (int indentSpace = 1; indentSpace <= maxIndent; indentSpace++)
		     {
		            System.out.print(" ");
		     }

	         for (int number = row; number >= 1; number--)
	         {
	            System.out.print(number + " "); 

	         }
	         System.out.println();
	      }
		
	   }
}
