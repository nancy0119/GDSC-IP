// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/is-a-power-of-2-official/ojquestion

import java.io.*;
import java.util.*;

public class isPower2 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    
    // M-1 
    // if((n & (n - 1)) == 0)System.out.println(true);
    // else System.out.println(false);
    
    // M-2
    if(getSetBits(n) == 1)System.out.println(true);
    else System.out.println(false);
  }
  public static int getSetBits(int n){
      int count = 0;
      while(n != 0){
          int rsbm = (n & -n);
          n -= rsbm;
          count++;
      }
      return count;
  }

}