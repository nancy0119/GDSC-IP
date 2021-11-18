// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/flip-bits-to-convert-a-to-b-official/ojquestion

import java.io.*;
import java.util.*;

public class flipBits {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    //write your code here
    
    // M-1
    // int count = 0;
    // for(int i = 0; i < 32; i++){
    //     int mask = (1 << i);
    //     if((a & mask) != (b & mask))count++; 
    // }
    // System.out.println(count);
    
    // M-2
    System.out.println(setBits(a ^ b));
  }
  public static int setBits(int no){
      int ans = 0;
      while(no != 0){
          int rsbm = (no & -no);
          no -= rsbm;
          ans++;
      }
      return ans;
  }

}