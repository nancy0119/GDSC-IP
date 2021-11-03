// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/wordbreak1official/ojquestion

import java.io.*;
import java.util.*;

public class wordBreak1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
        scn.close();
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		// write your code here
		if(str.length() == 0){
		    System.out.println(ans);
		    return;
		}
		for(int i = 1; i <= str.length(); i++){
		    String prefix = str.substring(0, i);
		    String ros = str.substring(i);
		    if(dict.contains(prefix))wordBreak(ros, ans + prefix + " " , dict);
		}
	}
		
}