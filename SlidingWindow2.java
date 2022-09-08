package ProgrammingPathshala;

public class SlidingWindow2 {
    public static void main(String gg[]){
        int array[]={2,2,1,2,4,6,2,1};
        int n=array.length;
        int k=3, x=2;
        int freq=0;
        for(int i=0;i<k;i++){
            if(array[i]==x) freq++;
        }
        for(int j=k;j<n;j++){
            System.out.print(freq+" ");
            if(array[j]==x){
                freq++;
            }
            if(array[j-k]==x){
                freq--;
            }
        }
        System.out.print(freq);
    }
}


/*
 * Here the problem statement was to find out the frequency of x in every window of array with size k.
 * We have used the sliding window technique for solving the problem.
 * Every time a new element is added to the sub array and an existing one is removed from it. So we just have to check whether the
 * coming element is equal to the given number or not and the one which is removed was equal to it or not.
 * Accordingly we will increase and decrease the frequency value.
 * Time complexity of this approach would be O(n) and space complexity would be O(1).
*/