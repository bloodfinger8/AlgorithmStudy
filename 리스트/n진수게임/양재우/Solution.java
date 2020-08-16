package 리스트;

import java.util.ArrayList;

public class Solution {

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String [] allArr = new String[t*m];

        for (int i = 0; i < t*m; i++) {
            allArr[i] = i+"";
        }


        for (int i = 0; i < allArr.length ; i++) {
            answer += changeNumber(n, allArr[i]);
        }

        String[] tempArr = answer.split("");
        String dap = "";

        for (int i = p-1; i < t*m; i=i+m) {
            dap += tempArr[i];
        }

        return dap;
    }


    static String changeNumber(int n , String realArrParam) {

        int val = Integer.parseInt(realArrParam);
        String ans = "";

        if(val == 0){
            ans = "0";
        }else {
            while (val > 0) {
                ans = (val % n) + ans;
                val = val/n;
                System.out.println("ans : " + ans);
//                if("10".equals(ans)) { 	//문자열 처리
//                    ans = "A";	 //10-> A
//                }else if("11".equals(ans)) {
//                    ans = "B";	 //11-> B
//                } else if("12".equals(ans)) {
//                    ans = "C";	 //12-> C
//                } else if("13".equals(ans)) {
//                    ans = "D"; 	//13-> D
//                } else if("14".equals(ans)) {
//                    ans = "E"; 	//14-> E
//                } else if("15".equals(ans)) {
//                    ans = "F"; 	//15-> F
//                }


            }
        }

        System.out.println(ans);

        return ans;
    }



    public static void main(String[] args) {
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        Solution s= new Solution();
        s.solution(16,16,2,1);

    }
}
