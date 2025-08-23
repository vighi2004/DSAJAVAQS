//Allen dictionary is given.we have to find sorting of letter. 
package Graphs;
import java.util.*;
public class AllenDictSortLettr {
    public static void solve(HashMap <Character,List<Character>> graph,HashMap<Character,Integer>Indegree){
        Queue<Character> q=new LinkedList<>();
        for(Character i:Indegree.keySet()){
            if(Indegree.get(i)==0){
               q.add(i);
            }
        }

        while(!q.isEmpty()){
             Character c=q.remove();
            System.out.print(c+"->");
            for(int i=0;i<graph.get(c).size();i++){
                Character neigh = graph.get(c).get(i);
                int key = Indegree.get(neigh);
                Indegree.put(neigh, key-1);
                if(Indegree.get(neigh)==0){
                    q.add(neigh);
                }
            }
        }      
    }
    public static void main(String[] args) {
        String  words[] ={"baa", "abcd", "abca", "cab", "cad"};
        HashMap <Character,List<Character>> graph=new HashMap<>();
        for(String w : words){
            for(char ch : w.toCharArray()){
                graph.putIfAbsent(ch, new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++){
            String str=words[i];
            String str1=words[i+1];
            for(int j=0;j<str.length()&&j<str1.length();j++){
                if(str.charAt(j)!=str1.charAt(j)){
                    char u=str.charAt(j);
                    char v=str1.charAt(j);
                      graph.get(u).add(v);
                      break;
                }
            }
        }
        HashMap<Character,Integer> Indegree=new HashMap<>();
        for(Character key : graph.keySet()){
           Indegree.put(key, 0); // initialize all nodes
          }

        for(Character u : graph.keySet()){
           for(Character v : graph.get(u)){
              Indegree.put(v, Indegree.get(v) + 1);
           }
        }
        solve(graph,Indegree);
    }
}
