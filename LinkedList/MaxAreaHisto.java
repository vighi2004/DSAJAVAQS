//finding maximum area of rectangle in histogram,BRUTE FORCE APPROACH O(N^2).
public class MaxAreaHisto {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1};
        int max=0;
        for(int i=0;i<arr.length;i++){
            int width=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]<=arr[j]){
                   width++;
                }
                else if(arr[i]>arr[j]&&i<j){ 
                    break;
                }
                else{
                    width=0;
                }
            }
            max=Math.max(max,arr[i]*width);   
        }
        System.out.println(max);
    }
}
