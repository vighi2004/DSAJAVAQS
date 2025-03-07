//Helping robber to choose particular house where he can get maximum profit and not entering in two consecutive houses ,time is O(2^n).
public class HouseRobber {
      public static int Rob(int[] arr,int i,int max) {
      //base
      if(i>=arr.length){
        return 0;
         
      }
      //recursion
      int pick=Rob(arr,i+2,max)+arr[i];
      int notpick=Rob(arr,i+1,max);
      max=Math.max(notpick,pick);
      return max;
        
      }
      public static void main(String[] args) {
        int arr[]={1,5,3};
        int max=0;
        System.out.println(Rob(arr,0,max));
      }
    
}