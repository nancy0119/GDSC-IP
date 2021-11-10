// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/kernighans-algo-official/ojquestion

import java.util.*;

public class kernighansAlgo {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int count = 0;
    while(n != 0){
        int rsbm = n & -n;
        count += 1;
        n -= rsbm;
    }
    System.out.println(count);
    scn.close();
  }

}