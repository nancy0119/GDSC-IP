// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/swap-all-odd-and-even-bits-official/ojquestion

import java.io.*;
import java.util.*;

public class swapOddEven {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    int maskEven = 0b10101010101010101010101010101010;
    int maskOdd = 0b01010101010101010101010101010101;
    // int maskEven = 0xAAAAAAAA;
    // int maskOdd = 0x55555555;
    maskEven = (maskEven & n) >> 1;
    maskOdd = (maskOdd & n) << 1;
    System.out.println(maskEven | maskOdd);
  }

}