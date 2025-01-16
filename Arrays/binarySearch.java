import java.util.*;
public class binarySearch {
       public static int check(int arr[],int search){
        
         int start=0;
         int end=(arr.length-1);
         
         while(start<=end){
            int mid=(start+end)/2;
              if(arr[mid]==search){
                 return mid;
                 
              }
              else if(search>arr[mid]){
                   start=mid+1;
              }
               else if(search<arr[mid]){
                   end=mid-1;
              }
            }
             
         return -1;
            
      
   }
        
        public static void main(String[] args) {
         System.out.println("enter search element");
         Scanner sc=new Scanner(System.in);
         int search=sc.nextInt();
        int arr[]={2,4,6,8,10,12,14};
        int a=check(arr,search);
        System.out.println("element"+search+"is found at index:"+a);
         
        
        }

    
}