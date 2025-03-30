//crossword puzzle.
package Backtracking;
import java.util.*;
public class combinationSum {
    public static void combination(int arr[],int target,int i,ArrayList <Integer> a){
        if(i<arr.length){
        //base
        if(target==0){
            System.out.println(a);
            return;
        } 
        if (target < 0) {   // Stop if target goes negative
            return;
        }
        a.add(arr[i]);
        combination(arr,target-arr[i],i+1,a);
        a.remove(a.size()-1);

        combination(arr, target, i+1, a);
    }
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8};
        int target=8;
        ArrayList <Integer> a=new ArrayList<>();
        combination(arr,target,0,a);
    }
    
}
