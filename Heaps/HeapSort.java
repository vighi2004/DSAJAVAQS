//sorting heap
package Heaps;
public class HeapSort {
    public static void sort(int arr[]){
        //build maxheap for ascending order
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        //largest ele push to end;
        for(int i=n-1;i>0;i--){
            //swap
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
    public static void heapify(int arr[],int i,int n){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<n&&arr[left]<arr[maxIdx]){
            maxIdx=left;
        }
        if(right<n&&arr[right]<arr[maxIdx]){
            maxIdx=right;
        }
        if(maxIdx!=i){
            //swap
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr,maxIdx,n);
        }
        

    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};//min heap given
        sort(arr);
        //print
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    
}
