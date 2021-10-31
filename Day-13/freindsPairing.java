// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/friends-pairing-2-official/ojquestion

import java.io.*;
import java.util.*;

public class freindsPairing {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
    // write your code here
    if(i > n){
        System.out.println(counter + "." + asf);
        counter++;
        return;
    }
    if(used[i])solution(i + 1, n, used, asf);
    else{
    used[i] = true;
    // single
    solution(i + 1, n, used, asf + "(" + i + ") ");
    // pair
    for(int idx = i + 1; idx <= n; idx++){
        if(!used[idx]){
            used[idx] = true;
            solution(i + 1, n, used, asf +  "(" + i + "," + idx + ") ");
            used[idx] = false;
        }
    }
    used[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}
