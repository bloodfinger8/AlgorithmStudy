import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[][] statArr = new int[N][N];
        for(int i = 0; i<N; i++){
            statArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        TreeMap<Integer, Integer> sumMap = new TreeMap<>();

        int answer = Integer.MAX_VALUE;
        for (int j = 0; (1 << N) > j; ++j) {
            if (Integer.bitCount(j) == (N/2)) {
                boolean[] member = new boolean[N];
                int idx = 0;
                for (int i = 0; i < N; ++i) {
                    if (((1 << i) & j) > 0) {
                        System.out.print(i+ " ");
                        member[i] = true;
                    }
                }
                int gap = addStat(member, statArr, sumMap);
                if(answer > gap)
                    answer = gap;
                System.out.println(gap);
            }
        }

        System.out.println(answer);

    }

    public static int addStat(boolean[] member, int[][] statArr, TreeMap<Integer, Integer> sumMap){
        int len = member.length;
        int[] startTeam = new int[len/2];
        int startIdx = 0;
        int[] linkTeam = new int[len/2];
        int linkIdx = 0;
        for(int i = 0; i<member.length; i++){
            if(member[i])
                startTeam[startIdx++] = i;
            else
                linkTeam[linkIdx++] = i;
        }

        int[] selectMember = new int[2];
        int tempStat1 = 0;
        int tempStat2 = 0;

        System.out.println("******");
        tempStat1 = addTeamStat(selectMember, startTeam, len, statArr);
        tempStat2 = addTeamStat(selectMember, linkTeam, len, statArr);

        System.out.println(tempStat1 + " - " +tempStat2 + " = " + Math.abs(tempStat1 - tempStat2));
        System.out.println();
        System.out.println("******");
        return Math.abs(tempStat1 - tempStat2);
    }

    public static int addTeamStat(int[] selectMember, int[] team, int len, int[][] statArr){
        int tempStat = 0;

        for (int j = 0; (1 << len/2) > j; ++j) {
            if (Integer.bitCount(j) == 2) {
                int idx = 0;
                for (int i = 0; i < len/2; ++i) {
                    if (((1 << i) & j) > 0) {
                        System.out.print(team[i]+ " ");
                        selectMember[idx++] = team[i];
                    }
                }
                tempStat = tempStat + statArr[selectMember[0]][selectMember[1]] + statArr[selectMember[1]][selectMember[0]];
                System.out.println();
                System.out.println(statArr[selectMember[0]][selectMember[1]] + " + " + statArr[selectMember[1]][selectMember[0]] + " = "  + (statArr[selectMember[0]][selectMember[1]] + statArr[selectMember[1]][selectMember[0]]));
            }
        }

        return tempStat;
    }

}
