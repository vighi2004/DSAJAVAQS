//word ladder transformation of one word to anaother.
package Graphs;
import java.util.*;
public class WordLadder {
    static HashSet<String> dict = new HashSet<>();
    static HashMap<String, List<String>> graph = new HashMap<>();

    public static void buildGraph() {
    for (String word : dict) { // for each word in dictionary
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                sb.setCharAt(i, ch);
                String newWord = sb.toString();

                if (dict.contains(newWord) && !newWord.equals(word)) {
                    graph.get(word).add(newWord);
                }
            }
        }
    }
}
public static int bfs(String start,String end){
    Queue<String> q=new LinkedList<>();
    HashMap<String,Integer> hm=new HashMap<>();//distance
    q.add(start);
    hm.put(start,0);
    while(!q.isEmpty()){
        String word=q.poll();
         if (word.equals(end)) {
            return hm.get(word)+1; // shortest transformation length
        }
        for (String nei : graph.get(word)) {
            if (!hm.containsKey(nei)) { // not visited yet
                hm.put(nei, hm.get(word) + 1);
                q.add(nei);
            }
        }
    }
     return -1;
} 
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        // Step 1: store words in HashSet
        for (String w : wordList) {
            dict.add(w);
        }
        dict.add(start);

        // Step 2: prepare graph structure
        for (String w : dict) {
            graph.put(w, new ArrayList<>());
        }
        buildGraph();
        System.out.println(" Transform length is: "+bfs(start, end));
    }
}