// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/reduce-n-to-1-official/ojquestion

import java.io.*;
import java.util.*;

public class reduceN {

    public static int solution(long n) {
        //write your code here
        int no = 0;
        while(n != 1){
            if(n % 2 == 0) n /= 2;
            else if(n == 3)n = 2;
            // else if(n % 4 == 1) n --;
            else if((n & 3) == 1) n--;
            else if((n & 3) == 3) n++;
            no++;
        }
        return no;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}