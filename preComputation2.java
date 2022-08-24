package ProgrammingPathshala;

public class preComputation2 {
    
    public static void main(String gg[])
    {
        Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	long p=sc.nextLong();
	long q=sc.nextLong();
	long r=sc.nextLong();
	long array[]=new long[n];
	for(int i=0;i<n;i++){
		array[i]=sc.nextLong();
	}
        long PM[]=new long[n];
        long SM[]=new long[n];
        PM[0]=p*array[0];
		for(int i=1;i<n;i++){
            PM[i]=Math.max(PM[i-1], p*array[i]);
        }
        SM[n-1]=r*array[n-1];
		for(int j=n-2;j>=0;j--){
            SM[j]=Math.max(SM[j+1],r*array[j]);
        }
        long result=Long.MIN_VALUE;
        long a=Long.MIN_VALUE;
		for(int k=0;k<n;k++){
            a=PM[k]+(q*array[k])+SM[k];
            result=Math.max(result,a);
        }
        System.out.print(result);
        sc.close();
    }
}

/*
 * Here we maximized the expression(p*arr[i]+q*arr[j]+r*arr[k] where i<j<k strictly.
 * The brute force approach could be that we apply three nested for loops for each element and then
 * try to get the answer, but that will give us a time complexity of O(n^3).
 * Here we calculated a prefix max and a suffix max and then calculated the middle element.
 * All the three loops run on a complexity of O(n) hence the final time complexity would be O(n).
 * 
 * If say i<j<k then the array elements need to be different from each other.
 * We can use p*array[i]+q*array[j]+r*array[k] as i cannot be equal to j and to k.
 * For such scenarios the loop will run from 1 to n-2 and not from 0 to n-1.
 * And the expression changes from a=PM[k]+(q*array[k])+SM[k] to a=PM[k-1]+(q*array[k])+SM[k+1]
*/
