package ProgrammingPathshala;
import java.util.Scanner;

public class ArrayRearrangement2 {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int oldValue=array[i]%n;
            array[oldValue]=(n*i)+array[oldValue];
        }
        for(int i=0;i<n;i++){
            array[i]=array[i]/n;
            System.out.print(array[i]+" ");
        }
        sc.close();
    }
}

/*
 * Here we discussed another approach for array rearrangement, an alternate approach.
 * The problem that we were facing earlier was to preserve the old value while placing the new value at its position. 
 * So, we can think of a number that can represent both the old and the new value together.
 * Hint: Using the fact that 0<=Arr[ i ]<=N-1
 * 
 * Let the modified element be x such that x = N * new_value + old_value.
 * We would be able to extract both the new & the old value from x as:
 * old_value = x%N
 * new_value = x/N
 * 
 * Once we have modified all the elements then we can divide them by N to find out the new values at each array index.
 * Time complexity: O(N)
 * Space complexity: O(1)
*/