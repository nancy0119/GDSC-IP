// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/coin-change-combinations-2-official/ojquestion

import java.io.*;
import java.util.*;

public class coinC2 {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        // write your code here
        if(i == coins.length){
            if(amtsf == tamt)System.out.println(asf + ".");
            return;
        }
        for(int idx = tamt / coins[i]; idx >= 1; idx--){
            String part = "";
            for(int j = 0; j < idx; j++)part += coins[i] + "-";
            coinChange(i + 1, coins, amtsf + coins[i] * idx, tamt, asf + part);
        }
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}