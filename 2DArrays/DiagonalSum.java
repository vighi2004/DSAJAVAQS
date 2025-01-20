//diagonal sum of matrix optimsed solution O(n).
public class DiagonalSum {
    public static void main(String[] args) {
        int sum=0;
        
        int arr[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int i=0;i<arr.length;i++){
            //primary diagonal
             sum=sum+arr[i][i];
            //secondary diagonal
            sum=sum+arr[i][(arr.length-1-i)];
             }
             System.out.println(sum);
        }
      
        
    }