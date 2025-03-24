//reversing string.
import java.util.*;
public class RevString {
    public static void main(String[] args) {
        Stack <Character> s=new Stack<>();
        String str="helloworld";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            s.push(c);
        }
        //if you want ans in string than use stringbuilder append all pop data in it than copy to str and print it.
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
        
    }
}
