//optimised solution using kadane's algorithm O(n);
public class MaxSubArrayKadane {

    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        int maxsum=0;
        int currentMax=0;
        int currentSum[]=new int[arr.length];
        currentSum[0]=arr[0];
        for(int i=1;i<currentSum.length;i++){
            if(currentSum[i-1]+arr[i]>0)
            {
               currentMax=currentSum[i-1]+arr[i];
               if(currentMax>maxsum){
                maxsum=currentMax;
               } 
            }

        }
        System.out.println("max subarray is:"+maxsum);
    }
}