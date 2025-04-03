//optimised approach to calculate Max Area of histogram using Stack O(n).

import java.util.Stack;

public class MaxAreaHistoOPT {
    public static void maxArea(int arr[]){
        int maxarea=0;
        int NSR[]=new int[arr.length];
        int NSL[]=new int[arr.length];
        //next smaller Right
        Stack <Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                NSR[i]=arr.length;
            }
            else{
                NSR[i]=s.peek();

            }
            s.push(i);
        }
        
        //next smaller left
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                NSL[i]=-1;
            }
            else{
                NSL[i]=s.peek();

            }
            s.push(i);
        }
        //width=j-i-1=NSR[i]-NSL[i]-1
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=NSR[i]-NSL[i]-1;
            int area=height*width;
            maxarea=Math.max(maxarea,area);
        }
        System.out.println("Max Area is: "+maxarea);
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
         maxArea(arr);

        
    }
}
