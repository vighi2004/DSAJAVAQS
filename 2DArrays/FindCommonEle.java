//Finding common element in row -wise sorted array.Time(m*n*logn).
public class FindCommonEle {
    public static void main(String[] args) {
    int arr[][]={{1, 2, 3, 4, 5},{2, 4, 5, 8, 10},{3, 5, 7, 9, 11},{1, 3, 5, 7, 9}};
    for(int i=0;i<arr[0].length;i++){
        int target=arr[0][i];
        int count=1;
        for(int j=1;j<arr.length;j++){
            boolean flag=false;
            int left=0;
            int right=arr[j].length-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(arr[j][mid]==target){
                   flag=true;
                   break;
                }
                else if(arr[j][mid]>target){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            if(flag==true){
                count++;
            }
            else{
                break;
            }
        }
        if(count==arr.length){
            System.out.println("common element is :"+target);
            break;
        }
    }     
    }
}
