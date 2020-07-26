import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    final static Stack stk = new Stack();
    //final static Queue<Integer> que = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        int[] arr = {1,1,1,1,1};
        int answer = solution(arr,3);
        System.out.print(answer);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();

        que.offer(numbers[0]); //초기값 넣기
        que.offer(numbers[0]*(-1)); //초기값 넣기
        que = recursion(numbers, 1, que); //배열로 만들 수 있는 모든 경우의 수를 queue에 담는다.

        while(!que.isEmpty()){
            if((int)que.poll() == target) //결과값이 target과 같을 때 answer++
                answer++;
        }
        return answer;
    }

    public static Queue recursion(int[] numbers, int i, Queue que){
        Queue<Integer> tempQue = new LinkedList<Integer>(); //계산 결과를 옮길 임시의 큐
        if(i > (numbers.length-1)) //모든 경우의 수를 끝냈을 때 종료
            return que;
        while(!que.isEmpty()){
            int temp = (int) que.poll();
            //만들 수 있는 경우의 수는 배열의 원소를 더하거나 뺴거나 두개이다.
            tempQue.offer(temp + numbers[i]);
            tempQue.offer(temp + numbers[i]*(-1));
        }
        return recursion(numbers, ++i, tempQue);
    }
    
    /*
    테스트 1 〉	통과 (179.31ms, 107MB)
    테스트 2 〉	통과 (179.36ms, 108MB)
    테스트 3 〉	통과 (2.59ms, 52.4MB)
    테스트 4 〉	통과 (4.44ms, 50.7MB)
    테스트 5 〉	통과 (15.34ms, 54.7MB)
    테스트 6 〉	통과 (2.63ms, 52.4MB)
    테스트 7 〉	통과 (2.70ms, 53MB)
    테스트 8 〉	통과 (5.37ms, 51MB)
    */
}
