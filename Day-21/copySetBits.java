// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/copy-set-bits-in-a-range-official/ojquestion

import java.io.*;
import java.util.*;

public class copySetBits {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

   //write your code here
//   M - 1
    // for(int i = left; i <= right; i++){
    //     b |= (a & (1 << (i - 1)));
    // }
    
    
// M - 2 imp
    int mask = (1 << (right - left + 1));
    mask--;
    mask = (mask << (left - 1));
    System.out.println((mask & a) | b);
  }

}