package ProgrammingPathshala;
import java.util.Scanner;

public class EfficientProcessing {
    public static void main(String gg[]){

        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
		long array[][]=new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]=sc.nextLong();
            }
        }
        long psum[][]=new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0)psum[i][j]=array[i][j];
                else psum[i][j]=psum[i][j-1]+array[i][j];
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(i==0){
                    psum[i][j]=psum[i][j];
                }
                else psum[i][j]+=psum[i-1][j];
            }
        }        
		int k=sc.nextInt();
		long ans=0;
		int i1,j1,i2,j2;
        int transaction;
        for(int p=0;p<k;p++){
			i1=sc.nextInt();
        	j1=sc.nextInt();
        	i2=sc.nextInt();
        	j2=sc.nextInt();
			ans=psum[i2][j2];
			transaction=0;
            if((j1-1)>=0){
                ans=ans-psum[i2][j1-1];
                transaction++;
            }
            if((i1-1)>=0){
                ans=ans-psum[i1-1][j2];
                transaction++;
            }
            if(transaction>1){
                ans=ans+psum[i1-1][j1-1];
            }
			System.out.println(ans);
        }
        sc.close();
    }
}

/*
 * Here we have calculated the sum of a subarray whose top left and bottom right coordinates are given to us.
 * We had done a question in 1D array of this type in preComputation1.java file.
 * This problem statement is solved using pre computation technique.
 * 
 * A brute force approach for this problem could be to calculate the sum of each submatrix individually to answer the query.
 * Time complexity: O(Q*(M*N)) where Q is the number of queries and M is row number and N is column number.
 * Space complexity: O(1)
 * 
 * In the above approach we calculated the prefix sum for each index in the matrix and created another matrix psum[m][n].
 * For a submatrix: TL(i1, j1) and BR(i2, j2) - Required Sum = PS[i2][j2] - A1 - A2 + A3 where,
 * A1 = PS[i1-1][j2] where i1>=1
 * A2 = PS[i2][j1-1] where j1>=1
 * A3 = PS[i1-1][j1-1] where i1>=1 & j1>=1
 * So the overall Time complexity is O(Q+MN) where Q is the number of queries, m is row number
 * and n is columns number and the space complexity is O(MN).
*/