//counting size of  subarrays which are distinct .
package Hashing;
import java.util.*;
public class CountDistictSubArr {
    public static void main(String[] args) {
   	HashSet <String>  set=new HashSet<>();
		int arr[]={1,2,10};
		for(int i=0;i<arr.length;i++){
		    int j=i;
		    StringBuilder res=new StringBuilder(" ");
		   while(j<arr.length){
		       String str = String.valueOf(arr[j]);
		       str+=',';
		       res=res.append(str);
		       set.add(res.toString());
		       j++;
		   }
		   
		}
		int count=0;
		for(String k:set){
		   for(int i=0;i<k.length();i++){
		       if(k.charAt(i)==','){
		           count+=1;
		       }
		   }
		}
		System.out.println(count);
}
}
