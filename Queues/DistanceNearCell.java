//this is brute force of appraoch to find Dsiatnce nearest to cell 1. 
package Queues;
public class DistanceNearCell {
    public static void solve(int input[][],int output[][]){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                if(input[i][j]==0){
                NearestDistance(input, i, j,output);
                }
                else{
                    output[i][j]=0;
                }
            }
        }
    }
    public static void NearestDistance(int input[][],int cell1,int cell2,int output[][]){
          int min=Integer.MAX_VALUE;
          for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                if(input[i][j]==1){
                    int distance=Math.abs(cell1-i)+Math.abs(cell2-j);
                    min=Math.min(min,distance);
                }
            }
        }
        output[cell1][cell2]=min;


    }
    public static void main(String[] args) {
        int input[][]={{1,0,1},{1,1,0},{1,0,0}};
        int output[][]=new int[input.length][input[0].length];
        solve(input,output);
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(output[i][j]+" ");
                }
                System.out.println();
            }
        
 }

}

