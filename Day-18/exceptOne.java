// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/all-repeating-except-one-official/ojquestion

import java.io.*;
import java.util.*;

public class exceptOne {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    //write your code here
    int ans = 0;
    for(int no : arr)ans = ans ^ no;
    System.out.println(ans);
  }

}