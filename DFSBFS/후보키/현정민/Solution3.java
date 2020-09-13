import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.lang.Object;

public class Solution {

    public static void main(String[] args) throws IOException {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "1"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(solution(relation));
    }

    public static int idx = 0;
    public static int count = 0;

    public static int solution(String[][] relation) {
        int answer = 0;
        Map<Integer, LinkedList<String>> powerSet= new HashMap<>();
        int row = relation.length;
        int col = relation[0].length;
        if(row == 1 || col == 1){
            return col;
        }
        powerSet(relation, new boolean[row][col], 0, col, powerSet);
        System.out.println(count);
        int temp = (int) Math.pow((double) 2, (double) col);
        answer = temp - count;
        return answer;
    }


    public static void powerSet(String[][] arr, boolean[][] state, int i, int end, Map<Integer, LinkedList<String>> powerSet) {
        if (i >= end) {
            String[] tempStr = new String[arr.length];
            StringBuffer[] temp = new StringBuffer[arr.length];
            for (int w = 0; w < end; w++) {
                for(int j = 0; j<arr.length; j++){
                    if(temp[j] == null)
                        temp[j] = new StringBuffer();
                    if (state[j][w]) {
                        temp[j] =  temp[j].append(arr[j][w]);
                    }
                }
            }
            LinkedList<String> list = new LinkedList<>();
            for(int j = 0; j<arr.length; j++){
                if(!list.contains(temp[j].toString())){
                    list.add(temp[j].toString());
                }else{
                    count++;
                }
            }
            powerSet.put(idx++, list);
            //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return;
        }
        for(int j = 0; j<arr.length; j++){
            state[j][i] = false;
        }
        powerSet(arr, state, i + 1, end, powerSet);

        for(int j = 0; j<arr.length; j++){
            state[j][i] = true;
        }
        powerSet(arr, state, i + 1, end, powerSet);
    }

    /*public static boolean checkCandidateKey(int col, String[][] relation) {
        int idx = col;
        boolean flag = false;
        for (int i = col; i < relation[0].length ; i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j= 0; j < relation.length; j++) {
                StringBuffer temp = new StringBuffer();
                for (int l = col; l < idx + 1; l++) {
                    temp = temp.append(relation[j][l]);
                }
                System.out.println(temp);
                if (!list.contains(temp.toString())) {
                    list.add(temp.toString());
                } else {
                    flag = true;
                    idx++;
                    break;
                }
            }
            //System.out.println(flag);
            //System.out.println("++++++++++++++++++++++++++++");
            if(!flag)
                return flag;
            else
                flag = false;
        }
        return !flag;
    }*/
   /* public static boolean checkCandidateKey(String[][] relation) {
        Map<Integer, LinkedList<String>> powerSet= new HashMap<>();
        int row = relation.length;
        int col = relation[0].length;
        boolean flag = false;

        powerSet(relation, new boolean[row][col], 0, col, powerSet);
        for(int i = 1; i<powerSet.get(0).size(); i++){
            LinkedList<String> list = new LinkedList<>();
            for(int j = 0; j<relation.length; j++){
                String temp = powerSet.get(j).get(i);
                if(!list.contains(temp)){
                    list.add(temp);
                } else{
                    flag = true;
                    break;
                }
                System.out.print(temp + " / ");
            }
            if(flag)

            System.out.println("---------------------------------------");
        }
        return false;
    }*/

}
