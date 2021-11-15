// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/one-repeating-and-one-missing-official/ojquestion

import java.io.*;
import java.util.*;

public class missRepeat {

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
   int xor = 0;
   for(int no : arr)xor ^= no;
   for(int i = 1; i <= arr.length; i++)xor ^= i;
   int rsbm = (xor & -xor);
   int xor1 = 0;
   int xor0 = 0;
   for(int no : arr){
       if((no & rsbm) == rsbm)xor1 ^= no;
       else if((no & rsbm) == 0)xor0 ^= no;
   }
   for(int i = 1; i <= arr.length; i++){
       if((i & rsbm) == rsbm)xor1 ^= i;
       else if((i & rsbm) == 0)xor0 ^= i;
   }
   int miss = xor1;
   int repeat = xor0;
   for(int no : arr){
       if(no == xor1){
           miss = xor0;
           repeat = xor1;
       }
   }
   System.out.println("Missing Number -> " + miss);
   System.out.println("Repeating Number -> " + repeat);
  }

}