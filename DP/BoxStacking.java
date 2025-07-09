//find max height to stack boxes.
package DP;
import java.util.*;
public class BoxStacking {
    static class info implements Comparable<info>{
        int width;
        int length;
        int height;
        public info(int w,int l,int h){
            this.width=w;
            this.length=l;
            this.height=h;
        }
        @Override
        public int compareTo(info i2){
          if (this.width != i2.width)
             return this.width - i2.width;
          else if (this.length != i2.length)
               return this.length - i2.length;
          else
              return this.height - i2.height; 
        }
    } 
    public static void LIS(info sortedCuboids[]){
        int n=sortedCuboids.length;
        int dp[]=new int[n];
        for (int i=0;i<sortedCuboids.length;i++) {
            dp[i]=sortedCuboids[i].height;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
           if (sortedCuboids[j].width <= sortedCuboids[i].width &&
            sortedCuboids[j].length <= sortedCuboids[i].length &&
            sortedCuboids[j].height <= sortedCuboids[i].height) {
              dp[i]=Math.max(dp[i],dp[j]+sortedCuboids[i].height);
            }
        }
    }
    System.out.println("max height is: "+dp[n-1]);

    }
    public static void main(String[] args) {
        int cuboid[][]={{50,45,20},
                        {95,37,53},
                        {45,23,12}
                          };                 
        for(int i=0;i<cuboid.length;i++){
            Arrays.sort(cuboid[i]);
        }
        info[] sortedCuboids = new info[cuboid.length];
        for (int i = 0; i < cuboid.length; i++) {
            sortedCuboids[i] = new info(cuboid[i][0], cuboid[i][1], cuboid[i][2]);
        }
        Arrays.sort(sortedCuboids);
        // for (int i=0;i<sortedCuboids.length;i++) {
        //     //System.out.print(sortedCuboids[i].width + " ");
        // }
        LIS(sortedCuboids);
        
    }
}
