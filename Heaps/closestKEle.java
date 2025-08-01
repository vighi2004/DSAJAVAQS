//closest K elements in sorted array.
package Heaps;
public class closestKEle {
    public static void main(String[] args) {
        int arr[]={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k=4;
        int x=35;
        int mid=(arr.length)/2;
        int i=mid-1;
        int j=mid;
        int count=0;
        while(i>=0||j<=arr.length){
            int a=Math.abs(x-arr[i]);
            int b=Math.abs(x-arr[j]);
            if(a==0){
                i--;
            }
            else if(b==0){
                j++;
            }
            else if(a==b){
                count++;
                System.out.print(arr[j]+" ");
                i--;
                j++;
            }
            else if(a>b){
                count++;
                System.out.print(arr[j]+" ");
                j++;
            }
            else{
                count++;
                System.out.print(arr[i]+" ");
                i--;
            }
            if(count==k){
                break;
            }

        }
    }
}
