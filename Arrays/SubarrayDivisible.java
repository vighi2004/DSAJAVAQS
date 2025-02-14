//Finding longest subarrya which is divisible by K:-O(n2)
public class SubarrayDivisible {
    public static void divisible(int[] arr,int k) {
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        int maxlength=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            int sum=0;
            for(int j=i;j<arr.length;j++){
                int end=j;
                if(start!=0){
                sum=prefix[end]-prefix[start-1];
                }else{
                    sum=prefix[end];
                }
                int count =j-i+1;
                if(sum%k==0){
                    maxlength=Math.max(maxlength,count);
                }
            }
        }
        System.out.println("maxlength of subarray which is divisible by K is:"+maxlength);
    }
    public static void main(String[] args) {
        int arr[]={2, 7, 6, 1, 4, 5};
        int k=3;
        divisible(arr,k);
    }
    
}
