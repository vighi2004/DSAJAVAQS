//max equal sum of three stacks;
package Greedy_Algo;
public class MaxEqSum {
    public static int solve(int n1[],int n2[],int n3[]){
        int s1=0,s2=0,s3=0;
        for(int i=0;i<n1.length;i++){
            s1+=n1[i];
        }
        for(int i=0;i<n2.length;i++){
            s2+=n2[i];
        }
        for(int i=0;i<n3.length;i++){
            s3+=n3[i];
        }
        int i=0,j=0,k=0;
        while(true){
            if(i==n1.length||j==n2.length||k==n3.length){
                 return 0;
            }
             if(s1==s2&&s2==s3){
               return s1;
             }
            if(s1>=s2&&s1>=s3){
                s1-=n1[i];
                i++;
            }
            else if(s2>=s1&&s2>=s3){
                s2-=n2[j];
                j++;
            }
            else{
                s3-=n3[k];
                k++;
            }
        }
    }
    public static void main(String[] args) {
        int n1[]={3,2,1,1,1};
        int n2[]={4,3,2};
        int n3[]={1,1,4,1};
        System.out.println(solve(n1, n2, n3));

    }
    
}
