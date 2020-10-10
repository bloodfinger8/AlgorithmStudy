package HOMEWORK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class L_42627 {


    public int solution(int[][] jobs) {
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        List<Disk> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Disk(jobs[i][0],jobs[i][1]));
        }

        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(list.get(i).getStartPoint() + " / " + list.get(i).getLen());
        }

        int len = 0;
        int sum = 0;
        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                //시작시간이 현재 시간보다 이전이라면 시작 가능
                if (len >= list.get(i).getStartPoint()) {
                    len += list.get(i).getLen();
                    sum += len - list.get(i).getStartPoint();
                    list.remove(i);
                    break;
                }
                //시작시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
                if (i == list.size()-1)
                    len++;
            }
        }

        int answer = (sum/jobs.length);

        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        int [][] jobs = {{1, 3},
                         {1, 9},
                         {2, 6}};
        L_42627 l = new L_42627();
        l.solution(jobs);
    }

}


class Disk implements Comparable<Disk>{
    private int startPoint;
    private int len;

    public Disk(int startPoint, int len) {
        this.startPoint = startPoint;
        this.len = len;
    }
    public int getStartPoint() {
        return startPoint;
    }
    public int getLen() {
        return len;
    }


    @Override
    public int compareTo(Disk target) {
        // 자신의 값이 작으면 -1
        // 자신의 값과 같으면 0
        // 자신보다 값이 크면 1
        if(this.len < target.getLen()) {
            return -1;
        }else if(this.len == target.getLen()) {
            if (this.startPoint < target.getStartPoint()) return -1;
            else return 1;
        }
        return 1;
    }
}
