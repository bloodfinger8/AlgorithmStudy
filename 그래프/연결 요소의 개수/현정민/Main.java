import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Graph g = new Graph(N);
        int answer = 0;
        for(int i = 0; i < M; i++){
            g.addEdge(sc.nextInt() - 1, sc.nextInt() -1 );
        }

        for(int i = 0; i < N; i++){
            if(!g.getVisited(i)) {
                g.DFS(i);
                answer++;
                //System.out.println("----------");
            }
        }

        System.out.println(answer);
    }
}

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    boolean visited[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public boolean getVisited(int v){
        return visited[v];
    }

    public void DFS(int v) {
        DFS(v, visited);
    }

    private void DFS(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print((v+1) + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

}