//finding whether prefix lies in words.
package Tries;
public class StartsWith {
    static class node{
        node children[]=new node[26];
        boolean endOfWord;

        public node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }
    public static node root=new node();
    public static void insert(String word){
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
    public static boolean StartWith(String prefix){
          node curr=root;
          for(int i=0;i<prefix.length();i++){
             int idx=prefix.charAt(i)-'a';
             if(curr.children[idx]==null){
                return false;
             }
             curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
       String words[]={"apple","app","mango","man","woman"};
       for(int i=0;i<words.length;i++){
            insert(words[i]);
       }
       System.out.println(StartWith("mang"));

    }
}
