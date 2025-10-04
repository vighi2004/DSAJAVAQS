//printing string from contach array with seraching with string s prefix each one.
package Tries;
import java.util.*;
public class PhoneDictionary {
    static class node{
        node children[]=new node[26];
        boolean endOfWord;
        List<String> words;

        public node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
            words=new ArrayList<>();
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
             curr.children[idx].words.add(word);
            curr=curr.children[idx];
        }
    }
    public static void lookup(String prefix){
         node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                System.out.println("0");
                return;
            }
            curr=curr.children[idx];
        }
         for(int j=0;j<curr.words.size();j++){
                    System.out.print(curr.words.get(j)+" ");
                }
                System.out.println();

    }
    public static void main(String[] args) {
     String contact[]={"geeikistest","geeksforgeeks","geeksfortest"};
     String s= "geeips";
     for(int i=0;i<contact.length;i++){
        insert(contact[i]);
     }  
     String ans="";
     for(int i=0;i<s.length();i++){
        ans=ans+s.charAt(i);
        lookup(ans);
     } 
    }
}
