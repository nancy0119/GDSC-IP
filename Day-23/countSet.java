// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/count-setbits-in-first-n-natural-numbers-official/ojquestion

import java.io.*;
import java.util.*;

public class countSet {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

  public static int solution(int n){
    //write your code here
    if(n == 0)return 0;
    int exp = getExp(n);
    int power = (1 << exp);
    return ((power / 2) * exp) + (n - power + 1) + solution(n - power);
  }  
public static int getExp(int n){
    int exp = 0;
    while((1 << exp) <= n){
        exp++;
    }
    return exp - 1;
}
}