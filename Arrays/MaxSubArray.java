//O(n^3) brute-force approach
public class MaxSubArray {
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        int maxsum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currentsum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    currentsum=arr[k]+currentsum;
                   
                }
                if(maxsum<currentsum){
                    maxsum=currentsum;
                }
                System.out.println();
              
            }
         
        }
        System.out.println("max sum is:"+maxsum);
       
    }
}
