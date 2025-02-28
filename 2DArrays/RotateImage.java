//rotatte array by 90 degree brute force approach O(n^2) and space is O(n^2) use transpose and reverse it for constant space complexity.
public class RotateImage {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        int arr1[][]=new int[arr.length][arr.length];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr1[i][j]=arr[arr.length-1-j][i];
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

    }
}
