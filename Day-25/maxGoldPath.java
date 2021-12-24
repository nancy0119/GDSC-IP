// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/goldmine-re-official/ojquestion

import java.io.*;
import java.util.*;

public class maxGoldPath {

   private static class Pair {
      String psf;
      int r;
      int c;

      public Pair(String psf, int r, int c) {
         this.psf = psf;
         this.r = r;
         this.c = c;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
    //   fill dp
    int dp[][] = new int [n][m];
    // last col
    for(int i = 0; i < n; i++)dp[i][m - 1] = arr[i][m - 1];
    // rest dp
    for(int c = m - 2; c >= 0; c--){
    for(int r = 0; r < n; r++){
            dp[r][c] = dp[r][c + 1];
            if(r - 1 >= 0 && dp[r - 1][c + 1] > dp[r][c])dp[r][c] = dp[r - 1][c + 1];
            if(r + 1 < n && dp[r + 1][c + 1] > dp[r][c]) dp[r][c] = dp[r + 1][c + 1];
            dp[r][c] += arr[r][c];
            }
    }
    // check for row with max gold
    int ans = 0;
    for(int i = 0; i < n; i++)ans = Math.max(ans, dp[i][0]);
    System.out.println(ans);
    
    // print path
    for(int i = 0; i < n; i++){
        if(dp[i][0] == ans){
            ArrayDeque<Pair> queue  = new ArrayDeque<>();
            queue.add(new Pair("" + i, i, 0));
            while(queue.size() > 0){
                Pair p = queue.removeFirst();
                if(p.c == m - 1){
                    System.out.println(p.psf);
                }
                else{
                    if(p.r - 1 >= 0 && dp[p.r][p.c] - arr[p.r][p.c] == dp[p.r - 1][p.c + 1])
                    queue.add(new Pair(p.psf + " d1", p.r - 1, p.c + 1));
                    if(dp[p.r][p.c] - arr[p.r][p.c] == dp[p.r][p.c + 1])
                    queue.add(new Pair(p.psf + " d2", p.r, p.c + 1));
                    if(p.r + 1 < n && dp[p.r][p.c] - arr[p.r][p.c] == dp[p.r + 1][p.c + 1])
                    queue.add(new Pair(p.psf + " d3", p.r + 1, p.c + 1));
                }
            }
        }
    }
    
   }


}