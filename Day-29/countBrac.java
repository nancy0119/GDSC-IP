// link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion
import java.io.*;
import java.util.*;

public class countBrac{

public static void main(String[] args) throws Exception {
    // write your code here
    // same code as catalan no
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        for(int j = 0; j <= i - 1; j++){
            dp[i] += dp[j] * dp[i - j - 1];
        }
    }
    System.out.println(dp[n]);
 }

}