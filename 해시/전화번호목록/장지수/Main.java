package 해시.전화번호목록.장지수;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5052
public class Main {
    public static void main(String[] args) throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        int n = Integer.parseInt(br.readLine());
//
//        for(int i=0 ; i<n ; i++) {
//            int num = Integer.parseInt(br.readLine());
//            String[] tels = new String[num];
//            for(int j=0 ; j<num ; j++) {
//                tels[j] = br.readLine();
//            }
//            System.out.println(check(tels) ? "YES" : "NO");
//        }

        //System.out.println(check(new String[]{"1", "2", "3"}));
        //System.out.println(check(new String[]{"1", "11", "113"}));
        //System.out.println(check(new String[]{"911", "912", "91126"}));
        System.out.println(check(new String[]{"1", "2", "01", "10"}));
    }

    public static boolean check(String[] tels) {
        int minSize = tels[0].length();
        int minIndex = 0;
        for(int i=1 ; i<tels.length ; i++) {
            if(tels[i].length() < minSize) {
                minSize = tels[i].length();
                minIndex = i;
            }
        }

        for(int i=0 ; i<tels.length ; i++) {
            if(i == minIndex) continue;
            if(tels[i].startsWith(tels[minIndex])) {
                return false;
            }
        }
        return true;

    }
}

