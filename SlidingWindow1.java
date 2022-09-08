package ProgrammingPathshala;

public class SlidingWindow1 {
    public static void main(String gg[]){
        int array[]={4,7,3,1,5,2};
        int k=3, sum=0;
        int n=array.length;
        for(int i=0;i<k;i++){
            sum+=array[i];
        }
        for(int j=k;j<n;j++){
            System.out.print(sum+" ");
            sum+=array[j];
            sum-=array[j-k];
        }
        System.out.print(sum);
    }
}

/*
 * Here we are summing up the subarray of size k from the entire array and returning the sum amount.
 * If k=3 then we have to sum up every subarray with 3 elements and return the sum.
 * The technique used for solving this is known as Sliding Window technique.
 * Time complexity of the above solution is O(n) and space complexity is O(1).
 * 
 * Brute force approach would be that we apply 2 nested for loops.
 * One from 0 to n-1 and another from index i uptil kth index from i.
 * Which would have given us a time complexity of O(n^2).
*/