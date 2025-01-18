//optimise bubble sort code for best case complexity is O(n);
public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={1,8,7,4,5};
        for(int i=0;i<(arr.length-1);i++){
            int swap=0;
            for(int j=0;j<(arr.length-1-i);j++){
                if(arr[j]>arr[j+1]){
                    swap++;
                     int temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                }
                
                }
                if(swap==0){
                    System.out.println("array is sorted");
                    break;
               }
               else{
                   System.out.println("sorting:"+swap);
                   
               }
           

        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
}
