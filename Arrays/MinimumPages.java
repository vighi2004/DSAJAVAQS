//finding minimum pages allocated to each studnet using binary search in O(nlogn).
class MinimumPages{
    public static boolean isvalid(int arr[],int student,int n,int mid){
        int pages=0;
        int st=1;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                return false;
            }
            else if(pages+arr[i]<=mid){
                pages=pages+arr[i];
            }
            else{
                 st++;
                 pages=arr[i];
            }
        }
        if(st==student){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[]={12,37,64,90};
        int n=arr.length;
        int student=2;
        int start=0;
        int minPage=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            end=end+arr[i];
        }
        while(start<=end){
            int mid=(start+end)/2;
            if(isvalid(arr,student,n,mid)){
               minPage=mid;
               end=mid-1;//checking if there getting minimum in left array as array is sorted.
            }
            else{
                start=mid+1;//right side check if that mid is not valid beacuse in left smaller are there.
            }
        }
        System.out.println("minimum Pages are: "+minPage);
    }
}
