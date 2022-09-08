package ProgrammingPathshala;
import java.util.Scanner;
public class BuyingandSellingStocks {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n];
		for(int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
		int pmin[]=new int[n];
		pmin[0]=array[0];
		int profit=0;
		for(int i=1;i<n;i++){
			if(pmin[i-1]>array[i]) pmin[i]=Math.min(pmin[i-1], array[i]);
			else{
				profit=Math.max((array[i]-pmin[i-1]), profit);
				pmin[i]=Math.min(pmin[i-1], array[i]);
			}
		}
		System.out.print(profit);
        sc.close();
    }
}


/*
 * Here we have considered buying and selling the stocks on different days.
 * You can buy stocks on a day earlier than the day you want to sell it.
 * We want to return the maximum profit that could be achieved.
 * If no profit is achieved we return 0.
 * Technique used is pre computation.
 * 
 * Here we can have another solution rather than the above one.
 * The above soluiton gave us a time complexity of O(n) and space complexity O(1).
 * Another solution is as follows:
 * int pmin[]=new int[n];
		int smax[]=new int[n];
		pmin[0]=array[0];
		smax[n-1]=array[n-1];
		for(int i=1;i<n;i++){
			pmin[i]=Math.min(pmin[i-1], array[i]);
		}
		for(int j=n-2;j>=0;j--){
			smax[j]=Math.max(smax[j++], array[j]);
		}
		int profit=0;
		for(int k=0;k<n;k++){
			if(pmin[k]>smax[k]) continue;
			else profit=Math.max(profit,(smax[k]=pmin[k]));
		}
		System.out.print(profit);
        The mentioned solution though correct but exceed the time limit and also here we maintain 3 arrays
        which increases our space complexity.
*/