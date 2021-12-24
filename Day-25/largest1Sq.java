// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/largest-square-sub-matrix-with-all-ones-official/ojquestion
import java.io.*;
import java.util.*;

public class largest1Sq {

	public static int solution(int[][] arr) {
		//write your code here
        int dp[][] = new int [arr.length][arr[0].length];
        int ans = 0;
        // last row
        for(int i = 0; i < arr[0].length; i++){
            if(arr[arr.length - 1][i] == 1)ans = 1;
            dp[arr.length - 1][i] = arr[arr.length - 1][i];
        }
        // last col
        for(int i = 0; i < arr.length; i++){
            if(arr[i][arr[0].length - 1] == 1)ans = 1;
            dp[i][arr[0].length - 1] = arr[i][arr[0].length - 1];
        }
        // rest dp
        for(int i = arr.length - 2; i >= 0; i--){
            for(int j = arr[0].length - 2; j >= 0; j--){
                if(arr[i][j] == 0)dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}