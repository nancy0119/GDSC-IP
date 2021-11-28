// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/print-binary-and-reverse-bits-official/ojquestion

import java.io.*;
import java.util.*;

public class pritnBinReverse {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    boolean isStart = false;
    int reversed = 1;
    int j = 1;
    for(int i = 31; i >= 0; i--){
        int mask = 1 << i;
        if(isStart){
            if((mask & n) != 0){
                System.out.print(1);
                reversed |= (1 << j);
            }
            else System.out.print(0);
            j++;
        }
        else{
            if((mask & n) != 0){
                isStart = true;
                System.out.print(1);
            }
        }
    }
    System.out.println();
    System.out.println(reversed);
  }
  public static String getBinaryString(int n){
    StringBuilder noB = new StringBuilder();
    while(n == 0){
        noB.append(n % 2);
        n /= 2;
    }
    return noB.reverse().toString();
  }

}