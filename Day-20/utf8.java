// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/utf-8-encoding-official/ojquestion 

import java.io.*;
import java.util.*;

public class utf8 {

    public static boolean solution(int[] arr) {
        //write your code here
        int rbytes = 0;
        for(int i = 0; i < arr.length; i++){
            if(rbytes == 0){
                if((arr[i] >> 7) == 0b0)rbytes = 0;
                else if((arr[i] >> 5) == 0b110)rbytes = 1;
                else if((arr[i] >> 4) == 0b1110)rbytes = 2;
                else if((arr[i] >> 3) == 0b11110)rbytes = 3;
            }
            else{
                if((arr[i] >> 6) == 0b10)rbytes--;
                else return false;
            }
        }
        return true;
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