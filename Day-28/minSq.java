// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-squares-official/ojquestion/

import java.io.*;
import java.util.*;

public class minSq {

	public static int solution(int n){
		//write your code here
        int dp[] = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int val = Integer.MAX_VALUE;
            for(int j = 1; (i - (j * j) >= 0); j++){
                if(dp[i - (j * j)] < val)val = dp[i - (j * j)];
            }
            dp[i] = val + 1;
        }
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}


	
}