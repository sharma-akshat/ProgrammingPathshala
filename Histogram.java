package ProgrammingPathshala;

public class Histogram {
    public static void main(String gg[])
    {
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long array[]=new long[n];
		for(int i=0;i<n;i++){
			array[i]=sc.nextLong();
		}
		long pm[]=new long[n];
        long sm[]=new long[n];
        long amt=0;
        pm[0]=array[0];
        for(int i=1;i<n;i++){
            pm[i]=Math.max(pm[i-1],array[i]);
        }
        sm[n-1]=array[n-1];
        for(int j=n-2;j>=0;j--){
            sm[j]=Math.max(sm[j+1],array[j]);
        }
        for(int i=1;i<=n-2;i++){
            long h=array[i];
            long h1=pm[i-1];
            long h2=sm[i+1];
            long dech=Math.min(h1,h2);
            if(dech<=h) continue;
            else amt+=(dech-h);
        }
        System.out.println(amt);
        sc.close();
    }
}

/*
 * The above problem calculates the amount of water that will be trapped between the pillars
 * where the array consists of the heights of different pillars.
 * Time complexity for above solution will be O(N).
 * This problem is also solved using the pre computation technique.
*/
