import java.util.*;
public class TopKElement {
    public static void main(String args[]){
                int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};
                int max=Integer.MIN_VALUE;
                for(int i=0;i<arr.length;i++){
                    max=Math.max(max,arr[i]);
                }
                int[] arr1=new int[arr.length];
                 Arrays.sort(arr);
                int n = arr.length;
                for (int i = 0; i < n; ) { 
                    int count = 1;
                    for (int k = i + 1; k < n && arr[i] == arr[k]; k++) {
                        count++;
                        i = k;
                    }
                    arr1[i]=count;
                    i++; 
                }
                for(int i=0;i<arr1.length;i++){
                    System.out.print(" "+arr1[i]);
                }
            }
        }
        
     
    


   