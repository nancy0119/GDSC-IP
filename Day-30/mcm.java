// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/matrix-chain-multiplication-official/ojquestion

import java.io.*;
import java.util.*;

public class mcm {

	public static int mcmSolution(int[] arr){
		//write your code here
// 		tab
        // return mcmM(arr, 0, arr.length - 1, new int [arr.length][arr.length]);
//      dp
        return mcmT(arr);
	}
	public static int mcmT(int[] arr){
        int n = arr.length;
        int dp[][] = new int [n][n];
        for(int gap = 2; gap < n; gap++){
            for(int si = 0, ei = gap; ei < n; si++, ei++){
                int minans = (int)1e9;
                for(int cut = si + 1; cut < ei; cut++){
                    int leftans = mcmM(arr, si, cut, dp);
                    int rightans = mcmM(arr, cut, ei, dp);
                    minans = Math.min(minans, leftans + arr[si] * arr[cut] * arr[ei] + rightans);
                }
                dp[si][ei] = minans;
            }
        }
        return dp[0][n - 1];
    }
	public static int mcmM(int [] arr, int si, int ei, int[][] dp){
        if(ei - si == 1)return dp[si][ei] = 0;
        if(dp[si][ei] != 0)return dp[si][ei];
        int minans = (int)1e9;
        for(int cut = si + 1; cut < ei; cut++){
            int leftans = dp[si][cut];
            int rightans = dp[cut][ei];
            minans = Math.min(minans, leftans + arr[si] * arr[cut] * arr[ei] + rightans);
        }
        dp[si][ei] = minans;
        return dp[si][ei];
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcmSolution(arr));
	}

	
}