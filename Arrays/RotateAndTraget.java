//rotating array and finding if it present at that index.The array is in ascending order O(n);
import java.util.*;
public class RotateAndTraget {
     public static void rotate(int arr[],int pivot,int rotateArray[]){
        int n=arr.length;
        int i=0;
        int index=(arr.length)-pivot;
        while((n-1)>=(pivot+i)){
            rotateArray[i]=arr[pivot+i];
            i++;
        }
        for(int j=0;j<pivot;j++){
            rotateArray[index+j]=arr[j];
        }
        
     }
     public static int search(int rotateArray[],int target){
        int left=0;
        int right=rotateArray.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(rotateArray[mid]==target){
                return mid;
            }
            if(rotateArray[right]>=rotateArray[mid]){
                if(rotateArray[right]>=target&&target>rotateArray[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            else{
                if (rotateArray[left] <= target && target < rotateArray[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;  
                    }
            }
        }
        return -1;

       

     }
    public static void main(String[] args) {
        int arr[]={0,1,2,4,5,6,7};
        int rotateArray[]=new int[arr.length];
        Scanner sc=new Scanner(System.in);
        System.out.println("give index from where you want to rotate");
        int pivot=sc.nextInt();
        rotate(arr,pivot,rotateArray);
        System.out.println("enter target:");
        int target=sc.nextInt();
        System.out.println("element found at index "+search(rotateArray,target)+" of given target "+target);


    }
    
}
