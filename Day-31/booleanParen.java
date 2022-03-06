// Link1 - https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
// Link2 - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/boolean-parenthesization-official/ojquestion
import java.io.*;
import java.util.*;

public class booleanParen {
    public static class Pair{
        long falseC;
        long trueC;
        Pair(long falseC, long trueC){
            this.falseC = falseC;
            this.trueC = trueC;
        }
        Pair(){
            
        }
    }
	public static int solution(String str1, String str2) {
		//write your code here
		int N = str1.length();
        Pair p = countWaysT(str1, str2, 0, N - 1, new Pair[N][N]);
        return (int)p.trueC;
	}
    public static Pair countWaysT(String str1, String str2, int si, int ei, Pair[][]dp){
        if(dp[si][ei] != null)return dp[si][ei];
        if(si == ei){
            char ch = str1.charAt(si);
            if(ch == 'T')return dp[si][ei] = new Pair(0, 1);
            else return dp[si][ei] = new Pair(1, 0);
        }
        Pair total = new Pair();
        long mod = 1003;
        for(int cut = si + 1; cut <= ei; cut++){
            Pair left = countWaysT(str1, str2, si, cut - 1, dp);
            Pair right = countWaysT(str1, str2, cut, ei, dp);
            Pair ans = cal(left, str2.charAt(cut - 1), right);
            total.falseC += ans.falseC;
            total.trueC += ans.trueC;
        }
        dp[si][ei] = total;
        return dp[si][ei];
    }
    public static Pair cal(Pair left, char ch, Pair right){
        long mod = 1003;
        Pair ans = new Pair();
        if(ch == '&'){
            ans.trueC =  (left.trueC * right.trueC);
            ans.falseC = (left.falseC * right.falseC + left.trueC * right.falseC + left.falseC * right.trueC);
        }
        else if(ch == '|'){
            ans.trueC =  (left.trueC * right.trueC + left.trueC * right.falseC + left.falseC * right.trueC);
            ans.falseC = (left.falseC * right.falseC);
        }
        else if(ch == '^'){
            ans.trueC = (left.trueC * right.falseC + left.falseC * right.trueC);
            ans.falseC = (left.trueC * right.trueC + left.falseC * right.falseC);
        }
        return ans;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}