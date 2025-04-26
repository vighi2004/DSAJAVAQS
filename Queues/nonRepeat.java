//Non-repeating Letter in stream of characters.

import java.util.*;
public class nonRepeat {
        public static void find(Queue <Character> Q,Queue <Character> result,String str){
            int freq[]=new int[26];
            for(int i=0;i<str.length();i++){
                Q.add(str.charAt(i));
                freq[str.charAt(i)-'a']++;
                while(!Q.isEmpty() && freq[Q.peek()-'a'] > 1){
                    Q.remove();
                }
                if(Q.isEmpty()){
                    result.add('0');
                }
                else{
                    result.add(Q.peek());
                }
            }
        }

        public static void main(String[] args) {
        Queue <Character> Q=new LinkedList<>();
        Queue<Character> result=new LinkedList<>();
        String str="aabccxb";
        find(Q,result,str); 
        System.out.println(result);   
        }
}
