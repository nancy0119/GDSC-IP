// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/catalan-number-official/ojquestion

import java.io.*;
import java.util.*;

public class catalanNo{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int dp[] = new int[n + 1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++){
        for(int j = 0; j < i; j++){
            dp[i] += dp[j] * dp[i - j - 1];
        }
    }
    System.out.println(dp[n]);
 }
}