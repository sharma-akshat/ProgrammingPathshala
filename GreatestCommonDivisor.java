package ProgrammingPathshala;
import java.util.*;

public class GreatestCommonDivisor {

    public int GCD(int maxNum, int minNum){
        int rem=0;
        if(minNum==0)return maxNum;
        while((maxNum%minNum)!=0){
            rem=maxNum;
            maxNum=minNum;
            minNum=rem%minNum;
        }
        return minNum;
    }
    public static void main(String gg[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int maxNum=Math.max(a,b);
        int minNum=Math.min(a,b);
        GreatestCommonDivisor gcd=new GreatestCommonDivisor();
        int ans=gcd.GCD(maxNum, minNum);
        System.out.print(ans);
        sc.close();
    }
}
