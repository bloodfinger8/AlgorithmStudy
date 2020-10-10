import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int curtime = 0;
        int finishCount = 0;
        
        //처리시간 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        //요청시간 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int idx = 0;
        while(finishCount < jobs.length) {
            
            //현재까지 들어온 요청을 큐에 삽입
            while(idx < jobs.length && jobs[idx][0] <= curtime){
                queue.add(jobs[idx++]);
            }
            
            //현재까지 모든 작업 처리했으므로, 다음 작업 요청시간으로 설정
            if(queue.isEmpty()) {
                curtime = jobs[idx][0];
            } else {
                int[] temp = queue.poll();
                answer += temp[1] - temp[0] + curtime;
                curtime += temp[1];
                finishCount++;
            }
        }
        
        return answer / jobs.length;
    }
}
