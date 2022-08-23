package ProgrammingPathshala;

public class maxChunks {
    public static void main(String gg[]){
        int array[]={0,1,2,3,4,5};
        int cmax=0, count=0;
        for(int i=0;i<array.length;i++){
            cmax=Math.max(cmax, array[i]);
            if(cmax==i) count++;
        }
        System.out.print("Max chunks possible are: "+count);
    }
}

/*
 * Here we are calculating the max number of chunks an array could be split into.
 * This solution is also performed using the pre computation technique.
 * cmax or current max when is equal to the index then it is the split point for an array.
 * if i=2 ancd cmax=2 then a chunk can be formed by splitting the array on that point.
 * Here the array is a permutation of numbers from 0 to n-1 where n is the size of array.
 * If size is 5 then array is {0,1,2,3,4}.
 * Time compoexity of the above solution is O(n).
 * 
 * A naive or brute force solution for the problem statement is as follows:
 * i=0, ans=0
 * while(i<n){
 *  for(j=i;j<n;j++){
 *      if(canBeChunked(i,j)) break;    
 *  }
 * i=j+1;
 * ans++;
 * }
 * 
 * boolean canBeChunked(int i, int j){
 *  count=0;
 *  for(k=i to j){
 *      if(arr[k]>=i and arr[k]<=j){
 *          count++;
 *      }
 *      if(count=(j-i+1))return true;
 *      return false;
 *  }
 * }
 * Time complexity for the brute force approach would be O(n^2)
*/