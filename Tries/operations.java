//all operation on tries.
package Tries;
public class operations {
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
    public static void main(String[] args) {
        String words[]={"the","a","their","there","any"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("therez"));

    } 

}
