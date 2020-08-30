import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Object;

class Graph {
    private int V; // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트
    boolean visited[];
    private int count;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
        visited = new boolean[v];
        for (int i=0; i<v; ++i)
            visited[i] = false;
        count = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    int getCount() { return count; }

    void BFS(int s) {
        count = 0;
        for (int i=0; i<V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            count++;
            System.out.print((s+1) + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            System.out.println();
        }
        count--;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int[] airplane = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Graph g = new Graph(airplane[0]);
            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            for(int j = 0 ; j < airplane[1]; j++){
                int[] path = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                g.addEdge(path[0] - 1 ,path[1] - 1);
            }
            //System.out.println("========================================");
            g.BFS(0);
            System.out.println(g.getCount());
        }
    }
}
