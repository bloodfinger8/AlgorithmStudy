import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/*
https://www.acmicpc.net/problem/1260
메모리 : 33690KB
시간 : 520 ms
 */
class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        Collections.sort(adj[v]);
        Collections.sort(adj[w]);
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
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

    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print((s+1) + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] graphInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Graph g = new Graph(graphInfo[0]);

        for(int i = 0; i< graphInfo[1]; i++){
            int[] edgeNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            g.addEdge(edgeNum[0] -1 , edgeNum[1] -1);
        }

        //System.out.print("DFS => ");
        g.DFS(graphInfo[2] - 1);
        System.out.println();
        //System.out.print("BFS => ");
        g.BFS(graphInfo[2] - 1);

    }


}
