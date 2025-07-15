//Maximize sum of consecutive differences in a circular array.
package Greedy_Algo;
import java.util.*;
public class MaxSum {
    public static void main(String[] args) {
        int arr[]={2,4,8,1};
        Arrays.sort(arr);
        ArrayList<Integer> res=new ArrayList<>();
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            if(left==right){
                res.add(arr[left]);
            }
            else{
            res.add(arr[left++]);
            res.add(arr[right--]);
        }}
        for(int j=0;j<arr.length;j++){
            System.out.print(" "+res.get(j));
        }
        System.out.println();
        int sum=0;
        for(int j=0;j<arr.length;j++){
             sum+=Math.abs(res.get(j)-res.get((j+1)%arr.length));
         }
         System.out.println(sum);

    }
    
}
