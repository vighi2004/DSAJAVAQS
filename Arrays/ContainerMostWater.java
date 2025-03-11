//Calculating container with most water in time O(n).
import java.util.*;
public class ContainerMostWater {
    public static void main(String[] args) {
    int[] arr={1,8,6,2,5,4,8,3,7};
    int left=0;
    int right=arr.length-1;
    int h1=0;
    int h2=0;
    int maxstore=Integer.MIN_VALUE;
    while(left<right){
         int areastore=Math.min(arr[left],arr[right])*(right-left);
         if(maxstore<areastore){
            maxstore=areastore;
            h1=arr[left];
            h2=arr[right];
         }
         if (arr[left] < arr[right]) {
            left++;
        } else {
            right--;
        }

    }
    System.out.println(maxstore);
    System.out.println("TWo Cointainer Height which stores Most Water are: ");
    System.out.print("Height 1 is: "+h1+" "+"Height 2 is: "+h2);

}
}
