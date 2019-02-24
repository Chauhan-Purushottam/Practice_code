//Given an array A on size N, you need to find the number of ordered pairs (i,j) such that (i<j) and (A[i]>A[j]).

//import for Scanner and other utility classes*/
import java.util.*;

class OrderPair {
    public static long count = 0;

    void merge(int arr[] , int start, int mid, int end)
    {
        int p = start, q = mid+1;
        int []temp  = new int[end-start+1];
        int k=0;
        for(int i = start; i<=end; i++)
        {
            if(p>mid)
                temp[k++] = arr[q++];
            else if(q>end)
                temp[k++] = arr[p++];
            else if(arr[p]<=arr[q])
                temp[k++] = arr[p++];
            else
                {
                	temp[k++] = arr[q++];
                	count+=(long)(mid-p+1);
                }
        }
        for(int i = 0; i<k; i++)
            arr[start++] = temp[i];
        
    }
    
    void merge_sort(int arr[] , int start , int end)
    {
        if(start < end){
            
         int mid  = (start+end)/2;
        
         merge_sort(arr, start, mid);
         merge_sort(arr, mid+1, end);
        
         merge(arr, start, mid, end);
          
        }
    }
   
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0;i<n;i++)
            arr[i] = s.nextInt();
        
        OrderPair op = new OrderPair();
        op.merge_sort(arr,0,n-1);
        System.out.println(op.count);

    }
}
