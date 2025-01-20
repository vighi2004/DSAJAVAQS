package Strings;
import java.util.*;
public class shortestPath {
    public static void main(String[] args) {
        String str="WNEENESENNN";
        int E=0;
        int N=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==str.charAt(2)){
                E++;
            }
            else if(str.charAt(i)==str.charAt(1)){
                     N++;

            } 
            else if(str.charAt(i)==str.charAt(0)){
                E--;

           }
           else{
                N--;
                
           }    
        }
        int a= ((E*E)+(N*N));
        double displacemnt=Math.sqrt(a);
        System.out.println(displacemnt);
        System.out.println(E);
        System.out.println(N);
        System.out.println(a);
       

        }
    }
    

