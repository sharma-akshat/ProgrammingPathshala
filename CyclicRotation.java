package ProgrammingPathshala;

public class CyclicRotation {

    public static void rev(int i, int j, int arr[]){
        int x=0;
        while(i<=j){
            x=arr[i];
            arr[i]=arr[j];
            arr[j]=x;
            i++;
            j--;
        }
    }
    public static void main(String gg[]){
        int array[]={1,2,3,4,5,6};
        int n=array.length;
        int k=3;
        if(k>=n){
            k=k%n;
        }
        rev(n-k, n-1, array);
        rev(0, n-k-1, array);
        rev(0, n-1, array);
        for(int i=0;i<n;i++){
            System.out.print(array[i]+" ");
        }
    }
}


/*
 * Here we have to rotate the array in clockwise direction by k positions.
 * The time complexity here is o(n) and space compexity is O(1).
 * 
 * The brute force approach is written in arrays folder in cyclicRotation.java file.
 * Time complexity of that solution is O(k*n) where k is the number of positions and n is the size of array.
 * So we have to optimize it. For that we see that after every few rotations the array is repeating itself.
 * eg. array=[1 0 2]
 * 1st rotation is 2 1 0
 * 2nd rotation is 0 2 1
 * 3rd rotation is 1 0 2
 * 4th rotation is 2 1 0
 * 5th rotation is 0 2 1
 * 6th rotation is 1 0 2
 * 
 * So we see that on every 3rd rotation the array is repeated. at 0, 3, 6 we get the same array.
 * Similarly on 1 and 4 and same on 2 and 5.
 * So after every k%n rotation we see the same array result.
 * 3%3 = 6%3 = 0
 * 1%3 = 4%3 = 1
 * 2%3 = 5%3 = 2
 * 
 * so if we use a loop that runs for i=0 till i<n and an inner loop that runs for j=i and j<k%n
 * then we get a solution for time complexity of O(n^2) which is an optimized solution.
 * 
 * This could be further optimzed to O(n) if we take another array say temp of same size as array.
 * We will put the elements of array on the position index+k in the temp.
 * If array=[1 4 3 5 6 2] and k=2 so we will move each character to i+k posiitons on temp where i is the index of that element.
 * So if we see it logically the temp would be formed like [_ _ 1 4 3 5] 6 2. Here both 6 and 2 will exceed the size of temp and
 * an ArrayIndexOutOfBounds exception will occur. So we use the concept of k%n here to keep the elements inside the array's length.
 * If the size of index is greater than n, then we will calculate the modulus of index with size of array and put the element
 * on the index equal to modulus.
 * if((i+k)>=n)temp[(i+k)%n]=array[i];
 * 
 * This solution will give us a time complexity of O(n) which is the most optimized time complexity but the space complexity
 * is increased here. In this solution because we are using another array so the space complexity increased to O(n) from O(1).
 * 
 * This could be reduced and the final optimized solution is written above.
 * There we reversed the parts of array. Took k elements from the last and reversed them and then reversed the remaining part
 * of the array and finally reversed the entire array, giving us the expected output.
*/