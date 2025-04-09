//Evaluating postfix expression using stack.
import java.util.Stack;
public class EvalPostfixExp {
    public static int solve(String[] arr){
        Stack <Integer> s=new Stack<>();
        for(int i=0;i<arr.length;i++){
                if(arr[i].charAt(0)=='+'){
                    int a = s.pop();
                    int b = s.pop();
                    int result=b+a;
                    s.push(result);
                }
                else if(arr[i].charAt(0)=='-'){
                    int a = Integer.parseInt(String.valueOf(s.pop()));
                    int b = Integer.parseInt(String.valueOf(s.pop()));
                    int result=b-a;
                    s.push(result);
                }   
                else if(arr[i].charAt(0)=='*'){
                    int a = Integer.parseInt(String.valueOf(s.pop()));
                    int b = Integer.parseInt(String.valueOf(s.pop()));
                    int result=b*a;
                    s.push(result);
                }
                else if(arr[i].charAt(0)=='/'){
                    int a = Integer.parseInt(String.valueOf(s.pop()));
                    int b = Integer.parseInt(String.valueOf(s.pop()));
                    int result=b/a;
                    s.push(result);
                }
                else{
                     int n =Integer.parseInt(arr[i]);
                    s.push(n);
                }  
            }
        return s.peek();
    }
    public static void main(String[] args) {
        String[] arr={"100","200","+","2","/","5","*","7","+"};
        System.out.println(solve(arr));   
    }
}
