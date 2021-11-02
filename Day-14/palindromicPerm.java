// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/all-palindromic-permutations-official/ojquestion

import java.io.*;
import java.util.*;

public class palindromicPerm {
    public static String reverse(String s){
        String ans = "";
        for(int i = s.length() - 1; i >= 0; i--)ans += s.charAt(i);
        return ans;
    }
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		if(cs == ts + 1){
        System.out.print(asf);
        if(oddc != '\0')System.out.print(oddc);
        System.out.println(reverse(asf));
        return;
    }
    Set<Character> keys = fmap.keySet();
    for(Character key : keys){
        if(fmap.get(key) != 0){
            fmap.put(key, fmap.get(key) - 1);
            generatepw(cs + 1, ts, fmap, oddc, asf + key);
            fmap.put(key, fmap.get(key) + 1);
        }
    }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		//write your code here
		String odd = getOddChr(fmap);
		if(odd.length() == 0)generatepw(1, str.length() / 2, fmap, '\0', "");
		else if(odd.length() == 1)generatepw(1, str.length() / 2, fmap, odd.charAt(0), ""); 
		else System.out.println(-1);
	}
	public static String getOddChr(HashMap<Character, Integer> freq){
	    String odd = "";
	    for(Character key : freq.keySet()){
	        int value = freq.get(key);
	        if(value % 2 != 0)odd += key;
	        freq.put(key, value / 2);
	    }
	    return odd;
	}
	
}