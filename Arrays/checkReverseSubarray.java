import java.util.*;
public class checkReverseSubarray {
    public static void main(String[] args) {
        int arr[]={1,2,5,4,3};
        int sort[]={1,2,5,4,3};
        Arrays.sort(sort);
        int check[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==sort[i]){
                check[i]=0;
            }
            else{
                check[i]=arr[i];
            }
        }

}}
