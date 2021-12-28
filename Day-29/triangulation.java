// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/number-of-ways-of-triangulation-official/ojquestion
import java.io.*;
import java.util.*;

public class triangulation {

	public static int solution(int n){
		// write your code here
		n -= 2;
		int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}