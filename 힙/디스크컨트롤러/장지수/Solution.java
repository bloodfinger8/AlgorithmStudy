package 힙.디스크컨트롤러.장지수;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42627
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0,3}, {1,9}, {2,6}
        }));
        System.out.println(solution(new int[][] {
                {0, 10}, {2,10}, {9,10}, {15,2}
        }));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 요청시점 기준으로 오름차순으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 처리시간 기준으로 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // 요청이 모두 수행될 때까지 반복
        while(count < jobs.length) {
            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }

            // 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
            // (end를 요청의 가장 처음으로 맞춰줌)
            if(pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else { 			// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int)Math.floor(answer / jobs.length);
    }
}

