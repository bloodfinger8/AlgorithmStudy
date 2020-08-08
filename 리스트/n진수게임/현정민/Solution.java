public class Solution {
    public static void main(String[] args) {
        System.out.println("-----Start-----");
        System.out.println(solution(2,4,2,1));
        System.out.println(solution(16,16,2,1));
        System.out.println(solution(16,16,2,2));
        System.out.println("-----End-----");
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String numberList = "";
        //LinkedList<String> list = new LinkedList<String>();

        for (int i = 0; i <=(t*m); i++ ){
            String temp = transNumber(n, i);
            numberList += temp;
        }

        p = p % m;
        for (int i = 1; i <= numberList.length(); i++ ){
            if(i%m == p){
                answer += numberList.charAt(i-1);
            }
        }

        answer = answer.substring(0,t);

        return answer;
    }

    public static String transNumber(int n, int number){
        String temp = "";

        int q = 0;
        int r = 0;
        char rest;
        do{
            r = number % n;
            q = number / n;
            if(r < 10){
                temp = r + temp;
            }else{
                rest = (char)(r%10 + 'A');
                temp = rest + temp;
            }
            number = q;
        }while(number > 0);

        return temp;
    }

    /*
테스트 1 〉	통과 (51.52ms, 47.6MB)
테스트 2 〉	통과 (50.97ms, 48MB)
테스트 3 〉	통과 (47.40ms, 46.9MB)
테스트 4 〉	통과 (49.29ms, 47.3MB)
테스트 5 〉	통과 (71.58ms, 48.2MB)
테스트 6 〉	통과 (62.91ms, 48.4MB)
테스트 7 〉	통과 (62.94ms, 48.4MB)
테스트 8 〉	통과 (61.41ms, 48.1MB)
테스트 9 〉	통과 (53.82ms, 47.9MB)
테스트 10 〉	통과 (57.04ms, 47.4MB)
테스트 11 〉	통과 (54.21ms, 47.7MB)
테스트 12 〉	통과 (55.78ms, 47.6MB)
테스트 13 〉	통과 (60.89ms, 47.4MB)
테스트 14 〉	통과 (4640.56ms, 353MB)
테스트 15 〉	통과 (4678.78ms, 353MB)
테스트 16 〉	통과 (4690.09ms, 353MB)
테스트 17 〉	통과 (94.34ms, 73.4MB)
테스트 18 〉	통과 (100.55ms, 68.2MB)
테스트 19 〉	통과 (66.76ms, 51.9MB)
테스트 20 〉	통과 (96.66ms, 68.2MB)
테스트 21 〉	통과 (455.71ms, 348MB)
테스트 22 〉	통과 (208.25ms, 160MB)
테스트 23 〉	통과 (617.73ms, 348MB)
테스트 24 〉	통과 (2809.24ms, 352MB)
테스트 25 〉	통과 (3449.76ms, 498MB)
테스트 26 〉	통과 (202.26ms, 157MB)
     */

}
