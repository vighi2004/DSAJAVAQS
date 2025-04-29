// Longest Valid Parenthesis Substring

import java.util.Stack;

public class ValidParentCount {
    public static int getL(String str,Stack <Character> S){
     int count=0;   
     for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='('){
            S.add(str.charAt(i));
        }
        else{
            if(!S.isEmpty()&&S.peek()=='('&&str.charAt(i)==')'){
                   count=count+2;
                   S.pop();
            }
        }
     }
     return count;

    }
    public static void main(String[] args) {
        String str="(((()";
        Stack <Character> S=new Stack<>();
        System.out.println(getL(str,S));
    }
}
