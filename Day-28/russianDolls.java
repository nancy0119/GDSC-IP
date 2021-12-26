// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion

import java.io.*;
import java.util.*;

public class russianDolls {
    public static class envelope implements Comparable<envelope>{
        int w;
        int h;
        envelope(int w, int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo(envelope o){
            if(this.w != o.w)return this.w - o.w;
            else return this.h - o.h;
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        envelope arr[] = new envelope[n];
        for(int i = 0; i < n; i++){
            String [] st = s.nextLine().split(" ");
            int w = Integer.parseInt(st[0]);
            int h = Integer.parseInt(st[1]);
            arr[i] = new envelope(w, h);
        }
        Arrays.sort(arr);
        int dp[] = new int[n];
        int omax = 0;
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int prev = 0; prev < i; prev++){
                if(arr[i].w > arr[prev].w && arr[i].h > arr[prev].h && dp[prev] > val)
                val = dp[prev];
            }
            dp[i] = val + 1;
            omax = Math.max(omax, dp[i]);
        }
        System.out.println(omax);
    }

}