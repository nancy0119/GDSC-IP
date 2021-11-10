// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/all-repeating-except-two-official/ojquestion

import java.io.*;
import java.util.*;

public class exceptTwo {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
    scn.close();    
  }

  public static void solution(int[] arr){
   //write your code here
   int ans = 0;
   for(int no : arr)ans = ans ^ no;
   int rsbm = (ans & (-ans));
   int xor1 = 0;
   int xor0 = 0;
   for(int no : arr){
       if((no & rsbm) == rsbm) xor1 ^= no;
       else if((no & rsbm) == 0) xor0 ^= no;
   }
   if(xor0 < xor1){
       int temp = xor1;
       xor1 = xor0;
       xor0 = temp;
   }
   System.out.println(xor1);
   System.out.println(xor0);
  }

}