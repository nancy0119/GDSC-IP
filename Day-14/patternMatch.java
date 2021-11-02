// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/pattern-matching-official/ojquestion

import java.io.*;
import java.util.*;

public class patternMatch {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//write your code here
// 		op - original pattern
		if(pattern.length() == 0){
		if(str.length() == 0){
		    HashSet<Character> alreadyPrint = new HashSet<>();
	        for(Character key : op.toCharArray()){
	            if(!alreadyPrint.contains(key)){
	                System.out.print(key + " -> " + map.get(key) +", ");
	                alreadyPrint.add(key);
	            }
		    }
		    System.out.println(".");
		 }
		 return;
		}
		String value = map.get(pattern.charAt(0));
		if(value != null){
		    if(str.length() >=  value.length()){
		        String prefix = str.substring(0, value.length());
		        String ros = str.substring(value.length());
		        if(prefix.equals(value))
		        solution(ros, pattern.substring(1), map, op);
		    }
		}
		else{
		    for(int i = 1; i <= str.length(); i++){
		    String ros = str.substring(i);
		    String curr = str.substring(0, i);
		    map.put(pattern.charAt(0), curr);
		    solution(ros, pattern.substring(1), map, op);
		    map.remove(pattern.charAt(0));
		}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}