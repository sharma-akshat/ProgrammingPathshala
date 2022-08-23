package ProgrammingPathshala;

public class preComputation2 {
    
    public static void main(String gg[])
    {
        int array[]={1,2,3,4,-5};
        int i=1, j=2, k=-3;
        int n=array.length;
        int PM[]=new int[n];
        int SM[]=new int[n];
        PM[0]=i*array[0];
        for(int r=1;r<n;r++){
            int x=i*array[r];
            PM[r]=Math.max(PM[r-1], x);
        }
        SM[n-1]=k*array[n-1];
        for(int u=n-2;u>=0;u--){
            int y=k*array[u];
            SM[u]=Math.max(SM[u+1],y);
        }
        int result=Integer.MIN_VALUE;
        for(int z=1;z<n-2;z++){
            int a=PM[z-1]+(j*array[z])+SM[z+1];
            result=Math.max(result,a);
        }
        System.out.print("Result is : "+result);
    }
}

/*
 * Here we maximized the expression(p*arr[i]+q*arr[j]+r*arr[k] where i<j<k strictly.
 * The brute force approach could be that we apply three nested for loops for each element and then
 * try to get the answer, but that will give us a time complexity of O(n^3).
 * Here we calculated a prefix max and a suffix max and then calculated the middle element.
 * All the three loops run on a complexity of O(n) hence the final time complexity would be O(n).
*/