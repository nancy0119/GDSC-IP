// Link1 - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/burst-balloons-official/ojquestion
// Link2 - https://leetcode.com/problems/burst-balloons/
import java.io.*;
import java.util.*;

public class burstBalloon {

  public static int solution(int[] nums) {
    //write your code here
    return maxCoinsT(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
  }
  public static int maxCoinsT(int [] nums, int si, int ei, int[][]dp){
        if(dp[si][ei] != 0)return dp[si][ei];
        int maxCoin = 0;
        int lele = (si == 0) ? 1 : nums[si - 1];
        int rele = (ei == nums.length - 1) ? 1 : nums[ei + 1];
        for(int cut = si; cut <= ei; cut++){
            int currAns = 0;
            int leftCost = (cut == si) ? 0 : maxCoinsT(nums, si, cut - 1, dp);
            int rightCost = (cut == ei) ? 0 : maxCoinsT(nums, cut + 1, ei, dp);
            currAns = leftCost + rightCost;
            currAns += lele * nums[cut] * rele;
            maxCoin = Math.max(maxCoin, currAns);
        }
        dp[si][ei] = maxCoin;
        return dp[si][ei];
    }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}