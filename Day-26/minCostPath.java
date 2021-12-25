// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/minimum-cost-path-re-official/ojquestion
import java.io.*;
import java.util.*;

public class minCostPath {

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
    dp[n - 1][m - 1] = arr[n - 1][m - 1];
    // last row
    for(int i = m - 2; i >= 0; i--)dp[n - 1][i] = dp[n - 1][i + 1] + arr[n - 1][i];
    // last col
    for(int i = n - 2; i >= 0; i--)dp[i][m - 1] = dp[i + 1][m - 1] + arr[i][m - 1];
    // rest dp
    for(int i = n - 2; i >= 0; i--){
        for(int j = m - 2; j >= 0; j--){
            dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
        }
    }
    System.out.println(dp[0][0]);
    // print path
    ArrayDeque <Pair> queue = new ArrayDeque<>();
    queue.add(new Pair("", 0, 0));
    while(queue.size() > 0){
        // System.out.println(queue);
        Pair p = queue.removeFirst();
        if(p.r == n - 1 && p.c == m - 1){
            System.out.println(p.psf);
        }
        else{
            if(p.r + 1 < n && p.c + 1 < m){
                if(dp[p.r + 1][p.c] <= dp[p.r][p.c + 1])queue.add(new Pair(p.psf + "V", p.r + 1, p.c));
                if(dp[p.r + 1][p.c] >= dp[p.r][p.c + 1])queue.add(new Pair(p.psf + "H", p.r, p.c + 1));
            }
            else if(p.r + 1 < n)queue.add(new Pair(p.psf + "V", p.r + 1, p.c));
            else queue.add(new Pair(p.psf + "H", p.r, p.c + 1));
        }
    }
   }

}