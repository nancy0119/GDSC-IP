// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/max-score-official/ojquestion

import java.io.*;
import java.util.*;

public class maxScore {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		if(idx == words.length)
		    return 0;
		    
		int noSol = solution(words, farr, score, idx + 1);
		
		int finalScore = 0;
		boolean flag = true;
		for(int i = 0; i < words[idx].length(); i++){
		    farr[words[idx].charAt(i) - 'a'] -= 1;
		    finalScore += score[words[idx].charAt(i) - 'a'];
		    if(farr[words[idx].charAt(i) - 'a'] < 0) flag = false;
		    
		}
		int yesSol = 0;
		if(flag) yesSol = finalScore + solution(words, farr, score, idx + 1);
		
		
		for(int i = 0; i < words[idx].length(); i++){
		    farr[words[idx].charAt(i) - 'a'] += 1;
		}
		return Math.max(noSol, yesSol);
	}
	

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}