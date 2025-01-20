//transpose array.
public class TransposeArray {
    public static void main(String[] args) {
        
    int arr[][]={{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(i!=j){
            int temp=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=temp;
             }
            }

    }
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            System.out.print(" "+arr[i][j]);

        }
        System.out.println();
    }

    
}
}
