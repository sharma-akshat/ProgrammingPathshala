package ProgrammingPathshala;
import java.util.Scanner;

public class Rotate90Degrees {
    public static void main(String gg[]){
        Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] matrix = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j]=scan.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N/2; j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][N-j-1];
				matrix[i][N-j-1]=temp;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
    	}
        scan.close();
    }
}


/*
 * Here theproblem statement is as follows:
 * You are given an N∗N 2D matrix, rotate the matrix by 90 degrees (clockwise).
 * You have to rotate the Matrix, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * 
 * INPUT:
 * First line of input contains an integer N, the size of the square Matrix.
 * Next N lines of input contains N space-separated integers describing rows of the matrix.
 * 
 * OUTPUT:
 * Print the final Matrix after rotation.
 * 
 * CONSTRAINTS:
 * 1 ≤ N ≤ 20
 * -1000 ≤ matrix[i][j] ≤ 1000
 * 
 * This is a generic solution which could be applied over any matrix with size NxN.
 * 
 * Time complexity for this approach would be O(NxN).
*/