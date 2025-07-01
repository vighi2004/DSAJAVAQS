//climbing stairs using recursion
package DP;
public class climimgStairs {
    public static int stairs(int n){
        if(n==0){
         return 1;
        }
        if(n<0){
            return 0;
        }
        int ways=stairs(n-1)+stairs(n-2);
        return ways;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(stairs(n));
    }
}
