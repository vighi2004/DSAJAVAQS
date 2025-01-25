//leetcode qs removduplicates element and print length and array.
import java.util.Arrays;
public  class pr{
    public static void threeSumClosest(int[] nums,int val) {
        int[] expectnum=new int[nums.length];
       
       
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                expectnum[j]=nums[i];
                j++;
            }
            
          
        }
        System.out.print(j+"  ");
        System.out.print("nums:"+"[");
        for(int i=0;i<j;i++){
            if(i!=j&&i!=0){
                System.out.print(",");
            }
            System.out.print(expectnum[i]);
            
        }
        System.out.print("]");                       
    }  
    public static void main(String args[]){
        int[] nums={3,2,2,3};
        int val=3;
        threeSumClosest(nums,val);
    }  
}

