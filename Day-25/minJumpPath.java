// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-jumps-re-official/ojquestion
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class minJumpPath{
    public static class Pair{
        int idx;
        String psf;
        Pair(int idx, String psf){
            this.idx = idx;
            this.psf = psf;
        }
    }
    public static void Solution(int arr[]){
        // write your code here
        
        // Made dp of min jumps
        Integer dp[] = new Integer [arr.length];
        dp[arr.length - 1] = 0;
        for(int i = arr.length - 2; i >= 0; i--){
            dp[i] = Integer.MAX_VALUE;
            for(int jmp = 1; jmp <= arr[i]; jmp++){
                int nextPos  = i + jmp;
                if(nextPos < arr.length && dp[nextPos] < dp[i])dp[i] = dp[nextPos] + 1;
            }
        }
        System.out.println(dp[0]);
        // Printing path
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0,"0"));
        while(queue.size() > 0){
            Pair p = queue.removeFirst();
            if(dp[p.idx] == 0){
                System.out.println(p.psf + " .");
            }
            for(int i = 1; i <= arr[p.idx] && p.idx + i < arr.length; i++){
                int nextPos = i + p.idx;
                // very imp condition
                if(dp[p.idx] - 1 == dp[nextPos])
                queue.add(new Pair(nextPos, p.psf + " -> " + nextPos));
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
