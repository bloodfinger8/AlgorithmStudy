package 스턕큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1966 {

    /*
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

     */



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt(); // 테스트 갯수

        for(int i=0; i<testCase; i++) {
            int n = scan.nextInt(); //숫자 갯수
            int m = scan.nextInt(); //몇 번째로 인쇄되었는지 궁금한 문서의 위치
            Queue<int[]> que = new LinkedList<>();
            int cnt = 0;

            for (int j=0; j<n; j++){
                int k = scan.nextInt();
                que.add(new int[] {j , k});
            }

            while(!que.isEmpty()) {
                int[] stand = que.peek();
                boolean tt = false;

                for (int[] ch : que){
                    if(stand[1] < ch[1]){
                        tt = true;
                        break;
                    }
                }

                if(tt){
                    que.add(que.poll());
                }else {
                    int[] result = que.poll();
                    cnt++;
                    if(result[0] == m){
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }


}
