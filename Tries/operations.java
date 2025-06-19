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
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(root.children[idx]==null){
               root.children[idx]=new node();
            }
            if(i==word.length()-1){
              root.children[idx].endOfWord=true;
            }
            root=root.children[idx];
        }
    }
    public static boolean search(String word){
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(root.children[idx]==null){
               return false;
            }
            if(i==word.length()-1&&root.children[idx].endOfWord==false){
                return false;
            }
            root=root.children[idx];
        }
        return true;

    }
    public static void main(String[] args) {
        String words[]={"the","a","their","there","any"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

    } 

}
