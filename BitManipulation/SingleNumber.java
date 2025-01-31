//finding unique number using beit manupilation.
public class singleNumber{
    public static int single(int[] nums) {
        int unique=0;
        for(int i=0;i<nums.length;i++){
                unique=(unique ^ nums[i]);
            }
            
        
    return unique;
    }    
    public static void main(String args[]){
        int nums[]={2,2,1};
        System.out.println(single(nums));
    }
}