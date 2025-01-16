//optimised solution
public class reverseArray {
    public static void reverse(int arr[])
    {   int n=arr.length;
        int mid=(arr.length)/2;
        for(int i=0;i<mid;i++)
        {  
            int temp=arr[i];
            //System.out.println(temp);
            arr[i]=arr[n-i-1];
            //System.out.print(arr[i]);
            arr[n-i-1]=temp;
            
        
        }
        
      
    }    
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        reverse(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        
        
    }
    
}
