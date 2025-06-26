//finding strongly connected components using Kosaraju algorithm(reverse DFS),time-O(V+E).
package Graphs;
import java.util.*;
public class StrongConnectComponent {
    static class edge{
        int src;
        int dest;
        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void topologicalSort(ArrayList<edge>[] graph,int V,Stack <Integer> s,boolean visitArr[],int curr){
        visitArr[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visitArr[e.dest]){
                topologicalSort(graph, V, s, visitArr, e.dest);
            }
        }
        s.push(curr);
    }
    public static void kosarajuAlgo(ArrayList<edge>[] graph,int V){
        //step 1
        Stack <Integer> s=new Stack<>();
        boolean visitArr[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visitArr[i]){
            topologicalSort(graph,V,s,visitArr,i);
        }}
        //step 2
        transpose(graph,V,s);

    }
    public static void transpose(ArrayList<edge>[] graph,int V,Stack <Integer> s){
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] trans=new ArrayList[V];
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            trans[i]=new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                edge e=graph[i].get(j);
                trans[e.dest].add(new edge(e.dest, e.src));
            }
        }
        //step3
       while (!s.isEmpty()) {
           int curr = s.pop();
            if(!vis[curr]) {
            System.out.print("-> ");    
           dfsTranspose(trans, curr, vis);
           System.out.println();
    }
   }
    }
   public static void dfsTranspose(ArrayList<edge>[] trans, int curr, boolean[] vis) {
    vis[curr] = true;
    System.out.print(curr + " ");
    for (int i = 0; i < trans[curr].size(); i++) {
        edge e = trans[curr].get(i);
        if (!vis[e.dest]) {
            dfsTranspose(trans, e.dest, vis);
        }
    }
}
    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        //0 vertex
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        //1 vertex
        graph[1].add(new edge(1, 0));
    
        //2 vertex
        graph[2].add(new edge(2, 1));

        //3 vertex
        graph[3].add(new edge(3, 4));
        System.out.println("Strong connect components are:- ");
        kosarajuAlgo(graph,V);
        
        
    }
    
}
