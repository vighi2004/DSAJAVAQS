//counting subarrays which are distinct.
package Hashing;
import java.util.*;
public class CountDistictSubArr {
    public static void main(String[] args) {
    int arr[]={1, 2, 3};
    HashSet <String> set=new HashSet<>();
    for(int i=0;i<arr.length;i++){
       int j=i;
       String str="";
       while(j<arr.length){
            str += Integer.toString(arr[j]);
            set.add(str);
            j++;
       }
    }

    System.out.println("count fo distict subarrays: "+set.size());
}
}
