//finding Kth Smallest Element from Array O(n+k); 
public class kthSmallEle {
    public static void kthSmallEle(int [] arr,int k) {
    int s;
    int max=Integer.MIN_VALUE;
    //sorting using counting array.
    for(int i=0;i<arr.length;i++){
        max=Math.max(max,arr[i]);
    }
    int count[]=new int[max+1];
    for(int i=0;i<arr.length;i++){
        count[arr[i]]++;
    }
    int j=0;
    for(int i=0;i<count.length;i++){
        while(count[i]>0){
             arr[j]=i;
             j++;
             count[i]--;
        }
    }
    System.out.println("kth i.e." + " "+k + " smallest element is :"+arr[k-1]);
    }   
    public static void main(String[] args) {
        int arr[]={7, 10, 4, 3, 20, 15 };
        int k=3;
        kthSmallEle(arr, k);
    }
    
}
