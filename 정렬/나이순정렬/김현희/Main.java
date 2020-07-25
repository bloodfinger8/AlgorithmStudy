import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] list = new String[n][2];
        for(int i=0;i<n;i++){
            String[] line = br.readLine().split(" ");
            list[i][0] = line[0];
            list[i][1] = line[1];
        }
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String[] strings : list) sb.append(strings[0] + " " + strings[1]+"\n");
        System.out.print(sb);
    }
}
