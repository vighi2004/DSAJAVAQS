//printing spiral matrix.
public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int startrow=0;
        int endrow=arr.length-1;
        int startcol=0;
        int endcol=arr.length-1;
        while(endrow>startrow && endcol>startcol){
            //top
            for(int i=startrow;i<endcol;i++){
                System.out.print(" "+arr[startrow][i]);
            }
            //right
            for(int i=startcol;i<endcol;i++){
                System.out.print(" "+arr[i][endcol]);
            }
            //bottom
            for(int i=endrow;i>startrow;i--){
                if(startrow==endrow){
                    break;
                }
                System.out.print(" "+arr[endcol][i]);
            }
            //left
            for(int i=endrow;i>startcol;i--){
                if(startcol==endcol){
                    break;
                }
                System.out.print(" "+arr[i][startcol]);
            }
            startrow++;
            startcol++;
            endcol--;
            endrow--;
        }

      
            }
        }
    
    

