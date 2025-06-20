//grouping all anargams.time-O(N*L)
package Tries;
import java.util.*;
public class GroupAnargams {
    static class node{
        node children[]=new node[26];
        boolean endOfWord;
        ArrayList<String> words;

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
        int freq[]=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }
        node curr=root;
        for(int i=0;i<26;i++){
            int f=freq[i];
            int idx=Math.min(f,9);
            if(curr.children[idx]==null){
                curr.children[idx]=new node();
            }
            if(i==word.length()-1){
                 curr.children[idx].endOfWord=true;
            }
            curr=curr.children[idx];
        }
        curr.words.add(word);//leaf node
    }
    public static void group(node root,ArrayList<List<String>> result){
        node curr=root;
        if(curr==null){
            return;
        }
        if(!curr.words.isEmpty()){
            result.add(new ArrayList<>(curr.words));
        }
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null){
            group(curr.children[i], result);
        }}
    }
    public static void main(String[] args) {
        String words[]={"eat","bat","ate","tan","nat","tea"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        ArrayList<List<String>> result=new ArrayList<>();
        group(root,result);

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }
}
