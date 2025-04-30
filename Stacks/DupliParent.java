//checking if there is Duplicate valid parenethesisi or not.
import java.util.*;
public class DupliParent {
    public static  Boolean CheckDupli(Stack <Character> S,String str){
       for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                int count=0;
                while(!S.isEmpty()&&S.peek()!='('){
                    S.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                else{
                    S.pop();
                }
            }
            else{
                S.push(ch);
            }
       }
       return false;

    }
    public static void main(String[] args) {
        Stack <Character> S=new Stack<>();
        String str="((a+b)+(c+d))";
        System.out.println(CheckDupli(S,str));
    }
}
