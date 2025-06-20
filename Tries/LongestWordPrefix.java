//finding word with longest prefix
package Tries;
public class LongestWordPrefix {
    static class node{
        node children[];//26
        boolean endOfWord;

        public node(){
            children=new node[26];
            for(int i=0;i<25;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }
     public static node root=new node();
     public static String str="";
     public static int maxlength=0;
    public static void insert(String word){ //O(L)
        node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
               curr.children[idx]=new node();
            }
            if(i==word.length()-1){
              curr.children[idx].endOfWord=true;
            }
            curr=curr.children[idx];
        }
    }
    public static boolean search(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
               return false;
            }
            if(i==word.length()-1&&curr.children[idx].endOfWord==false){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void longword(node root,StringBuilder temp) {
        if(root==null){
            return;
        }
    for (int i = 0; i <26; i++) {
        if (root.children[i]!=null&&root.children[i].endOfWord==true) {
            char ch=(char)(i+'a');
            temp.append(ch);
            if(temp.length()>str.length()){
                str=temp.toString();
            }
            longword(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1);//backtrack;
        }
    }
}

    public static void main(String[] args) {
        String words[]={"a","banana","ap","appl","app","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
         longword(root, new StringBuilder(""));
        System.out.println("Longest word prefix is: "+str);
        
    }
    
}
