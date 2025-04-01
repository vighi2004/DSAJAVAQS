import java.util.*;
public class validParent {
    public static boolean isValid(String str){
        Stack <Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){ 
                s.push(str.charAt(i));
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek()=='{'&& str.charAt(i)=='}'||s.peek()=='[' && str.charAt(i)==']'||s.peek()=='(' && str.charAt(i)==')'){
                      s.pop();
                }
                else{
                    return false;
                }
        }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        String str="(])";
        if (isValid(str)) {
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
    }
    
}
