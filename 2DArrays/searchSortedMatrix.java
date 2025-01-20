//search element in sorted matrix optimised solution using staircase approach O(row+col).
public class searchSortedMatrix {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int key=140;
        int row=0;
        int col=arr.length-1;
        while(row<arr.length&&col>=0){
            if(key==arr[row][col]){
                System.out.println("key found at index: ("+row+","+col +")");
                
            }
            else if(key<arr[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("not found");

    }
    
}
