package com.practice;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //기존 value
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }
        //찾아야할 value
        int p = Integer.parseInt(br.readLine());
        int[] q = new int[p];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<p;i++){
            q[i]=Integer.parseInt(st.nextToken());
        }
        //1. m 정렬
        Arrays.sort(map);
        for(int i=0;i<p;i++){
            int val = q[i];
            //2. 이진탐색 (m 에 val 있는지 확인)
            int start = 0;
            int end = n-1;
            int middle;
            boolean isOK = false;

            while(start<=end){
                middle = (start+end)/2;
                if(map[middle] == val){
                    isOK = true;
                    break;
                }
                else if(val > map[middle]){
                    start = middle+1;
                }else{
                    end = middle-1;
                }
            }
            System.out.println(isOK?1:0);
        }
    }
}
