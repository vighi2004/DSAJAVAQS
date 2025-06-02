//Honer of Towei using Stacks.
import java.util.*;
public class HonerTowei{
    public static void Work(Stack<Integer> S1,Stack<Integer> S3){
       Stack<Integer> S2=new Stack<>(); //Auxiliary pole
       int n=S1.size();
       double power=Math.pow(2, n);
       double iter=power-1;
       for(int i=1;i<=iter;i++){
          if(i%3==0){//movement of destination and auxiliary pole.
             if(S3.isEmpty()&&S2.isEmpty()){
                 continue;
             }
             else if(S3.isEmpty()){
                S3.push(S2.pop());
              }
              else if(S2.peek()>S3.peek()){
                      S2.push(S3.pop());
              } 
              else{
                S3.push(S2.pop());
              }

          }
          else if(i%3==1){ //movement of source and destination.
            if(S3.isEmpty()&&S1.isEmpty()){
                continue;
            }
              else if(S3.isEmpty()){
                S3.push(S1.pop());
              }
              else if(S1.peek()>S3.peek()){
                      S1.push(S3.pop());
              } 
              else{
                S3.push(S1.pop());
              }          
 
          }
          else if(i%3==2){ //movement of source and auxilairy.
              if(S1.isEmpty()&&S2.isEmpty()){
                continue;
              }
              else if(S2.isEmpty()){
                S2.push(S1.pop());
              }
              else if(S1.isEmpty()){
                S1.push(S2.pop());
              }
              else if(S1.peek()>S2.peek()){
                      S1.push(S2.pop());
              } 
              else{
                S2.push(S1.pop());
              }          
          }
        
        }
          }      

    public static void main(String[] args) {
        Stack<Integer> S1=new Stack<>();//Source pole
        S1.push(3);
        S1.push(2);
        S1.push(1);
        System.out.println("Initial sorce pole disks");
        System.out.println(S1);
        Stack<Integer> S3=new Stack<>();//Destination pole
        Work(S1,S3);
        System.out.println(S3);
        
         
    }
}