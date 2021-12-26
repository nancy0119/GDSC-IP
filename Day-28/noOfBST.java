// Link - pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-bst-official/ojquestion

import java.io.*;
import java.util.*;

public class noOfBST{

public static void main(String[] args) throws Exception {
    // write your code here
    // same code as of prev - catalan
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