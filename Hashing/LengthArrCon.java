//print length of sub array whose whose contigouse elemnt is forming.Duplicates can be present in arr.
package Hashing;
import java.util.HashSet;
public class LengthArrCon {
    public static void main(String[] args) {
        int arr[]={10, 12, 12, 10, 10, 11, 10};
        HashSet <Integer> set=new HashSet<>();
        int maxL=0;
        for(int i=0;i<arr.length;i++){
            int j=i;
           int max=Integer.MIN_VALUE;
           int min=Integer.MAX_VALUE;
           while(j<arr.length){
               min=Math.min(min,arr[j]);
               max=Math.max(max,arr[j]);
                if(!set.contains(arr[j])){
                     set.add(arr[j]);
                     if(max-min+1==set.size()){
                        maxL=Math.max(maxL,set.size());       
                }}
                else{
                    break;
                }
            j++;
        }
        set.clear();
    }
                
          System.out.print("max length is: "+maxL); 
   }    
}

