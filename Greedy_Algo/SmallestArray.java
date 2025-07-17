//Lexicographically smallest array after at-most K consecutive swaps
package Greedy_Algo;
public class SmallestArray {
    public static void main(String[] args) {
        int arr[]={7,6,9,2,1};
        int k=3;
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
        for(int i=0;i<arr.length&&k>0;i++){
            int minpos=i;
            int minele=arr[i];
            for(int j=i;j<=k+i&&j<arr.length;j++){
                if(arr[j]<minele){
                    minele=arr[j];
                    minpos=j;
                }
            }
            if(arr[i]==minele){
                continue;
            }
            else if(minpos-i<=k){
                int temp=arr[minpos];
                arr[minpos]=arr[i];
                arr[i]=temp;
                k=k-(minpos-i);
            }
        }
        //print array
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }

    }
}
