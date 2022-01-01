// Link1 - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/optimal-bst-official/ojquestion
// Link2 - https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1#
import java.io.*;
import java.util.*;

public class optimalBST {
  
  private static int optimalbst(int[] keys, int[] freq, int n) {
    //write your code here
    return ostT(keys, freq, n, new int[n][n], 0, n - 1);
	}
    public static int ostT(int keys[], int freq[], int n, int [][] dp, int si, int ei){
        if(dp[si][ei] != 0)return dp[si][ei];
        int minCost = (int)1e9;
        int currCost = 0;
        for(int cut = si; cut <= ei; cut++){
            int left = cut == si ? 0 : ostT(keys, freq, n, dp, si, cut - 1);
            int right = cut == ei ? 0 : ostT(keys, freq, n, dp, cut + 1, ei);
            currCost += freq[cut];
            minCost = Math.min(minCost, left + right);
        }   
        dp[si][ei] = minCost + currCost;
        return dp[si][ei];
    }
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
	System.out.println(optimalbst(keys,frequency,n));
	}

}