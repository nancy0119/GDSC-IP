// Link - https://www.geeksforgeeks.org/minimum-maximum-values-expression/
import java.util.*;

public class maxMin{
    public static class Pair{
        int max = 0;
        int min = (int)1e9;
        Pair(){

        }
        Pair(int val){
            this.min = this.max = val;
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        int n = st.length();
        Pair p = solution(st, 0, st.length() - 1, new Pair[n][n]);
        System.out.println(p.max);
        System.out.println(p.min);
        s.close();
    }
    public static Pair solution (String s, int si, int ei, Pair[][]dp){
        // base case
        if(ei == si)return dp[si][ei] = new Pair(s.charAt(ei) - '0');
        if(dp[si][ei] != null)return dp[si][ei];
        Pair myres = new Pair();
        for(int cut = si + 1; cut <= ei; cut += 2){
            Pair right = solution(s, cut + 1, ei, dp);
            Pair left = solution(s, si, cut - 1, dp);
            Pair ans = cal(s, cut, left, right);
            myres.min = Math.min(myres.min, ans.min);
            myres.max = Math.max(myres.max, ans.max);
        }
        dp[si][ei] = myres;
        return dp[si][ei];
    }
    public static Pair cal(String s, int cut, Pair left, Pair right){
        Pair ans = new Pair();
        if(s.charAt(cut) == '*'){
            ans.max = left.max * right.max;
            ans.min = left.min * right.min;
        }
        else {
            ans.max = left.max + right.max;
            ans.min = left.min + right.min;
        }
        return ans;
    }
}