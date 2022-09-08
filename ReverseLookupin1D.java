package ProgrammingPathshala;
import java.util.*;

public class ReverseLookupin1D {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long array[]=new long[n];
		for(int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
        long ans=0;
		long m=(long)1e9+7;
        for(int i=0;i<n;i++){
			long contribution=((((i+1)%m)*((n-i)%m))%m*array[i]%m)%m;
            ans=(ans%m + contribution%m)%m;
        }
        System.out.print(ans);
        sc.close();
    }
}


/*
 * Here we have calculated the sum of each subarray of the given array.
 * A subarray for [1 2 3] can be [1] [1 2] [1 2 3] [2] [2 3] [3].
 * Sum of all the subarrays is 20.
 * The technique used here is Reverse Lookup for 1 dimensional array.
 * 
 * Brute force approach can be that we apply 2 nested loops to find all the subarrays
 * followed by another loop to calculate their sum.
 * So the time complexity would be o(n^3) and space complexity would be o(1).
 * 
 * To optimize this we can use another approach where we can use 2 nested loops to
 * calculate the subarrays simultaneously with calculating the sum.
 * Time complexity for that approach would be o(n^2) and space complexity would be o(1).
 * 
 * Both the approaches had a time complexity with exponential of n. To reduce it we can use the approach written above.
 * Time complexity for that would be o(n) and space compelxity would be o(1).
 * In the above approach we had calculated sum of every subarray which included the element at index i.
 * The expression (i+1)*(n-i)*array[i] will calculate the sum of all the subarrays that includes array[i] for index i.
 * An element at index i will be a part of all the subarrays whose starting index lies between 0 & i and the ending index lies between i to N-1.
 * Therefore, using the Rule of Products, the total number of times an element Arr[i] appears = (i + 1)*(N - i).
 * Total sum = Σ(Arr[i]*(i+1)*(N-i))    [from i=0 to i=N-1]
 * 
 * The above method involves integer multiplication and the product may go out of the valid integer range.
 * Therefore, we may have to calculate the modulus of the product each time with some large prime number, for example, 10^9 + 7.
*/