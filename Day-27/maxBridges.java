// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion

import java.io.*;
import java.util.*;

public class maxBridges {
    public static class Bridge implements Comparable<Bridge>{
        int nr;
        int su;
        Bridge(int nr, int su){
            this.nr = nr;
            this.su = su;
        }
        public int compareTo(Bridge o){
            if(this.nr != o.nr)return this.nr - o.nr;
            else return this.su - o.su;
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Bridge arr[] = new Bridge[n];
        for(int i = 0; i < n; i++){
            String [] st = s.nextLine().split(" ");
            int nr = Integer.parseInt(st[0]);
            int su = Integer.parseInt(st[1]);
            arr[i] = new Bridge(nr, su);
        }
        Arrays.sort(arr);
        int dp[] = new int[n];
        int omax = 0;
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int prev = 0; prev < i; prev++){
                if(arr[i].su  >= arr[prev].su && dp[prev] > val)
                val = dp[prev];
            }
            dp[i] = val + 1;
            omax = Math.max(omax, dp[i]);
        }
        System.out.println(omax);
    }

}