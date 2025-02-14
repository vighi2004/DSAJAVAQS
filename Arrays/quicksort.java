public class quicksort {
       public static void quicksort(int[] arr,int low,int high){
         if(low<high){
          int pivot=partition(arr,low,high);
          quicksort(arr,low,pivot-1);
          quicksort(arr, pivot+1, high); 
         }
       }
       public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
         }
        //adjusting position of pivot
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;     
        return i;//pivot index
       }
       public static void main(String[] args) {
        int[] arr={8,5,2,3,6,9};
        quicksort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
       }
}
