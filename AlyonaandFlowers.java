package ProgrammingPathshala;
import java.util.Scanner;

public class AlyonaandFlowers {
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int array[]=new int[n];
		int m=sc.nextInt();
		for(int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
        int psum[]=new int[n];
        psum[0]=array[0];
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1]+array[i];
        }
        int score=0, i1, i2;
        for(int j=0;j<m;j++){
            i1=sc.nextInt();
            i2=sc.nextInt();
            if(i1-1<0){
                continue;
            }
            else if((i1-1)==0){
                if(psum[i2-1]>0)score+=psum[i2-1];
            }
            else {
                if((psum[i2-1]-psum[i1-2])>0)score+=(psum[i2-1]-psum[i1-2]);
            }
        }
        System.out.print(score);
        sc.close();
    }
}

/*
 * Here the question was:
 * You have been given an array of n integers and m choices of subarrays.
 * You can select any of the m choices at most once. You may not even select any of the m choices.
 * When you select a subarray choice, you need to add numbers in that subarray to your score.
 * Print the maximum score you can achieve.
 * 
 * INPUT:
 * The first line contains two integers n and m . The second line contains array elements — a1,a2,...,an.
 * The next m lines contains the m choices of subarrays(starting index li and ending index ri) you may or may not use.
 * 
 * OUTPUT:
 *  the maximum possible score.
 * 
 * CONSTRAINTS:
 * 1 ≤ n,
 * m ≤ 100
 * −100 ≤ ai ≤ 100
 * 1 ≤ li ≤ ri ≤ n
 * 
 * Since the constraints were of smaller ranges, we used int over long.
 * Time complexity for the approach would be O(m+n) as O(n) for calculating the psum and O(1) for each query hence o(m)
 * for m queries. Therefore the final complexity would be O(m+n) and space complexity would be O(n) as maintaining 2 arrays.
*/