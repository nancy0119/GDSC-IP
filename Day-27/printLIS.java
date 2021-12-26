// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-re-official/ojquestion

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class printLIS{
        public static class Pair {
        int l;
        int i;
        String psf;
        
        Pair(int l, int i, String psf){
            this.l = l;
            this.i = i;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
    // write your code here
    
    // fill dp
    int dp[] = new int [arr.length];
    int omax = 0;
    ArrayList<Integer> oIdx = new ArrayList<>();
    for(int i = 0; i < arr.length; i++){
        int val = 0;
        for(int prev = 0; prev < i; prev++){
            if(arr[prev] < arr[i])val = Math.max(val, dp[prev]);
        }
        dp[i] = val + 1;
        
        if(omax < dp[i]){
            omax = dp[i];
            oIdx = new ArrayList<>();
            oIdx.add(i);
        }
        else if(omax == dp[i])oIdx.add(i);
    }
    System.out.println(omax);
    
    // print path
    for(int i = 0; i < oIdx.size(); i++){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(omax - 1, oIdx.get(i), "" + arr[oIdx.get(i)]));
        while(queue.size() > 0){
            Pair p = queue.removeFirst();
            if(p.l == 0)System.out.println(p.psf);
            else{
                for(int prev = p.i - 1 ; prev >= 0; prev--){
                    if(dp[prev] + 1== dp[p.i] && arr[prev] < arr[p.i])
                    queue.add(new Pair(dp[prev] - 1, prev, arr[prev] + " -> " + p.psf));
                }
                
            }
        }
    }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}