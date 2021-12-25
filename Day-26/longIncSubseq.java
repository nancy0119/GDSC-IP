// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-official/ojquestion
import java.io.*;
import java.util.*;

public class longIncSubseq {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int [n];
        for(int i = 0; i < n; i++)arr[i] = s.nextInt();
        
        // Sir method
        int dp[] = new int[n];
        int omax = 0;
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] <= arr[i])val = Math.max(val, dp[prev]);
            }
            dp[i] = val + 1;
            omax = Math.max(omax, dp[i]);
        }
        System.out.println(omax);
        
        // My Mthd
        // Integer dp[][] = new Integer [n][n];
        // for(Integer [] row : dp)Arrays.fill(row, Integer.MAX_VALUE);
        // // fill first col
        // dp[0][0] = arr[0];
        // for(int i = 1; i < n; i++)dp[i][0] = Math.min(dp[i - 1][0], arr[i]);
        // // fill rest dp
        // for(int c = 1; c < n; c++){
        //     for(int r = c; r < n; r++){
        //         int val = dp[r - 1][c];
        //         if(dp[r - 1][c - 1] != Integer.MAX_VALUE && dp[r - 1][c - 1] < arr[r]){
        //             if(val != Integer.MAX_VALUE) val = Math.min(val, arr[r]);
        //             else val = arr[r];
        //         }
        //         dp[r][c] = val;
        //     }
        // }
        
        // int ans = 0;
        // for(int i = 0; i < n; i++){
        //     if(dp[n - 1][i] == Integer.MAX_VALUE)break;
        //     ans = i + 1;
        // }
        // System.out.println(ans);
        }

}