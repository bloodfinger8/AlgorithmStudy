import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            q.add(scoville[i]);
        }

        while(q.size() > 1){
            int first = q.poll();
            int second = q.poll();
            q.offer(first + (second * 2));
            answer++;

            if(q.peek() > K)
                return answer;
        }

        return -1;
    }
}
