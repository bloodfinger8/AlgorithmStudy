import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int max = 0;
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList();
        int distance[] = new int[n + 1];
        boolean canVisit[][] = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < edge.length; i++) {
            canVisit[edge[i][0]][edge[i][1]] = true;
            canVisit[edge[i][1]][edge[i][0]] = true;
        }
        
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            
            for(int i = 2; i <= n; i++) {
                if(distance[i] == 0 && canVisit[idx][i]) {
                    distance[i] = distance[idx] + 1;
                    queue.add(i);
                }
            }
        }
        
        for(int i = 0; i < n + 1; i++) {
            max = Math.max(max, distance[i]);
        }
        
        for(int i = 0; i < n + 1; i++) {
            if(max == distance[i]){
                answer++;
            }
        }
        
        return answer;
    }
}