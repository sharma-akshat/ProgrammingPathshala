package ProgrammingPathshala;
import java.util.Scanner;
public class SpecialSearching {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int m=sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(i+", "+j+": ");
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the element to be searched: ");
        int key=sc.nextInt();
        int i=0, j=n-1;
        while(i<m && j>=0){
            if(arr[i][j]==key){
                System.out.print(i+", "+j);
                break;
            }
            else if(arr[i][j]>key){
                j--;
            }
            else i++;
        }
        sc.close();
    }
}

/*
 * Here, we have been given a 2d matrix Arr[M][N] with sorted rows & columns along with a key ‘k’.
 * We have to return the coordinates of the key if it is present in the matrix otherwise return (-1, -1).
 * 
 * Brute Force - Traverse the matrix to search for the key ‘k’ and return its coordinates if present otherwise returns (-1,-1).
 * Time complexity: O(MN) 
 * Space complexity: O(1)
 * 
 * Binary Search - Since the rows are sorted, therefore we can think of applying binary search while searching in each row.
 * Time complexity: O(MlogN)
 * Space complexity: O(1)
 * The above time complexity could have been achieved even if only the rows were sorted
 * but here the columns are also sorted too so this could be further optimized.
 * 
 * This approach involves observing the elements of the matrix and smartly traversing it to find the key.
 * We can start traversing either from the Top Right(TR) or the Bottom Left(BL) cell of the matrix and move accordingly,
 * comparing the key with the matrix elements.
 * Worst case could be that we start from top right and end at bottom left that would give us M+N complexity.
 * Time complexity: O(M+N)
 * Space complexity: O(1)
 * 
 * Note: We can not start the traversal from Top Left(TL) or Bottom Right(BR) cell because their neighbouring elements
 * are either greater or smaller to them, therefore we do not get any clue on which direction we should move next. 
*/