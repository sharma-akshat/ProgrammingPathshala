package ProgrammingPathshala;
import java.util.*;
public class preComputation1 {

    public static void printSum(int[] array, int l, int r, int n)
    {
        int preSum[]=new int[n];
        preSum[0]=array[0];
        for(int i=1;i<n;i++){
            preSum[i]=array[i]+preSum[i-1];
        }
        int sum=preSum[r]-preSum[l-1];
        System.out.print("Sum from l to r is: "+sum);
    }
    public static void main(String gg[])
    {   
        try (Scanner sc = new Scanner(System.in)) {
            int array[]={1, -1, 2, 4, 8};
            int query=2;
            while(query>0){
                System.out.print("Enter the upper bound:");
                int l=sc.nextInt();
                System.out.print("Enter the lower bound:");
                int r=sc.nextInt();
                printSum(array, l, r, array.length);
                System.out.println();
                query--;
            }
        }
    }
}
/*  one naive/brute-force approach could be that we apply a for loop from the upper bound to the lower bound adding up all the elements
 *  encountered, but then the time complexity would be O(q*n) where q is the number of queries and n is the number of operations
 *  or additions performed.
 *  In the above solution we already calculated the sum from a fixed end, i.e., from index 0 (preSum)(we can also do this using
 *  the rare end and name it as sufSum(suffix sum)) till every index and stored it into an array.
 *  Now we only require to find the sum upto the upper bound and subtract the sum upto lowerbound-1 index from it and we get our answer.
 *  time complexity for adding the sum to an array would be o(n) and for every query the desired result is achieved from a single operation
 *  of subtraction so it gives o(1) time complexity.
 *  Hence the total complexity would be O(q+n) and not O(q*n), which is optimized.
 */
