import java.util.*;

public class Main {
    public static void main(String[] args){

        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        Graph g = new Graph(n);
        for(int i = 0; i < edge.length; i++){
            g.addEdge(edge[i][0] - 1, edge[i][1] - 1);
        }
        g.BFS(0);
        //System.out.println("\n============================================");
        Map<Integer, Integer> nodeDepth = g.getDepth();
        int maxDepth = Collections.max(nodeDepth.values());

        for(int node : nodeDepth.keySet() ){
            //System.out.println( String.format("키 : %s, 값 : %s", depth, nodeDepth.get(depth)) );
            if(nodeDepth.get(node) == maxDepth)
                answer++;
        }

        return answer;
    }
}

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Map<Integer, Integer> nodeDepth = new HashMap<>();

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Map getDepth(){
        return nodeDepth;
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        nodeDepth.put(s, 0);

        while (queue.size() != 0) {
            s = queue.poll();
            //System.out.print((s+1) + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    nodeDepth.put(n, nodeDepth.get(s) + 1);
                    queue.add(n);
                }
            }
        }
    }

}