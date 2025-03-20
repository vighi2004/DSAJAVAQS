//finding minimum time require to paint in time O(nlogn).
public class PainterPartition {
    public static boolean isvalid(int arr[],int painter,int n,int mid){
        int time=0;
        int pt=1;
        for(int i=0;i<n;i++){
            if(time+arr[i]<=mid){
                time=time+arr[i];
            }
            else{
                 pt++;
                 time=arr[i];
            }
        }
        if(pt<=painter){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[]={5, 10, 30, 20, 15};
        int n=arr.length;
        int painter=3;
        int start=0;
        for(int i=0;i<arr.length;i++){
            start=Math.max(start,arr[i]);
        }
        int time=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            end=end+arr[i];
        }
        while(start<=end){
            int mid=(start+end)/2;
            if(isvalid(arr,painter,n,mid)){
               time=mid;
               end=mid-1;//checking if there getting minimum in left array as array is sorted.
            }
            else{
                start=mid+1;//right side check if that mid is not valid beacuse in left smaller are there.
            }
        }
        System.out.println("Minimum Time required to paint: "+time);
    }
}

