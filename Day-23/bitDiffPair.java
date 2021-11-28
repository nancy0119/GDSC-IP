// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/sum-of-bit-differences-of-all-pairs-official/ojquestion
import java.io.*;
import java.util.*;

public class bitDiffPair {

  public static long solution(int[] arr){
    //write your code here
    long ans = 0;
    // Earlier approach gave TLE
    for(int i = 0; i < 32; i++){
        int mask = 1 << i;
        long setBits = 0;
        long off = 0;
        for(int var : arr){
            if((mask & var) != 0)setBits++;
            else off++;
        }
        ans += (setBits * off * 2);
    }
    return ans;
  }
  
public static int getBitDiff(int n1, int n2){
    int count = 0;
    for(int i = 0; i < 32; i++){
        int mask = 1 << i;
        if((n1 & mask) != (n2 & mask))count++;
    }
    return count;
}

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}