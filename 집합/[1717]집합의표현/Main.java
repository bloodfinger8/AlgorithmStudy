package 집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int [] parent ;

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]); // 압축
        // return find(parent[u]) // 압축x
    }
    public static void merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[u] = v;
    }

    public static void main(String[] args) throws Exception{
//        7 8
//        0 1 3
//        1 1 7
//        0 7 6
//        1 7 1
//        0 3 7
//        0 4 2
//        0 1 1
//        1 1 1
//        https://www.acmicpc.net/problem/1717
//        메모리 : 69972	 시간 : 1088
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt( s[0] );
        int m = Integer.parseInt( s[1] );

        parent = new int[n+1];

        for (int i=0 ; i<=n ; i++){
            parent[i] = i;
        }

        for (int i =0; i<m; i++){
            String[] s1 = br.readLine().split(" ");
            int div = Integer.parseInt(s1[0]);
            int u = Integer.parseInt(s1[1]);
            int v = Integer.parseInt(s1[2]);

            if(div == 1) {
                if(find(u) == find(v)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else if(div == 0){
                merge(u , v);
            }
        }

    }
}
