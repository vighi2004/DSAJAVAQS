//counting unique substrings.Time best caseO(n^2) and worst case O(n^3).
package Tries;
public class CountSubStr {
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
    public static int subStr(node root){
        node curr=root;
        int count=0;
        if(curr==null){
            return 0;
        }
        for(int i=0;i<26;i++){
           if(curr.children[i]!=null){
             count+=subStr(curr.children[i]);
            }
       }
       return count+1;
    }
    public static void main(String[] args) {
        String str="ababa";
        for(int i=0;i<str.length();i++){
            insert(str.substring(i));
        }
        System.out.println("Unique substrings are: "+subStr(root));
        
    }
    
}
