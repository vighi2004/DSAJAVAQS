//printing all subarrays indexes whose sum is zero.
public class SubArrySum0 {
    public static void main(String[] args) {
        int arr[]={ 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        for(int i=0;i<arr.length-1;i++){
            int j=i+1;
            int sum=arr[i];
            while(j<arr.length){
                 sum=sum+arr[j];
                 if(sum==0){
                    System.out.println("Subarray found from Index"+ i +"to"+ j);
                }
                 
                 j++;
            }
        }
    }
}
