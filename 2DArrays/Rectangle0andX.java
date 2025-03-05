//printing matrix Rectangle X ans O using spiral matrix concept. 
public class Rectangle0andX{
    public static void main(String[] args) {
        int m=5;
        int n=6;
        String arr[][]=new String[m][n];
        String ch="X";
        int startrow=0;
        int endrow=arr.length-1;
        int startcol=0;
        int endcol=arr[0].length-1;
        while(endrow>=startrow && endcol>=startcol){
            //right
            for(int i=startcol;i<=endcol;i++){
                arr[startrow][i]=ch;
            }
            //bottom
            for(int i=startrow;i<=endrow;i++){
                arr[i][endcol]=ch;
            }
            //left
            if (startrow < endrow) {
            for(int i=endcol;i>=startcol;i--){
                arr[endrow][i]=ch;
            }
        }
            //top
            if (startcol < endcol) {
            for(int i=endrow;i>=startrow;i--){
                arr[i][startcol]=ch;
            }
        }
            startrow++;
            startcol++;
            endcol--;
            endrow--;
            if(startrow%2==0){
                ch="X";
            }
            else{
                ch="O";
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

      
            }
        }
    
    

