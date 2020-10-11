import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        
        while(queue.peek() <= K && queue.size() != 1) {
            int minFood = queue.poll();
            int nextFood = queue.poll();
            
            queue.offer(minFood + (nextFood * 2));
            answer++;
        }
        
        return answer == 0 || queue.peek() < K
            ? -1 
            : answer;
    }
}