package ProgrammingPathshala;
import java.util.*;

public class MaxVowelsinSubstringofGivenLength {

    static Scanner sc=new Scanner(System.in);
	public static int maxVowels(String s, int k){
        int n=s.length();
        int count=0, maxcount=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                count++;
                maxcount++;
            }
        }
        for(int j=k;j<n;j++){
            if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || s.charAt(j)=='o' || s.charAt(j)=='u') count++;
            if(s.charAt(j-k)=='a' || s.charAt(j-k)=='e' || s.charAt(j-k)=='i' || s.charAt(j-k)=='o' || s.charAt(j-k)=='u')count--;
			maxcount=Math.max(maxcount, count);
		}
        return maxcount;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int t=sc.nextInt();
        String s;
		int k;
        while(t>0){
            s=sc.next();
			k=sc.nextInt();
            int ans=maxVowels(s,k);
            System.out.println(ans);
            t--;
        }
        sc.close();
    }
}

/*
 * The problem statement is as follows:
 * Given a string S and an integer K, print the maximum number of vowel letters in any substring of S with length K.
 * 
 * INPUT:
 * First-line will contain T, number of test cases.
 * Then Each test case contains string S and an integer K.
 * 
 * OUTPUT:
 * For each test case, print the maximum number of vowel letter in any substring of S with length K on a separate line.
 * 
 * CONSTRAINTS:
 * 1 ≤ T ≤ 10
 * 1 ≤ s.length ≤ 10^5
 * s consists of lowercase English letters
 * 1 ≤ k ≤ s.length
 * 
 * We used the sliding window technique and checked for each window of k elements the maximum number of vowels in any window.
 * Time compelxity for this solution would be O(t+n) where t is the number of queries.
 * And space complexity is O(1).
*/