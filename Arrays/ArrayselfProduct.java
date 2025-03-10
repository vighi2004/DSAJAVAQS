//but not for zero O(n).
public class ArrayselfProduct {
    public static void main(String[] args) {
        int arr[]={10,3,5,6,2};
        int mul=1;
        for(int i=0;i<arr.length;i++){
            mul=mul*arr[i];
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=mul/arr[i];
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
        
        
    }
}
