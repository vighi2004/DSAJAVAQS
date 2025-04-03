//printing whether duplicates parenthesis occuring or not in O(N).
import java.util.Stack;
public class DupliParent {
    public static boolean DupliCheck(String str){
        Stack <Character> s=new Stack<>();
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='a'||ch=='b'||ch=='c'||ch=='d'||ch=='('){
                s.push(ch);
        }
        else{
            int count=0;
            while(s.peek()!='('){
                  s.pop();
                  count++;
            }
            if(count<1){
                return true;
            }
            s.pop();
        }
    }
    return false;

    }
   public static void main(String[] args) {
    String str="(a-b)";
    if(DupliCheck(str)){
        System.out.println("TRUE");
    }
    else{
        System.out.println("FALSE");
    }
   } 
}
