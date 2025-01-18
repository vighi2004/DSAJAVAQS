public class insertionSort {
    public static void main(String[] args) {
        int arr[]={4,5,1,3,2};
        for(int i=1;i<arr.length;i++){
            int currvalue=arr[i];
            int prev=i-1;
            //finding index to insert.
            while(prev>=0 && arr[prev]>currvalue){
                 arr[prev+1]=arr[prev];
                 prev--;
            }
            //insertion part.
            arr[prev+1]=currvalue;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
