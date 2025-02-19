//Mo's Algorithm.

import java.util.Arrays;

public class lengthSubArray {
    public static void main(String[] args) {
        int arr[]={1,1,2,1,3,4,5,2,8};
        int query[][]={{0,4},{1,3},{2,4}};
        for(int i=0;i<query.length;i++){
            int sum=0;
            for(int j=query[i][0];j<=query[i][query[i].length-1];j++){
                sum=sum+arr[j];
            }
            System.out.println("sum of arr[] in range "+Arrays.toString(query[i])+" is: "+sum);
        }
      
        
       
    }
}

