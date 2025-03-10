public class RadixSort {
    public static void radix(int[] arr,int n,int[] result) {
        int max=getMax(arr, n);
        for(int pos=1;max/pos>0; pos*=10){
            countSort(arr, n, pos,result);
        }
        
    }
    public static int getMax(int[] arr,int n) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
             max=Math.max(max, arr[i]);
        }
        return max;
    }
    public static void countSort(int[] arr,int n,int pos,int[] result) {
        int count[]=new int[10];
        for(int i=0;i<n;i++){
            count[(arr[i]/pos)%10]++;
        }
        for(int i=1;i<10;i++){
        //position
        count[i]=count[i]+count[i-1];
        }
        for (int i = n - 1; i >= 0; i--) {  // Start from last element for stability
            int digit = (arr[i] / pos) % 10;
            result[count[digit] - 1] = arr[i];  // Place at correct index
            count[digit]--;  // Decrement count to avoid overwriting
        }
        for (int i = 0; i < n; i++) {  
            arr[i] = result[i];  // Copy sorted data back to arr[]
        }
        
    }
    public static void main(String[] args) {
        int arr[]={432,8,530,90,88,231,11,45,677,199};
        int n=arr.length;
        int result[]=new int[n];
        radix(arr,n,result);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

    }
    
}
