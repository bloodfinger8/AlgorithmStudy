package HOMEWORK;

import java.util.Scanner;

public class P14889 {
        /* https://www.acmicpc.net/problem/14889
입력 예시
6
0 1 2 3 4 5
1 0 2 3 4 5
1 2 0 3 4 5
1 2 3 0 4 5
1 2 3 4 0 5
1 2 3 4 5 0
         */

        static int n = 0;
        static int [][] table;
        static int [] team1;
        static int [] team2;
        static int [] pick;
        static int result = 0;

        static void dfs(int cur , int pick_count) {
                if(pick_count == (n/2) ){
                        update();
                        return;
                }

                for(int i= cur; i < n; ++i) {
                        pick[i] = 1; //체크
                        dfs(i+1,pick_count+1);
                        pick[i] = 0;
                }
        }

        //분리된 팀의 능력치를 계산후 최솟값을 갱신
        static void update() {
                System.out.println("update 함수 진입");
                int team1_size = 0;
                int team2_size = 0;

                //팀 분류
                for (int i = 0; i < n; i++) {
                        if(pick[i] == 0 ){
                                team1[team1_size++] = i;
                        }else {
                                team2[team2_size++] = i;
                        }
                }

                int sum_1 = 0;
                int sum_2 = 0;
                for (int i = 0; i < n/2; i++) {
                        for (int j = i+1; j < n/2; j++) {
                                sum_1 += table[team1[i]][team1[j]] + table[team1[j]][team1[i]];
                                sum_2 += table[team2[i]][team2[j]] + table[team2[j]][team2[i]];
                        }

                }
                System.out.println(sum_1 + " / " + sum_2);

                if(result > Math.abs(sum_1 - sum_2)) {
                        result = Math.abs(sum_1 - sum_2);
                }

        }

        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
                table = new int[n][n];
                team1 = new int[n/2];
                team2 = new int[n/2];
                pick = new int[n];
                result = n;

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                table[i][j]=scan.nextInt();
                        }
                }

                dfs(0,0);
                System.out.println("result : " + result);

        }

}
