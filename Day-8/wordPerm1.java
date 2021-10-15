// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-1-official/ojquestion

import java.io.*;
import java.util.*;

public class wordPerm1 {

  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
    // write your code here
    if(cs == ts + 1){
        System.out.println(asf);
        return;
    }
    Set<Character> keys = fmap.keySet();
    for(Character key : keys){
        if(fmap.get(key) != 0){
            fmap.put(key, fmap.get(key) - 1);
            generateWords(cs + 1, ts, fmap, asf + key);
            fmap.put(key, fmap.get(key) + 1);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for(char ch: str.toCharArray()){
      if(fmap.containsKey(ch)){
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }

}