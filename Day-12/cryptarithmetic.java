// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/cryptarithmetic-official/ojquestion

import java.util.*;

public class cryptarithmetic {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

  
  public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3) {
	    // write your code here
	    if(idx == unique.length()){
	        if(check(s1, s2, s3, charIntMap))print(unique, charIntMap);
	        return;
	    }
	    for(int i = 0; i <= 9; i++){
	        if(!usedNumbers[i]){
	            usedNumbers[i] = true;
	            charIntMap.put(unique.charAt(idx), i);
	            solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
	            charIntMap.put(unique.charAt(idx), -1);
	            usedNumbers[i] = false;
	        }
	    }
  }
  public static void print(String unique, HashMap<Character, Integer> charIntMap){
      char arr [] = unique.toCharArray();
      Arrays.sort(arr);
      for(char ch : arr){
          System.out.print(ch + "-" + charIntMap.get(ch) + " ");
      }
      System.out.println();
  }
  public static boolean check(String s1, String s2, String s3, HashMap<Character, Integer> charIntMap){
      int no1 = convertNo(s1, charIntMap);
      int no2 = convertNo(s2, charIntMap);
      int no3 = convertNo(s3, charIntMap);
      return no1 + no2 == no3;
  }
  public static int convertNo(String s, HashMap<Character, Integer> charIntMap){
      int ans = 0;
      for(int i = 0; i < s.length(); i++){
          ans = ans * 10 + charIntMap.get(s.charAt(i));
      }
      return ans;
  }
  

}
