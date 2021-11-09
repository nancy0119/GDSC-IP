// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/print-value-of-rsb-mask-official/ojquestion

import java.io.*;
import java.util.*;

public class rsbm {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //write your code here
    // System.out.println(Integer.toBinaryString(n & (~n + 1)));
    System.out.println(Integer.toBinaryString(n & -n));
    scn.close();
  }

}