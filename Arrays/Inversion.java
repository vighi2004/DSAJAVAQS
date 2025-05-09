//count inversion with help of Merge sort O(n logn).
public class Inversion{
    public static int count=0;
    public static void mergesort(int[] arr,int si ,int end) {
        if(si>=end){
            return;
        }
        int mid=si+(end-si)/2;
        //left array
        mergesort(arr,si,mid);
        //right array
        mergesort(arr, mid+1, end);
        merge(arr,si,mid,end);
    }
    public static void merge(int[] arr,int si,int mid,int end) {
        int i=si;
        int j=mid+1;
        int k=0;
        int temp[]=new int[end-si+1];
        //sorting full array and storing in temp array.
        while(i<=mid&&j<=end){
            if(arr[i]>arr[j]){
                count+=mid-i+1;
                temp[k]=arr[j];
                j++;
            }
            else{
                temp[k]=arr[i];
                i++;
            }
            k++;
        }
        //left array if remain than store
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //right array if remain than store.
        while(j<=end){
            temp[k++]=arr[j++];
        }
        //copying array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }

    }
   public static void main(String[] args) {
    int arr[]={2,4,1,3,5};
    mergesort(arr,0,arr.length-1);
    if(count>0){
    System.out.println("inversion required "+count); 
    }
    else{
        System.out.println("Array is already sorted");
    }
}
}
