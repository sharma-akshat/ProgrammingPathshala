package ProgrammingPathshala;
import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2)return 0;
        int maxNum=Integer.MIN_VALUE, minNum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxNum=Math.max(maxNum,nums[i]);
            minNum=Math.min(minNum, nums[i]);
        }
        if(minNum==maxNum)return 0;
        int gap=(maxNum-minNum)/(n-1);
        if(((maxNum-minNum)%(n-1))!=0)gap++;
        int minArr[]=new int[n], maxArr[]=new int[n];
        for(int i=0;i<n;i++){
            minArr[i]=Integer.MAX_VALUE;
            maxArr[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++){
            int bucket=(nums[i]-minNum)/gap;
            minArr[bucket]=Math.min(minArr[bucket],nums[i]);
            maxArr[bucket]=Math.max(maxArr[bucket], nums[i]);
        }
        int ans=Integer.MIN_VALUE;
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(minArr[i]==Integer.MAX_VALUE)continue;
            if(prev==Integer.MIN_VALUE) prev=maxArr[i];
            else{
                ans=Math.max(ans, minArr[i]-prev);
                prev=maxArr[i];
            }
        }
        return ans;
    }

    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        MaximumGap mg=new MaximumGap();
        int res=mg.maximumGap(array);
        System.out.print(res);
        sc.close();
    }
}

/*
 * Problem Statement:
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
 * If the array contains less than two elements, return 0.
 * You must write an algorithm that runs in linear time and uses linear extra space.
 * 
 * CONSTRAINTS:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 
 * Here we have used a technique named Bucketization.
 * We calculated the maximum consecutive gap that could be possible between the array elements using gap=(maxNum-minNum)/(n-1) formula.
 * We then created buckets for each element of the size gap.
 * Example if the maximum and minimum elements are 70 and 20 and array is of size 6 then gap = 70-20/5 = 50/5 = 10
 * So now the bucket that is formed is as follows:
 * for 20 --> [20, 21, 22, 23, 24, 25, 26, 27, 28, 29] and so on for each 10 elements.
 * This bucket is formed because we do not know exactly what are the middle elements of 20 and 70.
 * Now from these buckets we take out the minimum and the maximum number of elements
 * that are present in the array for a particular bucket and takes a difference between the max element of previous bucket
 * and the minimum element of the current bucket.
 * After calculating all the deifferences we then take out the maximum difference and return it as our result.
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Brute Force - Sort the array and calculate the maximum difference between two consecutive elements.
 * Time complexity: O(NlogN)
 * Space complexity: O(1)
*/