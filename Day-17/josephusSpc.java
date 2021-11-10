// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/josephus-special-official/ojquestion

import java.util.*;

public class josephusSpc {
  public static int powOf2(int n){
      int i = 1;
      while(i * 2 <= n){
        i *= 2;
      }
      return i;
  }
  public static int solution(int n){
    //write your code here
    int power = powOf2(n);
    int rem = n % power;
    return 2 * rem + 1;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
    scn.close();
  }
  

}