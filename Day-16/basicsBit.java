// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/basics-of-bit-official/ojquestion

import java.io.*;
import java.util.*;

public class basicsBit {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    System.out.println(set(n, i));
    System.out.println(unset(n, j));
    System.out.println(toggle(n, k));
    System.out.println(isOn(n, m));
    scn.close();
  }
  public static int set(int n, int i){
      int mask = (1 << i);
      return n | mask;
  }
  public static int unset(int n, int j){
      int mask = ~(1 << j);
      return n & mask;
  }
  public static int toggle(int n, int k){
      int mask = (1 << k);
      return n ^ mask;
  }
  public static boolean isOn(int n, int m){
      int mask = (1 << m);
      return ((n & mask) == 0 ? false : true);
  }

}