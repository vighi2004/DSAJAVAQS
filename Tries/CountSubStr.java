//counting unique substrings
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
    public static int count=1;//empty string also counted
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
    public static void subStr(String word){
        if(word.length()==0){
            return;
        }
        for(int i=1;i<=word.length();i++){
            if(!search(word.substring(0,i))){
                 insert(word.substring(0,i));
                 count++;
            }
        }
        subStr(word.substring(1));
    }
    public static void main(String[] args) {
        String str="ababa";
        subStr(str);
        System.out.println("Unique substrings are: "+count);
        
    }
    
}
