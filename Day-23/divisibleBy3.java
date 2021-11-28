// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/check-divisibility-by-3-official/ojquestion

import java.io.*;
import java.util.*;

public class divisibleBy3 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    //write your code here
    int sumOdd = 0;
    int sumEven = 0;
    for(int i = 0; i < str.length(); i++){
        int bit = str.charAt(i) - '0';
        if(i % 2 == 0)sumEven += bit;
        else sumOdd += bit;
    }
    if((sumEven - sumOdd) % 11 == 0)System.out.println(true);
    else System.out.println(false);
  }

}