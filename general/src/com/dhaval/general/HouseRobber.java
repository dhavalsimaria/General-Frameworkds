/**
 * 
 */
package com.dhaval.general;

import java.util.Scanner;

/**
 * @author Dhaval
 * BOTH DP AND ODD-EVEN VARIABLES METHOD SHOWN
 */
public class HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array: ");
		int arrSize = scn.nextInt(); 
		
		int arr[] = new int[arrSize];
		
		System.out.print("Enter "+ arrSize +" elements: ");
		
		for(int i = 0; i < arrSize; i++){
			arr[i] = scn.nextInt();
		}
		
//		int result1 = houseRobDP(arr); 		//Using DP
//		System.out.println("Max. amount that can be robbed is: " + result1);
		
		int result2 = houseRob(arr); 		//Using ODD-EVEN variables
		System.out.println("Max. amount that can be robbed is: " + result2);
	}

	public static int houseRob(int arr[]){
		if(arr.length == 0 || arr == null)
			return 0;
		
		int total[] = new int[2];
		total[0] = 0;
		total[1] = 0;
		for(int i = 0; i < arr.length; i ++){
			if(i % 2 == 0){
				total[0] += arr[i];
				total[0] = total[0] > total[1] ? total[0] : total[1];
			} else {
				total[1] += arr[i];
				total[1] = total[0] < total[1] ? total[1] : total[0];
			}
		}
		
		int maxTotal = total[0] > total[1] ? total[0] : total[1];
		return maxTotal;
	}
	
	public static int houseRobDP(int arr[]){
		if(arr == null || arr.length == 0)
			return 0;
		
		if(arr.length == 1)
			return arr[0];
		
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(dp[0], arr[1]);
		for(int i = 2; i < arr.length; i++){
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
		}
		return dp[arr.length-1];
	}
}
