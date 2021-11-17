// Link  - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/xor-sum-pair-official/ojquestion

import java.io.*;
import java.util.*;

public class xorSumPairs {

    public static int solution(int[] arr){
       //write your code here
       int xor = 0;
       for(int i= 0; i < arr.length; i++){
           xor ^= 2 * arr[i];
       }
       return xor;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}