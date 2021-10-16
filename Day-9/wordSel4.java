// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-kselection-4-official/ojquestion

import java.io.*;
import java.util.*;

public class wordSel4 {

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    combinations(unique, ustr, "", 0, k, 0);
   
  }
  public static void combinations(HashMap<Character, Integer> unique, String ustr, String ans, int iter, int k, int idx){
      if(iter == k){
          System.out.println(ans);
          return;
      }
      for(int i = idx; i < ustr.length(); i++){
          char ch = ustr.charAt(i);
          if(unique.get(ch) > 0){
              unique.put(ch, unique.get(ch) - 1);
              combinations(unique, ustr, ans + ch, iter + 1, k, i);
              unique.put(ch, unique.get(ch) + 1);
          }
      }
  }

}