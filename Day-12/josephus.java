// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/josephus-problem-official/ojquestion

import java.util.*;

public class josephus {

  public static int solution(int n, int k){
    //write your code here
    if(n == 1) return 0;
    int sol = solution(n - 1, k);
    return (sol + k) % n;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
  

}