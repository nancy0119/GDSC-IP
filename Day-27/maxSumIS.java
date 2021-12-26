// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/msis-official/ojquestion

import java.io.*;
import java.util.*;

public class maxSumIS {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)arr[i] = s.nextInt();
        int dp[] = new int[n];
        int omax = 0;
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int prev = 0; prev < i; prev++){
                if(arr[i] >= arr[prev] && dp[prev] > val)val = dp[prev];
            }
            dp[i] = val + arr[i];
            omax = Math.max(omax, dp[i]);
        }
        System.out.println(omax);
    }

}