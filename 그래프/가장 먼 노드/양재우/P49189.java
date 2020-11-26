package HOMEWORK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P49189 {

    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean [][] arr = new boolean[n+1][n+1];
        int[] dist = new int[n+1];

        for(int i=0; i < edge.length; i++) {
            arr[edge[i][0]][edge[i][1]] = arr[edge[i][1]][edge[i][0]] = true;
        }

        //BFS
        int max = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(1); //1번 부터 시작

        while(!que.isEmpty()) {
            int i = que.poll();

            for(int j=2; j<= n; j++) {
                if(dist[j] == 0 && arr[i][j] ){
                    dist[j] = dist[i] + 1;
                    que.add(j);
                    max = Math.max(max,dist[j]);
                }
            }
        }
        int count = 0;
        for (int d : dist) {
            if( max == d )
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 6},
                       {4, 3},
                       {3, 2},
                       {1, 3},
                       {1, 2},
                       {2, 4},
                       {5, 2}};
        P49189 p = new P49189();

        p.solution(6 , arr);
    }
}
