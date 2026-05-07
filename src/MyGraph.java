import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {
    private int V, E;
    LinkedList<Character> adj[];

    MyGraph(int nodes){
        V = nodes;
        this.adj = new LinkedList[nodes];

        for (int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }
    public void addEdge(char u, char v){
        adj[u - 65].add(v);
        adj[v - 65].add(u);
    }

    public void printGraph(){
        for (int v = 0; v < V; v++){
            System.out.print("AdjList[" + (char) (v + 65) + "]: ");
            for (int w = 0; w < adj[v].size(); w++){
                System.out.print(adj[v].get(w) + " ");
            }
            System.out.println();
        }
    }
    public void dfs(){
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++){
            if (!visited[v]){
                visitVertex(v, visited);
            }
        }
        System.out.println();
    }
    public void visitVertex(int v, boolean[] visited){
        visited[v] = true;
        System.out.print((char) (v + 65) + " ");
        for (int w = 0; w < adj[v].size(); w++){
            if (!visited[adj[v].get(w) - 65]){
                visitVertex(adj[v].get(w) - 65, visited);
            }
        }
    }
    public void bfs(char start){
        boolean[] visited = new boolean[V];
        visited[start - 65] = true;
        Queue<Character> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print((char) (u) + " ");
            for (int w = 0; w < adj[u - 65].size(); w++){
                if (!visited[adj[u - 65].get(w) - 65]){
                    visited[adj[u - 65].get(w) - 65] = true;
                    q.add((char) (adj[u - 65].get(w)));
                }
            }
        }
    }
}
