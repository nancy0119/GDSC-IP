// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/zero-one-knapsack-re-official/ojquestion

import java.io.*;
import java.util.*;

public class zeroOne {
    public static class Pair{
        int r;
        int c;
        String psf;
        public Pair(int r, int c, String psf){
            this.r = r;
            this.c = c;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here
        
        // fill dp
        int dp[][] = new int[n + 1][cap + 1];
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= cap; c++){
                int exclude = dp[r - 1][c];
                int include = 0;
                if(c - wts[r - 1] >= 0)include = dp[r - 1][c - wts[r - 1]] + values[r - 1];
                dp[r][c] = Math.max(include, exclude);
            }
        }
        System.out.println(dp[n][cap]);
        
        // print path
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, cap, ""));
        while(queue.size() > 0){
            Pair p = queue.removeFirst();
            if(p.c == 0 || p.r == 0)System.out.println(p.psf);
            else{
                if(p.c - wts[p.r - 1] >= 0 && dp[p.r][p.c] == dp[p.r - 1][p.c - wts[p.r - 1]] + values[p.r - 1])queue.add(new Pair(p.r - 1, p.c - wts[p.r - 1], (p.r - 1) +" " + p.psf));
                if(dp[p.r][p.c] == dp[p.r - 1][p.c])queue.add(new Pair(p.r - 1, p.c, p.psf));
            }
        }
    }
}