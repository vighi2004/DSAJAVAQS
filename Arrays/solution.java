import java.util.Arrays;
public class solution {
    public static int[] searchRange(int[] nums, int target) {
         int start=0;
         int end=(nums.length-1);
         while(start<=end){
            int mid=(start+end)/2;
              if(nums[mid]==target){
                 if(nums[mid]==nums[mid+1]){
                    return new int[]{mid,mid+1};
                 }
              }
              else if(target>nums[mid]){
                   start=mid+1;
              }
               else if(target<nums[mid]){
                   end=mid-1;
              }
            }
             
        
    return new int[]{-1,-1};    
    }
    public static void main(String args[]){
        int nums[]={5,7,7,8,8,10};
        int target=8;
        int result[]=searchRange(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
   