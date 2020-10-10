import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

// 디스크컨트롤러
// https://programmers.co.kr/learn/courses/30/lessons/42627

class Disk implements Comparable<Disk>{
    private int receipt ;
    private int done;

    public Disk(int receipt, int done){
        this.receipt = receipt;
        this.done = done;
    }

    public int getReceipt(){
        return this.receipt;
    }

    public int getDone(){
        return this.done;
    }

    @Override
    public int compareTo(Disk d) {
        if(this.done == d.done) {
            return this.receipt - d.receipt;
        } else {
            return this.done - d.done;
        }
    }
}


public class Main {

    public static void main(String[] args) throws IOException {

        //System.out.println(solution(new int[][]{{0, 1}, {100, 1}}));
        //System.out.println(solution(new int[][]{{0, 9}, {1, 4}, {1, 3}, {1, 2}}));
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][]{{0, 3}, {4, 3}, {8, 3}}));
        System.out.println(solution(new int[][]{{0, 5}, {6, 1}, {6, 2}}));
        System.out.println(solution(new int[][]{{0, 5}, {6, 2}, {6, 1}}));
        System.out.println(solution(new int[][]{{0, 5}, {2, 2}, {5, 3}}));
        System.out.println(solution(new int[][]{{0, 5}, {2, 2}, {4, 2}}));
        System.out.println(solution(new int[][]{{0, 10}, {4, 10}, {5, 11}, {15, 2}}));
        System.out.println(solution(new int[][]{{0, 10}, {2, 10}, {25, 10}, {25, 2}}));
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {500, 6}}));
    }

    public static int solution(int[][] jobs) {
        int currentTime = 0;
        int totalJobTime = 0;
        int len = jobs.length;
        LinkedList<Disk> q = new LinkedList<>();
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int idx = 0;
        while(idx < len || !q.isEmpty()){
            for(int i = idx; i < len; i++){
                if(jobs[i][0] <= currentTime) {
                    q.add(new Disk(jobs[i][0], jobs[i][1]));
                    Collections.sort(q);
                    idx++;
                }
            }
            if(q.isEmpty()){
                currentTime = jobs[idx][0];
            }else{
                Disk d = q.poll();
                currentTime += d.getDone();
                totalJobTime += (currentTime - d.getReceipt());
            }
        }
        return totalJobTime/len;
    }
}

/*
테스트 1 〉	통과 (21.49ms, 53.3MB)
테스트 2 〉	통과 (16.17ms, 54MB)
테스트 3 〉	통과 (14.90ms, 52.8MB)
테스트 4 〉	통과 (11.97ms, 53.3MB)
테스트 5 〉	통과 (19.14ms, 54.1MB)
테스트 6 〉	통과 (1.29ms, 52.5MB)
테스트 7 〉	통과 (11.09ms, 53.2MB)
테스트 8 〉	통과 (8.27ms, 52.5MB)
테스트 9 〉	통과 (3.61ms, 53MB)
테스트 10 〉	통과 (20.31ms, 53.8MB)
테스트 11 〉	통과 (1.12ms, 52.4MB)
테스트 12 〉	통과 (1.12ms, 51.8MB)
테스트 13 〉	통과 (1.17ms, 53MB)
테스트 14 〉	통과 (1.09ms, 52.1MB)
테스트 15 〉	통과 (0.99ms, 53.1MB)
테스트 16 〉	통과 (1.26ms, 51.6MB)
테스트 17 〉	통과 (1.05ms, 51.4MB)
테스트 18 〉	통과 (1.05ms, 53.1MB)
테스트 19 〉	통과 (1.09ms, 52.9MB)
테스트 20 〉	통과 (1.16ms, 52MB)
 */
