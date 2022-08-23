package ProgrammingPathshala;

public class Histogram {
    public static void main(String gg[])
    {
        int array[]={0,1,0,2,1,3,0,2};
        int n=array.length;
        int pm[]=new int[n];
        int sm[]=new int[n];
        int amt=0;
        pm[0]=array[0];
        for(int i=1;i<n;i++){
            pm[i]=Math.max(pm[i-1],array[i]);
        }
        sm[n-1]=array[n-1];
        for(int j=n-2;j>=0;j--){
            sm[j]=Math.max(sm[j+1],array[j]);
        }
        for(int i=1;i<=n-2;i++){
            int h=array[i];
            int h1=pm[i-1];
            int h2=sm[i+1];
            int dech=Math.min(h1,h2);
            if(dech<=h) continue;
            else amt+=(dech-h);
        }
        System.out.println("Result is: "+amt);
    }
}

/*
 * The above problem calculates the amount of water that will be trapped between the pillars
 * where the array consists of the heights of different pillars.
 * Time complexity for above solution will be O(N).
 * This problem is also solved using the pre computation technique.
*/