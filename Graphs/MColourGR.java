//return true or false hether the graph is m-colourable or not.
package Graphs;
import java.util.*;
class MColourGR
{
    static class edge{
        int src;
        int dest;
        int color;
        public edge(int src,int dest){
            this.src=src;
            this.color=-1;
            this.dest=dest;
        }
    }
  public static boolean isColor(ArrayList<edge>[] graph,int m){
    boolean visit[] = new boolean[graph.length];
    for(int i = 0; i < graph.length; i++){
        if(!visit[i]){
            if(!dfs(graph, i, m, visit)){
                return false;
            }
        }
    }
    return true;
}

    public static boolean dfs(ArrayList<edge>[] graph, int curr, int m, boolean[] visit) {
    visit[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
        edge e = graph[curr].get(i);
        if (e.color == -1) {
            boolean[] pastcolor = new boolean[m];
            for (int j = 0; j < graph[curr].size(); j++) {
                edge e1 = graph[curr].get(j);
                if (e1.color != -1) {
                    pastcolor[e1.color] = true;
                }
            }
            int assignC = -1;
            for (int c = 0; c < m; c++) {
                if (!pastcolor[c]) {
                    assignC = c;
                    break;
                }
            }
            if (assignC == -1) {
                return false;
            }
            e.color = assignC;
        }
        if (!visit[e.dest]) {
            if (!dfs(graph, e.dest, m, visit)) {
                return false;
            }
        }
    }
    return true;
}

	public static void main (String[] args) 
	{
		int m=3;
		int v=4;
		int edges[][]={{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
		ArrayList<edge>[] graph=new ArrayList[v];
		for(int i=0;i<v;i++){
		    graph[i]=new ArrayList<>();
		}
		for(int i=0;i<edges.length;i++){
		    int src=edges[i][0];
		    int dest=edges[i][1];
		    graph[src].add(new edge(src,dest));
		    graph[dest].add(new edge(dest,src));//for undirected
		}
		System.out.println("is colourable: "+isColor(graph,m));

	}
}
