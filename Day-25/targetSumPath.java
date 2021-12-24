// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/print-all-paths-with-target-sum-subset-official/ojquestion

import java.io.*;
import java.util.*;

public class targetSumPath {

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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        
        // fill dp
        boolean dp[][] = new boolean[n + 1][tar + 1];
        // first col
        for(int i = 0; i <= n; i++)dp[i][0] = true;
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= tar; c++){
                boolean exclude = dp[r - 1][c];
                boolean include = false;
                if(c - arr[r - 1] >= 0 && dp[r - 1][c - arr[r - 1]])include= true;
                dp[r][c] = exclude || include;
            }
        }
        System.out.println(dp[n][tar]);
        
        // print path
        if(dp[n][tar]){
            ArrayDeque<Pair>queue = new ArrayDeque<>();
            queue.add(new Pair(n, tar, ""));
            while(queue.size() > 0){
                Pair p = queue.removeFirst();
                // condition is imp
                if(p.r == 0 || p.c == 0)System.out.println(p.psf);
                else{
                    if(p.c - arr[p.r - 1] >= 0 && dp[p.r - 1][p.c - arr[p.r - 1]])
                    queue.add(new Pair(p.r - 1, p.c - arr[p.r - 1], (p.r - 1) + " " + p.psf));
                    if(dp[p.r - 1][p.c])queue.add(new Pair(p.r - 1, p.c, p.psf));
                }
            }
        }
    }
}