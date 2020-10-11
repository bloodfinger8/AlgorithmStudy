package REALPRATICE;

import java.util.PriorityQueue;

public class L42626 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int j : scoville) {
            pq.offer(j);
        }

        while(pq.peek() < K) {

            System.out.println("pq.peek() : " + pq.peek());
            System.out.println("pq 정렬전 : " + pq);

            if(pq.size() == 1) return -1;

            int k = pq.poll();
            int k2 = pq.poll();

            int result = k + (k2 * 2);

            pq.offer(result);
            answer++;

            System.out.println("pq 정렬후 : " + pq);
            System.out.println();
        }
        return answer;
    }


    public static void main(String[] args) {
        L42626 l = new L42626();
        l.solution(new int[]{1, 2, 3, 9, 10, 12},13);
    }
}
