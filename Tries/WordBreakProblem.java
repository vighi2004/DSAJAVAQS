//fnding weather given string can be break.
package Tries;
public class WordBreakProblem {
    static class node{
        node children[]=new node[26];
        boolean endOfWord;
        public node(){
            for(int i=0;i<25;i++){
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
    public static boolean wordBreak(String word){
        if(word.length()==0){
            return true;
        }
        for(int i=1;i<=word.length();i++){//as in substring last index is exclusive.
            if(search(word.substring(0, i))&& wordBreak(word.substring(i))){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        String words[]={"i","like","sam","samsung","mobile","ice"};
        String str="ilikesamsung";
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(wordBreak(str));

    }
    
}
