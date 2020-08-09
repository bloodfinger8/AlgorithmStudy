package 리스트.n진수게임.장지수;

public class Solution {
    // 진법, 숫자, 인원, 튜브 순서
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
    }
    public static String solution(int n, int t, int m, int p) {
        String answer;
        StringBuilder answer2 = new StringBuilder();
        StringBuilder convertTotal = new StringBuilder();

        for(int i=0 ; i<=t ; i++) {
            // 0부터 t까지 진법으로 변환한 문자를 convertTotal에 더한다.
            convertTotal.append(convertStringByN(n, i));
        }
        answer = convertTotal.toString();
        for(int i = p-1 ; i<answer.length() ; i += m) {
            answer2.append(answer.charAt(i));
            if(answer2.length() == 4) break;
        }
        return answer2.toString();
    }

    public static String convertStringByN(int n, int t) {
        int result = 0;
        int 자릿수 = 1;
        while(t > 0) {
            int mod = t % n;
            t /= n;
            result += mod * 자릿수;
            자릿수 *= 10;
        }
        return result + "";
    }
}

