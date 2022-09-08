package ProgrammingPathshala;
import java.util.Scanner;

public class MinimumSwaps {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n];
        int k=sc.nextInt();
		for(int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
        int lc=0, maxcount=0, ans=0, count=0;
        for(int i=0;i<n;i++){
            if(array[i]<=k) lc++;
        }
        for(int i=0;i<lc;i++){
            if(array[i]<=k){
                count++;
                maxcount++;
            }
        }
        for(int j=lc;j<n;j++){
            if(array[j]<=k) count++;
            if(array[j-lc]<=k) count--;
            maxcount=Math.max(maxcount, count);
        }
        ans=lc-maxcount;
        System.out.print(ans);
        sc.close();
    }
}


/*
 * Here we have to calculate the number of swaps required to bring all the number smaller than or equal to a given nummber k.
 * We have calculated the number of elements that are equal to or smaller than k which are stored in lc(count of legal elements)
 * which would be the size of the window or subarray in which the elements are to be stored.
 * We do not actually store the values in another array but calculate the size of window.
 * 
 * Technique used for solving the above problem is Sliding Window.
 * Time complexity for solving the problem is o(n) and space complexity is o(1).
*/