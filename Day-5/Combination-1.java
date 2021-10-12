// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/combinations-i-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    // write your code here
    // cb - current box;
    // tb - total boxes;
    // ssf - selections so far;
    // ts - total selections;
    // asf - answer so far;
    if(cb == tb + 1){
        if(ssf == ts) System.out.println(asf);
        return;
    }
    combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    combinations(cb + 1, tb, ssf, ts, asf + "-");
    return;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}