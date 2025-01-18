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
     public static void search(int rotateArray[],int target){
        int start=0;
        int end=rotateArray.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(rotateArray[mid]==target){
                System.out.println("element is found at index "+mid+" is "+target);
                break;
            }
            else if(rotateArray[target]>rotateArray[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println("-1");

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
        search(rotateArray,target);


    }
    
}
