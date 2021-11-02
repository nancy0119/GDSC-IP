// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/all-palindromic-partitions-official/ojquestion

import java.io.*;
import java.util.*;

public class palinPartition {

	public static void solution(String str, String asf, int idx) {
		//write you code here
		if(idx == str.length()){
		    System.out.println(asf);
		    return;
		}
		for(int i = idx + 1; i <= str.length(); i++){
		    if(isPalindrome(str.substring(idx, i)))
		    solution(str, asf + "(" + str.substring(idx, i) + ") ", i);
		}
	}
	public static boolean isPalindrome(String s){
	    int i = 0;
	    int j = s.length() - 1;
	    while(i < j){
	        if(s.charAt(i++) != s.charAt(j--))
	        return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "", 0);
	}

}