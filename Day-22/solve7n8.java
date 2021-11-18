// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/solve-7nby8-official/ojquestion

import java.io.*;
import java.util.*;

public class solve7n8 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    System.out.println(((n << 3) - n) >> 3);
  }

}