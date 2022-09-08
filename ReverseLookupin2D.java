package ProgrammingPathshala;
import java.util.Scanner;

public class ReverseLookupin2D {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        long array[][]=new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]=sc.nextInt();            }
        }
        long ans=0;
		long mod=(long)1e9+7;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                long contri=((((((i + 1) * (j + 1)) % mod * ((m - i) * (n - j)) % mod) % mod) * (array[i][j]) % mod))%mod;
				ans=(ans % mod+ contri % mod) % mod;
            }
        }
        System.out.print(ans);
        sc.close();
    }
}


/*
 * Here we solved a problem based on reverse lookup in a 2D array.
 * We have a 2d matrix Arr[M][N] and we have to find the sum of all the submatrices.
 * We can define a unique submatrix by using the indices of either 
 * 1. Top Left (TL) & Bottom Right (BR) cell
 * 2. Bottom Left (BL) & Top Right (TR) cell
 * 
 * Brute force approach could be that we can create some nested loops to iterate through
 * every possible TL and BR valid combination to find all submatrices and calculates their
 * total sum respectively.
 * For this approach the time complexity would be O((m^3)*(n^3)) and space complexity will be O(1).
 * 
 * Using Reverse Lookup we can find out the contribution of each array element to the total sum.
 * An element Arr[ i ][ j ] will be a part of all those submatrices who have:
 * 1. 0<=TLi<=i & 0<=TLj<=j
 * 2. i<=BRi<=M-1 & j<=BRj<=N-1
 * Therefore, by the Rule of Products, Arr[ i ][ j ] appears = (i+1)*(j+1)*(M-i)*(N-j)
 * 
 * Total sum = Σi(Σj(Arr[i][j]*(i+1)*(j+1)*(M-i)*(N-j)))     [from i=0 to M-1 & j=0 to N-1]
 * 
 * Time complexity: O(MN)
 * Space complexity: O(1)
 * 
 * Note: The above method involves integer multiplication and the product may be out of the valid integer range.
 * Therefore we may have to calculate the modulus of the product each time by some large prime number say, 10^9 + 7.  
*/