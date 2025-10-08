//all possible scores for target printed.
package DP;

public class ReachGivenScore {

    public static int TotalP(int arr[],int target){
        if(target==0){
            return 1;
        }
        int total=0;
        for(int i=0;i<arr.length;i++){
        if(target>=arr[i]){
            total=total+TotalP(arr, target-arr[i]);
        }
    }
    return total;
    }
    public static void main(String[] args) {
        int arr[]={3,5,10};
        int target=20;
        System.out.println("Total possible to reach:-"+TotalP(arr,target));

    }
}
