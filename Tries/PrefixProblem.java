//finding all unique preifx of list of words.Time-O(L) longest word.
package Tries;
public class PrefixProblem{
     static class node{
            node children[]=new node[26];
            boolean endOfWord;
            int count;
            
            public node(){
                for(int i=0;i<26;i++){
                    children[i]=null;
                }
                endOfWord=false;
                count=0;
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
                curr.children[idx].count++;
                curr=curr.children[idx];
            }
        }
        public static String findPrefix(String word){
              node curr=root;
              String str="";
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(curr.children[idx]!=null&&curr.children[idx].count==1){
                    str=str+word.charAt(i);
                    break;
                }
                str=str+word.charAt(i);
                curr=curr.children[idx];
            }
            return str;
        }
    public static void main(String[] args) {
        String words[]={"zebra","dog","duck","dove"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        for(int i=0;i<words.length;i++){
            System.out.print(" "+findPrefix(words[i]));
        }
       
        
    }
}