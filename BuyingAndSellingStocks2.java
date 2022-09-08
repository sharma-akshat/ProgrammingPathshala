package ProgrammingPathshala;
import java.util.*;

public class BuyingAndSellingStocks2 {
    public static int[] calculateProfitforFirstTransaction(int array[]){
		int n=array.length;
		int profitInFirstTransaction[]=new int[n];
		int minimumLeft=Integer.MAX_VALUE;
		int profit=0;
		for(int i=0;i<n;i++){
			minimumLeft=Math.min(minimumLeft, array[i]);
			profit=Math.max(profit, array[i]-minimumLeft);
			profitInFirstTransaction[i]=profit;
		}
		return profitInFirstTransaction;
	}
	
	public static int[] calculateProfitforSecondTransaction(int array[]){
		int n=array.length;
		int profitInSecondTransaction[]=new int[n];
		int maximumRight=Integer.MIN_VALUE;
		int profit=0;
		for(int i=n-1;i>=0;i--){
			maximumRight=Math.max(maximumRight, array[i]);
			profit=Math.max(profit, maximumRight-array[i]);
			profitInSecondTransaction[i]=profit;
		}
		return profitInSecondTransaction;
	}
	
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n];
		for(int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
		int profit1[]=calculateProfitforFirstTransaction(array);
        int profit2[]=calculateProfitforSecondTransaction(array);
        int maxProfit=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) maxProfit=Math.max(maxProfit, profit1[i]+profit2[i]);
		System.out.print(maxProfit);
        sc.close();
    }
}

/*
 * Problem Statement:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions(max 2 transations allowed only).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * 
 * We here first calculated the profits from the left side of the array or the prefix area.
 * Afterwards, we calculated the profits from the right side of the array or the suffix area.
 * After calculating the profits we added the profits from both the arrays on the same number of index
 * and returned the maximum sum attained.
 * 
 * Time complexity for this approach would be O(n) and space complexity would be O(n) as we overall used 4 arrays here.
*/