//counting size of  subarrays which are distinct .
package Hashing;
import java.util.*;
public class CountDistictSubArr {
    public static void main(String[] args) {
   	HashSet <List<Integer>>  set=new HashSet<>();
		int arr[]={1,2,10};
	        int totalSize=0;
		for(int i=0;i<arr.length;i++){
		    int j=i;
		    List<Integer> subarray = new ArrayList<>();
		   while(j<arr.length){
		        subarray.add(arr[j]);
                        set.add(new ArrayList<>(subarray));
			j++;
		   }   
		}
	         for (List<Integer> sub : set) {
                 totalSize += sub.size();
                    }
                System.out.println(totalSize);
}
}
