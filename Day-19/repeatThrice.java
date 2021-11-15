// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/all-repeating-three-times-except-one-official/ojquestion

import java.io.*;
import java.util.*;

public class repeatThrice {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   int n3 = Integer.MAX_VALUE;
   int n3p1 = 0;
   int n3p2 = 0;
   for(int i = 0; i < arr.length; i++){
       int and = (n3 & arr[i]);
       int and1 = (n3p1 & arr[i]);
       int and2 = (n3p2 & arr[i]);
       
       n3 = (n3 & ~and);
       n3p1 = n3p1 | and;
       
       n3p1 = (n3p1 & ~and1);
       n3p2 = n3p2 | and1;
       
       n3p2 = (n3p2 & ~and2);
       n3 = n3 | and2;
   }
   System.out.println(n3p1);
  }

}