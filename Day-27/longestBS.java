// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lbs-official/ojquestion

import java.io.*;
import java.util.*;

public class longestBS {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i = 0; i < n; i++)arr[i] = s.nextInt();
        int idp [] = new int[n];
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] <= arr[i] && idp[prev] > val)val = idp[prev];
            }
            idp[i] = val + 1;
        }
        int ddp [] = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int val = 0;
            for(int next = n - 1; next > i; next--){
                if(arr[next] <= arr[i] && ddp[next] > val)val = ddp[next];
            }
            ddp[i] = val + 1;
        }
        int ans = 0;
        for(int i = 0; i < n; i++)ans = Math.max(ans, idp[i] + ddp[i] - 1);
        System.out.println(ans);
    }

}