// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/largest-number-at-most-k-swaps-official/ojquestion

import java.io.*;
import java.util.*;

public class largestNo {

	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		if(Integer.parseInt(str) > Integer.parseInt(max))max = str;
		if(k == 0) return;
		for(int i = 0; i < str.length() - 1; i++){
		    for(int j = i + 1; j < str.length(); j++){
		        char first = str.charAt(i);
		        char second = str.charAt(j);
		        if(first < second)findMaximum(str.substring(0, i) + second + str.substring(i + 1, j) + first + str.substring(j + 1), k - 1);
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
        scn.close();
	}

}