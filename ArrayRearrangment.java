package ProgrammingPathshala;
import java.util.Scanner;

public class ArrayRearrangment {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(array[i]>=0){
                int index=array[i], value=i;
                while(index!=i){
                    int temp=array[index];
                    array[index]=-(value+1);
                    value=index;
                    index=temp;
                }
                array[index]=-(value+1);
            }
        }
        for(int i=0;i<n;i++){
            array[i]=(-1*array[i])-1;
            System.out.print(array[i]+" ");
        }
        sc.close();
    }
}

/*
 * Here we have to arrange the array in a manner such that
 * If array[1]=5 then array[5]=1. If array[i1]=i2, then array[i2]=i1.
 * We have been given a permutation array ‘Arr[N]’ which will contain elements between 0 to N.
 * 
 * Brute force Approach:
 * Using a temporary array - When we try to place the elements at their new indices at that time
 * we may lose the old elements present at those indices. Therefore we can use a temporary array to store
 * the elements at their desired position.
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * The problem while replacing the old value with the new value is that the previous elements are being overwritten.
 * So in the above approach we make use of cyclic iterations.
 *  ___<2___ _<3_             |   _<1 _<2     __<5___
 * |        |    |            |  |   |   |   |       |
 * |        ^    ^            |  |   ^   ^   |       ^
 * |        |    |            |  |   |   |   |       |
 * 1    3   0    2 --> 2 0 3 1|  2   0   1   4   5   3 --> 1 2 0 5 3 4
 * |    |        |            |  |       |   |   |   |
 *      ^        ^            |  |       |   |   ^   ^
 * |_0>_|____1>__|            |  |__0>___|   |>3_|_>4|
 * 
 * But as evident from the figure, there may not necessarily be a single cycle. It can contain multiple cycles and
 * thus we would need to track if an element has already been modified in some other cycle or not.
 * For this, we can make use of the fact that 0<=Arr[ i ]<=N-1, therefore we can add 1 to the elements and multiply them by -1.
 * ie. If element at index ‘i’ has been visited then, Arr[ i ] -> - ( Arr[ i ] + 1 ).
 * This thing chnages the element into a negative number seeing which we determine that it is being visited.
 * Time complexity: O(N)
 * Space complexity: O(1)
*/