// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/remove-invalid-parenthesis-official/ojquestion

import java.io.*;
import java.util.*;

public class removeInvalidParen {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		//write your code here
		if(minRemoval == 0){
		    int minNow = getMin(str);
		    if(minNow == 0 && !ans.contains(str)){
		        System.out.println(str);
		        ans.add(str);
		    }
		    return;
		}
		for(int i = 0; i < str.length(); i++){
		    solution(str.substring(0, i) + str.substring(i + 1), minRemoval - 1, ans);
		}
	}

	public static int getMin(String str){
		//write your code here
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < str.length(); i++){
		    if(str.charAt(i) == '(')st.push('(');
		    else{
		        if(!st.isEmpty() && st.peek() == '(')st.pop();
		        else st.push(')');
		    }
		}
		return st.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
	}
		
}