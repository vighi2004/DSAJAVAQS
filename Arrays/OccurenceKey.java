//print indices of occurrence key using recursion.
public class OccurenceKey {
    public static void check(int i, int arr[],int key) {
        if(i==arr.length){
           return;
        }
        if(arr[i]==key){
            System.out.print(" "+i);
          
        }
        check(i+1,arr,key);
    }
    public static void main(String[] args) {
        int arr[]={3,2,4,5,6,2,7,2,2};
        int i=0;
        int key=2;
        check(i,arr,key);

       }
}
