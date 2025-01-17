//O(n^2)  using prefix array
public class MaxSubArrayPrefix {
    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        int maxsum=0;
        int currentsum=0;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=arr[i]+prefix[i-1];

        }

        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                if(start!=0){
                currentsum=prefix[end]-prefix[start-1];
                }
                else{
                    currentsum=prefix[end];
                }
                   
                }
                if(maxsum<currentsum){
                    maxsum=currentsum;
                }

              
            }
            System.out.println("max sum is:"+maxsum);
         
        }
       
       
    }

    
